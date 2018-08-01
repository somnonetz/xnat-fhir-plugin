package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.bean.FhirPatientBean;
import org.nrg.xdat.model.*;
import org.nrg.xdat.om.*;
import org.nrg.xft.ItemI;
import org.nrg.xft.XFTTable;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.search.TableSearch;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.regex.MatchResult;

@Service
public class FhirPatientService extends DatatypeValidatable {
    /**
     * Return the name of the XNAT project where new Patient records will be published to
     * @param user User authenticated in the system
     * @return Name of subject project to associate with
     */
    @Nonnull
    public String getPatientProject(UserI user) {
        return "fhir";
    }

    /**
     * Search matching patient based on the subject id field
     * @param subjectId Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirPatientI record or null if none was found
     */
    @Nullable
    public FhirPatientI getPatientForSubject(String subjectId, UserI user) {
        return this.getFromDB("subject_ID", subjectId, user);
    }

    /**
     * Search matching patient based on the database id
     * @param id record id
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirPatientI record or null if none was found
     */
    @Nullable
    public FhirPatientI getPatient(Integer id, UserI user) {

        return this.getFromDB("ID", this.makeDatabaseId(id), user);
    }

    /**
     * Create a new patient record with the data provided
     * @param data Data to use to build the record
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirPatientI record or null if none was found
     */
    @Nullable
    public FhirPatientI createPatient(Map<String, Object> data, UserI user) {
        // Verify handed properties
        Collection<String> invalidProperties = this.validateProperties(data);
        if (invalidProperties != null) {
            _log.debug("Attribute validation failed for: " + invalidProperties);
            return null;
        }

        try {
            // Build subject record to associate the patient record with
            XnatSubjectdata subject = new XnatSubjectdata(user);
            subject.setId(this.makeSubjectId(subject, user));
            subject.setProject(this.getPatientProject(user));
            subject.setLabel("fhir_subject_" + subject.getId());

            if (!subject.save(user, true, false, null)) {
                _log.error("Failed to save subject record");
                return null;
            }

            // Create patient record and assign inherited attributes
            FhirPatient patient = new FhirPatient(user);
            patient.setId("FHIR_" + subject.getId());
            patient.setLabel("fhir_patient_" + subject.getLabel());
            patient.setProject(subject.getProject());

            // Assign basic attributes
            patient.setActive(data.get("active"));
            patient.setGender((String)data.get("gender"));
            patient.setBirthdate(data.get("birthDate"));

            FhirCodeableconceptI maritialStatus = _codeableConceptService.createCodeableConcept((HashMap<String, Object>)data.get("maritalStatus"), user);
            if (maritialStatus != null) {
                patient.setMaritalstatus(maritialStatus);
            }

            FhirReferenceI reference = _referenceService.createReference((HashMap<String, Object>)data.get("managingOrganization"), user);
            if (reference != null) {
                patient.setManagingorganization(reference);
            }

            // Check for deceased data (time preceeds boolean)
            if (data.get("deceasedDateTime") != null) {
                patient.setDeceased_deceaseddatetime(data.get("deceasedDateTime"));
            }
            else if (data.get("deceasedBoolean") != null) {
                patient.setDeceased_deceasedboolean(data.get("deceasedBoolean"));
            }

            // Check for multiple birth (integer preceeds boolean)
            if (data.get("multipleBirthInteger") != null) {
                patient.setMultiplebirth_multiplebirthinteger((Integer)data.get("multipleBirthInteger"));
            }
            else if (data.get("multipleBirthBoolean") != null) {
                patient.setMultiplebirth_multiplebirthboolean(data.get("multipleBirthBoolean"));
            }

            // Check if animal data is specified
            final HashMap<String, Object> animal = (HashMap<String, Object>)data.get("animal");
            if (animal != null) {
                patient.setAnimal_species(_codeableConceptService.createCodeableConcept((Map<String, Object>)animal.get("species"), user));
                FhirCodeableconceptI breed = _codeableConceptService.createCodeableConcept((Map<String, Object>)animal.get("breed"), user);
                if (breed != null) {
                    patient.setAnimal_breed(breed);
                }

                FhirCodeableconceptI genderStatus = _codeableConceptService.createCodeableConcept((Map<String, Object>)animal.get("genderStatus"), user);
                if (genderStatus != null) {
                    patient.setAnimal_genderstatus(genderStatus);
                }
            }

            // Map identities
            List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("identifier");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirIdentifierI identifier = _identityService.createIdentifier(item, user);
                    if (identifier == null) {
                        _log.error("Failed to construct identifier");
                        return null;
                    }
                    patient.addIdentifier(identifier);
                }
            }

