package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import de.htwberlin.cbmi.fhir.utils.FhirXnatProjectHelper;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.search.CriteriaCollection;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.search.SearchCriteria;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.bean.FhirEncounterBean;
import org.nrg.xdat.model.*;
import org.nrg.xdat.om.*;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.regex.MatchResult;

@Service
public class FhirEncounterService extends ComplexDatatypeValidatable {

    /**
     * Return the name of the XNAT project where new Encounter records will be published to
     * @param user User authenticated in the system
     * @return Name of subject project to associate with
     */
    @Nonnull
    public static String getEncounterProject(UserI user) {
        return "fhir-MII";
    }

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the identifier creation
     * @return new object
     */
    public FhirEncounterI createEncounter(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        // Verify handed properties
        Collection<String> invalidProperties = this.validateProperties(data);
        if (invalidProperties != null) {
            _log.debug("Attribute validation failed for: " + invalidProperties);
            return null;
        }

        try {
            // Build subject record to associate the encounter record with
            XnatSubjectdata subject = new XnatSubjectdata(user);
            subject.setId(FhirXnatProjectHelper.makeSubjectId(subject, user));
            subject.setProject(getEncounterProject(user));
            subject.setLabel(FhirXnatProjectHelper.getLabelForSubject(subject));

            if (!subject.save(user, true, false, null)) {
                _log.error("Failed to save subject record");
                return null;
            }

            // Build the result object
            FhirEncounter encounter = new FhirEncounter(user);

            final HashMap<String, Object> encounterMeta = (HashMap<String, Object>)data.get("encounterMeta");
            if (encounterMeta != null) {
                FhirSinglestringvalueI versionid = _singlestringvalueService.createSinglestringvalue((Map<String, Object>)encounterMeta.get("versionid"), user);
                if (versionid != null) {
                    encounter.setEncountermeta_versionid(versionid);
                }

                FhirSinglestringvalueI lastupdated = _singlestringvalueService.createSinglestringvalue((Map<String, Object>)encounterMeta.get("lastupdated"), user);
                if (lastupdated != null) {
                    encounter.setEncountermeta_lastupdated(lastupdated);
                }
                encounter.setEncountermeta_source((String) encounterMeta.get("source"));

                // Map encounterMeta.profile
                List<Map<String, Object>> items = (List<Map<String, Object>>) encounterMeta.get("profile");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirSinglestringvalueI profile = _singlestringvalueService.createSinglestringvalue(item, user);
                        if (profile == null) {
                            _log.error("Failed to construct profile");
                            return null;
                        }
                        encounter.addEncountermeta_profile(profile);
                    }
                }

                items = (List<Map<String, Object>>) encounterMeta.get("security");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirCodingI security = _codingService.createCoding(item, user);
                        if (security == null) {
                            _log.error("Failed to construct security");
                            return null;
                        }
                        encounter.addEncountermeta_security(security);
                    }
                }

                items = (List<Map<String, Object>>) encounterMeta.get("tag");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirCodingI tag = _codingService.createCoding(item, user);
                        if (tag == null) {
                            _log.error("Failed to construct tag");
                            return null;
                        }
                        encounter.addEncountermeta_tag(tag);
                    }
                }
            }

            List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("AufnahmeExtension");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirEncounterAufnahmeextensionI aufnahmeextension = _aufnahmeextensionService.createAufnahmegrundextension(item, user);
                    if (aufnahmeextension == null) {
                        _log.error("Failed to construct Aufnahme extension");
                        return null;
                    }
                    encounter.addAufnahmeextension(aufnahmeextension);
                }
            }

            items = (List<Map<String, Object>>) data.get("identifier");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirEncounterIdentifierI identifier = _encounterIdentifierService.createEncounterIdentifier(item, user);
                    if (identifier == null) {
                        _log.error("Failed to construct identifier");
                        return null;
                    }
                    encounter.addIdentifier(identifier);
                }
            }

            encounter.setStatus((String) data.get("status"));

            FhirCodingI encounterClass = _codingService.createCoding((Map<String, Object>) data.get("Encounterclass"), user);
            if (encounterClass == null) {
                _log.error("Failed to construct encounter class");
                return null;
            }
            encounter.setEncounterclass(encounterClass);

            items = (List<Map<String, Object>>) data.get("type");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirEncounterTypeI type = _typeService.createEncounterType(item, user);
                    if (type == null) {
                        _log.error("Failed to construct type");
                        return null;
                    }
                    encounter.addType(type);
                }
            }

            Map<String, Object> period = (Map<String, Object>)data.get("period");
            if (period != null) {
                encounter.setPeriod_start((String)period.get("start"));
                encounter.setPeriod_end((String)period.get("end"));
            }

            final HashMap<String, Object> serviceType = (HashMap<String, Object>)data.get("serviceType");
            if (serviceType != null) {
                items = (List<Map<String, Object>>) serviceType.get("coding");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirEncounterCodingI coding = _encounterCodingService.createEncounterCoding(item, user);
                        if (coding == null) {
                            _log.error("Failed to construct coding");
                            return null;
                        }
                        encounter.addServicetype_coding(coding);
                    }
                }
            }

            FhirReferenceI encounterSubject = _referenceService.createReference((Map<String, Object>) data.get("subject"), user);
            if (encounterSubject == null) {
                _log.error("Failed to construct subject");
                return null;
            }
            encounter.setSubject(encounterSubject);

            final HashMap<String, Object> diagnosis = (HashMap<String, Object>)data.get("diagnosis");
            if (diagnosis != null) {
                FhirReferenceI condition = _referenceService.createReference((Map<String, Object>) diagnosis.get("condition"), user);
                if (condition == null) {
                    _log.error("Failed to construct condition");
                    return null;
                }
                encounter.setDiagnosis_condition(condition);

                FhirCodeableconceptI use = _codeableConceptService.createCodeableConcept((Map<String, Object>) diagnosis.get("use"), user);
                if (use == null) {
                    _log.error("Failed to construct use");
                    return null;
                }
                encounter.setDiagnosis_use(use);

                encounter.setDiagnosis_rank((Integer) diagnosis.get("rank"));
            }

            items = (List<Map<String, Object>>) data.get("location");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirEncounterLocationI location = _encounterLocationService.createEncounterLocation(item, user);
                    if (location == null) {
                        _log.error("Failed to construct location");
                        return null;
                    }
                    encounter.addLocation(location);
                }
            }

            final HashMap<String, Object> hospitalization = (HashMap<String, Object>)data.get("hospitalization");
            if (hospitalization != null) {
                FhirIdentifierI preadmissionidentifier = _identityService.createIdentifier((Map<String, Object>) hospitalization.get("preAdmissionIdentifier"), user);
                if (preadmissionidentifier != null) {
                    encounter.setHospitalization_preadmissionidentifier(preadmissionidentifier);
                }

                FhirReferenceI origin = _referenceService.createReference((Map<String, Object>) hospitalization.get("origin"), user);
                if (origin != null) {
                    encounter.setHospitalization_origin(origin);
                }

                FhirCodeableconceptI admitSource = _codeableConceptService.createCodeableConcept((Map<String, Object>) hospitalization.get("admitSource"), user);
                if (admitSource == null) {
                    _log.error("Failed to construct admitSource");
                    return null;
                }
                encounter.setHospitalization_admitsource(admitSource);

                FhirCodeableconceptI reAdmission = _codeableConceptService.createCodeableConcept((Map<String, Object>) hospitalization.get("reAdmission"), user);
                if (reAdmission != null) {
                    encounter.setHospitalization_readmission(reAdmission);
                }

                items = (List<Map<String, Object>>) hospitalization.get("dietPreference");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirCodeableconceptI dietpreference = _codeableConceptService.createCodeableConcept(item, user);
                        if (dietpreference == null) {
                            _log.error("Failed to construct dietpreference");
                            return null;
                        }
                        encounter.addHospitalization_dietpreference(dietpreference);
                    }
                }

                items = (List<Map<String, Object>>) hospitalization.get("specialCourtesy");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirCodeableconceptI specialcourtesy = _codeableConceptService.createCodeableConcept(item, user);
                        if (specialcourtesy == null) {
                            _log.error("Failed to construct specialcourtesy");
                            return null;
                        }
                        encounter.addHospitalization_specialcourtesy(specialcourtesy);
                    }
                }

                items = (List<Map<String, Object>>) hospitalization.get("specialArrangement");
                if (items != null) {
                    for (Map<String, Object> item : items) {
                        FhirCodeableconceptI specialarrangement = _codeableConceptService.createCodeableConcept(item, user);
                        if (specialarrangement == null) {
                            _log.error("Failed to construct specialarrangement");
                            return null;
                        }
                        encounter.addHospitalization_specialarrangement(specialarrangement);
                    }
                }

                FhirReferenceI destination = _referenceService.createReference((Map<String, Object>) hospitalization.get("destination"), user);
                if (destination != null) {
                    encounter.setHospitalization_destination(destination);
                }

                final HashMap<String, Object> dischargeDisposition = (HashMap<String, Object>)hospitalization.get("dischargeDisposition");
                if (dischargeDisposition != null) {

                    items = (List<Map<String, Object>>) dischargeDisposition.get("extension");
                    if (items != null) {
                        for (Map<String, Object> item : items) {
                            FhirEncounterExtensionI extension = _encounterExtensionService.createEncounterExtension(item, user);
                            if (extension == null) {
                                _log.error("Failed to construct extension");
                                return null;
                            }
                            encounter.addHospitalization_dischargedisposition_extension(extension);
                        }
                    }

                    items = (List<Map<String, Object>>) dischargeDisposition.get("coding");
                    if (items != null) {
                        for (Map<String, Object> item : items) {
                            FhirCodingI coding = _codingService.createCoding(item, user);
                            if (coding == null) {
                                _log.error("Failed to construct coding");
                                return null;
                            }
                            encounter.addHospitalization_dischargedisposition_coding(coding);
                        }
                    }

                    encounter.setHospitalization_dischargedisposition_text((String) dischargeDisposition.get("text"));
                }
            }

            subject.addExperiments_experiment(encounter);
            encounter.save(user, true, true, null);

            return encounter;
        }
        catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Build the property map to transfer as a json request for the given entity
     * @param entity entity to transfer
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    @Nullable
    public Map<String, Object> makePropertyMap(FhirEncounterI encounter, UserI user) {
        // An entity record should be present for export
        if (encounter == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        ArrayList<Map<String, Object>> items = new ArrayList<>();

        if (encounter.getEncountermeta_versionid() != null) {
            Map<String, Object> encounterMeta = new HashMap<>();
            encounterMeta.put("versionId", _singlestringvalueService.makePropertyMap(encounter.getEncountermeta_versionid(), user));
            Datatypes.addIfPresent(encounterMeta, "lastUpdated", _singlestringvalueService.makePropertyMap(encounter.getEncountermeta_lastupdated(), user));
            Datatypes.addIfPresent(encounterMeta, "source", encounter.getEncountermeta_source());

            for (FhirSinglestringvalueI item : encounter.getEncountermeta_profile()) {
                Datatypes.appendIfPresent(items, _singlestringvalueService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(encounterMeta, "profile", items);

            items = new ArrayList<>();
            for (FhirCodingI item : encounter.getEncountermeta_security()) {
                Datatypes.appendIfPresent(items, _codingService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(encounterMeta, "security", items);

            items = new ArrayList<>();
            for (FhirCodingI item : encounter.getEncountermeta_tag()) {
                Datatypes.appendIfPresent(items, _codingService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(encounterMeta, "tag", items);

            result.put("encounterMeta", encounterMeta);
        }

        Datatypes.addIfPresent(result, "status", encounter.getStatus());

        result.put("encounterClass", _codingService.makePropertyMap(encounter.getEncounterclass(), user));

        items = new ArrayList<>();
        for (FhirEncounterTypeI item : encounter.getType()) {
            Datatypes.appendIfPresent(items, _typeService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "type", items);

        this.exportPeriod(encounter.getPeriod_start(), encounter.getPeriod_end(), result);

        Map<String, Object> serviceType = new HashMap<>();
        items = new ArrayList<>();
        for (FhirEncounterCodingI item : encounter.getServicetype_coding()) {
            Datatypes.appendIfPresent(items, _encounterCodingService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(serviceType, "coding", items);
        result.put("serviceType", serviceType);

        Datatypes.addIfPresent(result, "subject", _referenceService.makePropertyMap(encounter.getSubject(), user));

        if (encounter.getDiagnosis_condition() != null) {
            Map<String, Object> diagnosis = new HashMap<>();
            diagnosis.put("condition", _referenceService.makePropertyMap(encounter.getDiagnosis_condition(), user));
            diagnosis.put("use", _codeableConceptService.makePropertyMap(encounter.getDiagnosis_use(), user));
            diagnosis.put("rank", encounter.getDiagnosis_rank());

            result.put("diagnosis", diagnosis);
        }

        items = new ArrayList<>();
        for (FhirEncounterLocationI item : encounter.getLocation()) {
            Datatypes.appendIfPresent(items, _encounterLocationService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "location", items);

        if (encounter.getHospitalization_admitsource() != null) {
            Map<String, Object> hospitalization = new HashMap<>();
            Datatypes.addIfPresent(hospitalization, "preAdmissionIdentifier",  _identityService.makePropertyMap(encounter.getHospitalization_preadmissionidentifier(), user));
            Datatypes.addIfPresent(hospitalization, "origin", _referenceService.makePropertyMap(encounter.getHospitalization_origin(), user));
            hospitalization.put("admitSource", _codeableConceptService.makePropertyMap(encounter.getHospitalization_admitsource(), user));
            Datatypes.addIfPresent(hospitalization, "reAdmission", _codeableConceptService.makePropertyMap(encounter.getHospitalization_readmission(), user));

            items = new ArrayList<>();
            for (FhirCodeableconceptI item : encounter.getHospitalization_dietpreference()) {
                Datatypes.appendIfPresent(items, _codeableConceptService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(hospitalization, "dietPreference", items);

            items = new ArrayList<>();
            for (FhirCodeableconceptI item : encounter.getHospitalization_specialcourtesy()) {
                Datatypes.appendIfPresent(items, _codeableConceptService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(hospitalization, "specialCourtesy", items);

            items = new ArrayList<>();
            for (FhirCodeableconceptI item : encounter.getHospitalization_specialarrangement()) {
                Datatypes.appendIfPresent(items, _codeableConceptService.makePropertyMap(item, user));
            }
            Datatypes.addIfNotEmpty(hospitalization, "specialArrangement", items);

            Datatypes.addIfPresent(hospitalization, "destination", _referenceService.makePropertyMap(encounter.getHospitalization_destination(), user));

            if (encounter.getHospitalization_dischargedisposition_extension() != null) {
                Map<String, Object> dischargedisposition = new HashMap<>();

                items = new ArrayList<>();
                for (FhirEncounterExtensionI item : encounter.getHospitalization_dischargedisposition_extension()) {
                    Datatypes.appendIfPresent(items, _encounterExtensionService.makePropertyMap(item, user));
                }
                Datatypes.addIfNotEmpty(dischargedisposition, "extension", items);

                items = new ArrayList<>();
                for (FhirCodingI item : encounter.getHospitalization_dischargedisposition_coding()) {
                    Datatypes.appendIfPresent(items, _codingService.makePropertyMap(item, user));
                }
                Datatypes.addIfNotEmpty(dischargedisposition, "coding", items);

                Datatypes.addIfPresent(dischargedisposition, "text", encounter.getHospitalization_dischargedisposition_text());

                hospitalization.put("dischargeDisposition", dischargedisposition);
            }

            result.put("hospitalization", hospitalization);
        }

        return result;
    }

    /**
     * Return the ID of the encounter
     * @param entity Entity to extract the ID from
     * @return integer of the encounter
     */
    public Integer getEncounterId(FhirEncounterI entity) {
        final String databaseId  = entity.getId();
        final Scanner sc = new Scanner(databaseId);
        sc.findInLine("(\\d+)$");
        final MatchResult result = sc.match();
        return Integer.parseInt(result.group(0));
    }

    @Nullable
    public static FhirEncounterI getEncounterForSubject(String subjectId, UserI user) {
        return getFromDB("subject_ID", subjectId, user);
    }

    @Nullable
    public static FhirEncounterI getEncounterForPatient(String patientId, UserI user) {
        return getFromDB("subjec/reference", patientId, user);
    }

    @Nullable
    public static FhirEncounterI getEncounterForCase(String caseId, UserI user) {
        return getFromDB("identifier/Aufnahmenummer/value", caseId, user);
    }

    @Nullable
    public static List<FhirEncounterI> getEncounterForDepartment(String departmentId, UserI user) {
        return getListFromDB("identifier/Aufnahmenummer/value", departmentId, user);
    }

    @Nullable
    public static List<FhirEncounterI> getEncounterForPeriod(String start, String end, UserI user) {

        if (start.isEmpty() || end.isEmpty()) {
            _log.debug("Unable to find FhirEncounterI with null period: %s, %s", start, end);
            return null;
        }
        try {
            // todo: period.end is nullable, if we need to add into the search criteria
            /* search criteria with period: find all records that partly or whole matched with the given period,
             not only the records that inside the given period.
             */
            CriteriaCollection cc = new CriteriaCollection("AND");
            SearchCriteria scStart = new SearchCriteria();
            scStart.setFieldWXMLPath(FhirEncounterBean.SCHEMA_ELEMENT_NAME + "/period/start");
            scStart.setOverrideFormatting(true);
            scStart.setComparison_type(" <= ");
            scStart.setValue(end);
            cc.add(scStart);

            SearchCriteria scEnd = new SearchCriteria();
            scEnd.setFieldWXMLPath(FhirEncounterBean.SCHEMA_ELEMENT_NAME + "/period/end");
            scEnd.setOverrideFormatting(true);
            scEnd.setComparison_type(" >= ");
            scEnd.setValue(start);
            cc.add(scEnd);

            ItemCollection results = ItemSearch.GetItems(cc, user, true);

            if (results.size() == 0) {
                _log.debug("Unable to find FhirEncounterI with period: %s, %s", start, end);
                return null;
            }

            List<FhirEncounterI> retVal = new ArrayList<FhirEncounterI>();
            for ( int index = 0; index < results.size(); index++) {
                ItemI item = results.get(index);
                FhirEncounterI oneEncounter = (FhirEncounterI) BaseElement.GetGeneratedItem(item);
                retVal.add(oneEncounter);
            }

            return retVal;
        } catch (Exception e) {
            _log.error("Failed to unpack FhirEncounter: " + e.toString());
            return null;
        }
    }

    /**
     * Search encounter based on the database properties specified
     * @param path Search path
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirEncounter record or null if none was found
     */
    @Nullable
    private static List<FhirEncounterI> getListFromDB(String path, Object value, UserI user) {
        try {
            String xmlPath = String.format("%s/%s", FhirEncounterBean.SCHEMA_ELEMENT_NAME, path);
            ItemCollection results = ItemSearch.GetItems(xmlPath, value, user, true);
            if (results.size() == 0) {
                _log.debug("Unable to find FhirEncounterI with %s=%s", path, value);
                return null;
            }

            List<FhirEncounterI> retVal = new ArrayList<FhirEncounterI>();
            for ( int index = 0; index < results.size(); index++) {
                ItemI item = results.get(index);
                FhirEncounterI oneEncounter = (FhirEncounterI) BaseElement.GetGeneratedItem(item);
                retVal.add(oneEncounter);
            }

            return retVal;
        } catch (Exception e) {
            _log.error("Failed to unpack FhirEncounter: " + e.toString());
            return null;
        }
    }
    /**
     * Search encounter based on the database properties specified
     * @param path Search path
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirEncounter record or null if none was found
     */
    @Nullable
    private static FhirEncounterI getFromDB(String path, Object value, UserI user) {
        try {
            String xmlPath = String.format("%s/%s", FhirEncounterBean.SCHEMA_ELEMENT_NAME, path);
            ItemCollection results = ItemSearch.GetItems(xmlPath, value, user, true);
            if (results.size() == 0) {
                _log.debug("Unable to find FhirEncounterI with %s=%s", path, value);
                return null;
            }

            if (results.size() > 1) {
                _log.info("Found multiple FhirEncounterI with %s=%s. But record should be unique. Proceed with first match.", path, value);
            }

            ItemI match = results.getFirst();
            return (FhirEncounterI) BaseElement.GetGeneratedItem(match);
        } catch (Exception e) {
            _log.error("Failed to unpack FhirEncounter: " + e.toString());
            return null;
        }
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {

        return Datatypes.makeList("encounterMeta", "encounterMeta.versionId", "encounterMeta.lastUpdated",
                "encountermeta.source", "encountermeta.profile", "encountermeta.security", "encountermeta.tag",
                "AufnahmeExtension", "identifier", "status", "encounterclass", "type", "period", "period.start",
                "period.end", "servicetype", "servicetype.coding", "subject", "diagnosis", "diagnosis.condition",
                "diagnosis.use", "diagnosis.rank", "location", "hospitalization", "hospitalization.preadmissionidentifier",
                "hospitalization.origin", "hospitalization.admitsource", "hospitalization.readmission",
                "hospitalization.dietpreference", "hospitalization.specialcourtesy", "hospitalization.specialarrangement",
                "hospitalization.destination", "hospitalization.dischargedisposition",
                "hospitalization.dischargedisposition.extension", "hospitalization.dischargedisposition.coding",
                "hospitalization.dischargedisposition.text");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(Map.class, _singlestringvalueService, _singlestringvalueService, String.class,
                _singlestringvalueService, _codingService, _codingService, _aufnahmeextensionService,
                _encounterIdentifierService, String.class, _codingService, _typeService, Map.class, String.class,
                String.class, Map.class, _encounterCodingService, _referenceService, Map.class, _referenceService,
                _codeableConceptService, Integer.class, _encounterLocationService, Map.class, _identityService,
                _referenceService, _codeableConceptService, _codeableConceptService, _codeableConceptService,
                _codeableConceptService, _codeableConceptService, _referenceService, Map.class, _encounterExtensionService,
                _codingService, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirEncounterService.class);

    @Autowired
    private FhirIdentityService _identityService;

    @Autowired
    private FhirReferenceService _referenceService;

    @Autowired
    private FhirCodeableConceptService _codeableConceptService;

    @Autowired
    private FhirCodingService _codingService;

    @Autowired
    private FhirEncounterAufnahmeextensionService _aufnahmeextensionService;

    @Autowired
    private FhirEncounterIdentifierService _encounterIdentifierService;

    @Autowired
    private FhirEncounterCodingService _encounterCodingService;

    @Autowired
    private FhirEncounterLocationService _encounterLocationService;

    @Autowired
    private FhirEncounterExtensionService _encounterExtensionService;

    @Autowired
    private FhirSinglestringvalueService _singlestringvalueService;

    @Autowired
    private FhirEncounterTypeService _typeService;
}