            // Map names
            items = (List<Map<String, Object>>) data.get("name");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirHumannameI name = _nameService.createName(item, user);
                    if (name == null) {
                        _log.error("Failed to construct HumanName");
                        return null;
                    }
                    patient.addName(name);
                }
            }

            // Map contact point
            items = (List<Map<String, Object>>) data.get("telecom");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirContactpointI contactPoint = _contactPointService.createContactPoint(item, user);
                    if (contactPoint == null) {
                        _log.error("Failed to construct telecom contact point");
                        return null;
                    }
                    patient.addTelecom(contactPoint);
                }
            }

            // Map addresses
            items = (List<Map<String, Object>>) data.get("address");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirAddressI address = _addressService.createAddress(item, user);
                    if (address == null) {
                        _log.error("Failed to construct address");
                        return null;
                    }
                    patient.addAddress(address);
                }
            }

            // Map photos
            items = (List<Map<String, Object>>) data.get("photo");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirAttachmentI photo = _attachmentService.createAttachment(item, user);
                    if (photo == null) {
                        _log.error("Failed to construct photo");
                        return null;
                    }
                    patient.addPhoto(photo);
                }
            }

            // Map contacts
            items = (List<Map<String, Object>>) data.get("contact");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirPatientContactI contact = this.createContact(item, user);
                    if (contact == null) {
                        _log.error("Failed to construct contact");
                        return null;
                    }
                    patient.addContact(contact);
                }
            }

            // Map communications
            items = (List<Map<String, Object>>) data.get("communication");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirPatientCommunicationI communication = this.createCommunication(item, user);
                    if (communication == null) {
                        _log.error("Failed to construct communication");
                        return null;
                    }
                    patient.addCommunication(communication);
                }
            }

            // Map practitioner
            items = (List<Map<String, Object>>) data.get("generalPractitioner");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirReferenceI generalPractitioner = _referenceService.createReference(item, user);
                    if (generalPractitioner == null) {
                        _log.error("Failed to construct general practitioner");
                        return null;
                    }
                    patient.addGeneralpractitioner(generalPractitioner);
                }
            }

            // Map links
            items = (List<Map<String, Object>>) data.get("link");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirPatientLinkI link = this.createLink(item, user);
                    if (link == null) {
                        _log.error("Failed to construct link");
                        return null;
                    }
                    patient.addLink(link);
                }
            }

            subject.addExperiments_experiment(patient);
            patient.save(user, true, true, null);
            return patient;
        }
        catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Build the property map to transfer as a json request for the given patient
     * @param patient Patient entity to transfer
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    @Nullable
    public Map<String, Object> makePropertyMap(FhirPatientI patient, UserI user) {
        // A patient record should be present for export
        if (patient == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push identifiers
        ArrayList<Map<String, Object>> items = new ArrayList<>();
        for (FhirIdentifierI item : patient.getIdentifier()) {
            Datatypes.appendIfPresent(items, _identityService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "identifier", items);

        // Push names
        items = new ArrayList<>();
        for (FhirHumannameI item : patient.getName()) {
            Datatypes.appendIfPresent(items, _nameService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "name", items);

        // Push telecom
        items = new ArrayList<>();
        for (FhirContactpointI item : patient.getTelecom()) {
            Datatypes.appendIfPresent(items, _contactPointService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "telecom", items);

        // Push address
        items = new ArrayList<>();
        for (FhirAddressI item : patient.getAddress()) {
            Datatypes.appendIfPresent(items, _addressService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "address", items);

        // Push photo
        items = new ArrayList<>();
        for (FhirAttachmentI item : patient.getPhoto()) {
            Datatypes.appendIfPresent(items, _attachmentService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "photo", items);

        // Push contacts
        items = new ArrayList<>();
        for (FhirPatientContactI item : patient.getContact()) {
            Datatypes.appendIfPresent(items, this.makeContactPropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "contact", items);

        // Push communication
        items = new ArrayList<>();
        for (FhirPatientCommunicationI item : patient.getCommunication()) {
            Datatypes.appendIfPresent(items, makeCommunicationPropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "communication", items);

        // Push generalPractitioner
        items = new ArrayList<>();
        for (FhirReferenceI item : patient.getGeneralpractitioner()) {
            Datatypes.appendIfPresent(items, _referenceService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "generalPractitioner", items);

        // Push link
        items = new ArrayList<>();
        for (FhirPatientLinkI item : patient.getLink()) {
            Datatypes.appendIfPresent(items, makeLinkPropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "link", items);

        // Push simple elements
        Datatypes.addIfPresent(result, "active", patient.getActive());
        Datatypes.addIfPresent(result, "gender", patient.getGender());
        Datatypes.addIfPresent(result, "birthDate", patient.getBirthdate());
        Datatypes.addIfPresent(result, "maritalStatus", _codeableConceptService.makePropertyMap(patient.getMaritalstatus(), user));
        if (patient.getDeceased_deceaseddatetime() != null) {
            result.put("deceasedDateTime", patient.getDeceased_deceaseddatetime());
        }
        else if (patient.getDeceased_deceasedboolean() != null) {
            result.put("deceasedBoolean", patient.getDeceased_deceasedboolean());
        }

        if (patient.getMultiplebirth_multiplebirthinteger() != null) {
            result.put("multipleBirthInteger", patient.getMultiplebirth_multiplebirthinteger());
        }
        else if (patient.getMultiplebirth_multiplebirthboolean() != null) {
            result.put("multipleBirthBoolean", patient.getMultiplebirth_multiplebirthboolean());
        }

        if (patient.getAnimal_species() != null) {
            Map<String, Object> animal = new HashMap<>();
            animal.put("species", _codeableConceptService.makePropertyMap(patient.getAnimal_species(), user));
            Datatypes.addIfPresent(animal, " breed", _codeableConceptService.makePropertyMap(patient.getAnimal_breed(), user));
            Datatypes.addIfPresent(animal, " genderStatus", _codeableConceptService.makePropertyMap(patient.getAnimal_genderstatus(), user));
            result.put("animal", animal);
        }

        Datatypes.addIfPresent(result, "managingOrganization", _referenceService.makePropertyMap(patient.getManagingorganization(), user));

        return result;
    }

    /**
     * Return the ID of the patient
     * @param entity Entity to extract the ID from
     * @return integer of the patient
     */
    public Integer getPatientId(FhirPatientI entity) {
        final String databaseId  = entity.getId();
        final Scanner sc = new Scanner(databaseId);
        sc.findInLine("(\\d+)$");
        final MatchResult result = sc.match();
        return Integer.parseInt(result.group(0));
    }

    /**
     * Build a new patient contact out of the given data
     * @param data JSON data submitted to create the new patient contact
     * @param user user that requested the identifier creation
     * @return new patient contact object
     */
    private FhirPatientContactI createContact(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        // Verify handed properties
        if (this.validateProperties(data) == null) {
            _log.debug("Attribute validation failed");
            return null;
        }

        try {
            // Build the result object
            FhirPatientContact result = new FhirPatientContact(user);
            FhirCodeableconceptI relationship = _codeableConceptService.createCodeableConcept((Map<String, Object>)data.get("relationship"), user);
            if (relationship != null) {
                result.setRelationship(relationship);
            }
            result.setGender((String) data.get("gender"));

            FhirHumannameI name = _nameService.createName((Map<String, Object>)data.get("name"), user);
            if (name != null) {
                result.setName(name);
            }

            FhirAddressI address = _addressService.createAddress((Map<String, Object>)data.get("address"), user);
            if (address != null) {
                result.setAddress(address);
            }

            FhirReferenceI reference = _referenceService.createReference((Map<String, Object>)data.get("organization"), user);
            if (reference != null) {
                result.setOrganization(reference);
            }

            // Map contact point
            List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("telecom");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirContactpointI contactPoint = _contactPointService.createContactPoint(item, user);
                    if (contactPoint == null) {
                        _log.error("Failed to construct telecom contact point");
                        return null;
                    }
                    result.addTelecom(contactPoint);
                }
            }

            Map<String, Object> period = (Map<String, Object>)data.get("period");
            if (period != null) {
                result.setPeriod_start(period.get("start"));
                result.setPeriod_end(period.get("end"));
            }

            return result;
        }
        catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Build a new patient communication out of the given data
     * @param data JSON data submitted to create the new patient communication
     * @param user user that requested the identifier creation
     * @return new patient communication object
     */
    private FhirPatientCommunicationI createCommunication(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        try {
            // Build the result object
            FhirPatientCommunication result = new FhirPatientCommunication(user);
            FhirCodeableconceptI language = _codeableConceptService.createCodeableConcept((Map<String, Object>)data.get("language"), user);
            if (language != null) {
                result.setLanguage(language);
            }
            result.setPreferred(data.get("preferred"));

            return result;
        }
        catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Build a new link out of the given data
     * @param data JSON data submitted to create the new link
     * @param user user that requested the identifier creation
     * @return new link object
     */
    private FhirPatientLinkI createLink(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        try {
            // Build the result object
            FhirPatientLink result = new FhirPatientLink(user);
            FhirReferenceI reference = _referenceService.createReference((Map<String, Object>)data.get("other"), user);
            if (reference == null) {
                _log.error("Failed to build reference out of given data");
                return null;
            }
            result.setOther(reference);
            result.setType((String)data.get("type"));

            return result;
        }
        catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Build the patient id like it is stored in the database
     * @param id ID to build the identifier for
     * @return Result string
     */
    private String makeDatabaseId(Integer id) {
        return String.format("FHIR_XNAT_S%05d", id);
    }

    /**
     * Find anew unique project id matching the XNAT schema
     * @param subject Subject to find new id for
     * @param user Authenticated user
     * @return New subject id to assign
     */
    private String makeSubjectId(XnatSubjectdata subject, UserI user) {
        if (subject.getId() != null) {
            return subject.getId();
        }

        try {
            XFTTable table = TableSearch.Execute("SELECT id FROM xnat_subjectdata ORDER BY id DESC LIMIT 1", subject.getItem().getDBName(),null);
            table.resetRowCursor();
            int subjectId = 1;

            if (table.hasMoreRows()) {
                final Hashtable row = table.nextRowHash();
                final String databaseId  = (String)row.get("id");
                final Scanner sc = new Scanner(databaseId);
                sc.findInLine("(\\d+)$");
                final MatchResult result = sc.match();
                subjectId = Integer.parseInt(result.group(0)) + 1;
            }

            return String.format("XNAT_S%05d", subjectId);
        }
        catch (Exception e) {
            _log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Create communication sub structures for property export
     * @param entity Contact details to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makeContactPropertyMap(FhirPatientContactI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "relationship", _codeableConceptService.makePropertyMap(entity.getRelationship(), user));
        Datatypes.addIfPresent(result, "name", entity.getName());
        Datatypes.addIfPresent(result, "address", _addressService.makePropertyMap(entity.getAddress(), user));
        Datatypes.addIfPresent(result, "gender", entity.getGender());
        Datatypes.addIfPresent(result, "organization", _referenceService.makePropertyMap(entity.getOrganization(), user));
        this.exportPeriod(entity.getPeriod_start(), entity.getPeriod_end(), result);

        List<Map<String, Object>> items = new ArrayList<>();
        for (FhirContactpointI item : entity.getTelecom()) {
            items.add(_contactPointService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "line", items);
        return result;
    }

    /**
     * Create communication sub structures for property export
     * @param communication Communication specs to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makeCommunicationPropertyMap(FhirPatientCommunicationI communication, UserI user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("language", _codeableConceptService.makePropertyMap(communication.getLanguage(), user));
        Datatypes.addIfPresent(result, " preferred", communication.getPreferred());
        return result;
    }

    /**
     * Create link sub structures for property export
     * @param link Link to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makeLinkPropertyMap(FhirPatientLinkI link, UserI user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("other", _referenceService.makePropertyMap(link.getOther(), user));
        result.put("type", link.getType());
        return result;
    }

    /**
     * Search patient based on the database properties specified
     * @param path Search path
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirIdentifier record or null if none was found
     */
    @Nullable
    private FhirPatientI getFromDB(String path, Object value, UserI user) {
        try {
            String xmlPath = String.format("%s/%s", FhirPatientBean.SCHEMA_ELEMENT_NAME, path);
            ItemCollection results = ItemSearch.GetItems(xmlPath, value, user, true);
            if (results.size() == 0) {
                _log.debug("Unable to find FhirPatientI with %s=%s", path, value);
                return null;
            }

            if (results.size() > 1) {
                _log.info("Found multiple FhirPatientI with %s=%s. But record should be unique. Proceed with first match.", path, value);
            }

            ItemI match = results.getFirst();
            return (FhirPatientI) BaseElement.GetGeneratedItem(match);
        } catch (Exception e) {
            _log.error("Failed to unpack FhirPatient: " + e.toString());
            return null;
        }
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {

        return Datatypes.makeList("resourceType", "identifier", "active", "name", "telecom", "gender",
                "birthDate", "deceasedBoolean", "deceasedDateTime", "address", "maritalStatus",
                "multipleBirthBoolean", "multipleBirthInteger", "photo",
                "contact", "contact.relationship", "contact.name", "contact.telecom", "contact.address",
                "contact.gender", "contact.organization", "contact.period", "contact.period.start", "contact.period.end",
                "animal", "animal.species", "animal.breed", "animal.genderStatus",
                "communication", "communication.language", "communication.preferred",
                "generalPractitioner", "managingOrganization", "link", "link.other", "link.type");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, _identityService, Boolean.class, _nameService, _contactPointService, String.class,
                String.class, Boolean.class, String.class, _addressService, _codeableConceptService,
                Boolean.class, Integer.class, _attachmentService,
                Map.class, _codeableConceptService, _nameService, _contactPointService, _addressService,
                String.class, _referenceService, Map.class, String.class, String.class,
                Map.class, _codeableConceptService, _codeableConceptService, _codeableConceptService,
                Map.class, _codeableConceptService, Boolean.class,
                _referenceService, _referenceService,
                Map.class, _referenceService, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirPatientService.class);

    @Autowired
    private FhirIdentityService _identityService;

    @Autowired
    private FhirNameService _nameService;

    @Autowired
    private FhirContactPointService _contactPointService;

    @Autowired
    private FhirAddressService _addressService;

    @Autowired
    private FhirAttachmentService _attachmentService;

    @Autowired
    private FhirReferenceService _referenceService;

    @Autowired
    private FhirCodeableConceptService _codeableConceptService;
}
