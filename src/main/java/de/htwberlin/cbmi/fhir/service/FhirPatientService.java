package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.bean.FhirPatientBean;
import org.nrg.xdat.model.*;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirPatientService extends DatatypeValidatable {
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
    public FhirPatientI getPatient(String id, UserI user) {
        return this.getFromDB("ID", id, user);
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
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "name", items);

        // Push telecom
        items = new ArrayList<>();
        for (FhirContactpointI item : patient.getTelecom()) {
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "telecom", items);

        // Push address
        items = new ArrayList<>();
        for (FhirAddressI item : patient.getAddress()) {
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "address", items);

        // Push photo
        items = new ArrayList<>();
        for (FhirAttachementI item : patient.getPhoto()) {
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "photo", items);

        // Push photo
        items = new ArrayList<>();
        for (FhirPatientContactI item : patient.getContact()) {
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "contact", items);

        // Push communication
        items = new ArrayList<>();
        for (FhirPatientCommunicationI item : patient.getCommunication()) {
            Datatypes.appendIfPresent(items, makePropertyMapForCommunication(item, user));
        }
        Datatypes.addIfNotEmpty(result, "communication", items);

        // Push generalPractitioner
        items = new ArrayList<>();
        for (FhirReferenceI item : patient.getGeneralpractitioner()) {
            // @TODO
        }
        Datatypes.addIfNotEmpty(result, "generalPractitioner", items);

        // Push link
        items = new ArrayList<>();
        for (FhirPatientLinkI item : patient.getLink()) {
            Datatypes.appendIfPresent(items, makePropertyMapForLink(item, user));
        }
        Datatypes.addIfNotEmpty(result, "link", items);

        // Push simple elements
        Datatypes.addIfPresent(result, "active", patient.getActive());
        Datatypes.addIfPresent(result, "gender", patient.getGender());
        Datatypes.addIfPresent(result, "birthDate", patient.getBirthdate());
        Datatypes.addIfPresent(result, "maritalStatus", patient.getMaritalstatus());
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
            animal.put("species", patient.getAnimal_species());
            Datatypes.addIfPresent(animal, " breed", patient.getAnimal_breed());
            Datatypes.addIfPresent(animal, " genderStatus", patient.getAnimal_genderstatus());
            result.put("animal", animal);
        }

        // @TODO
        //Datatypes.addIfPresent(result, "managingOrganization", patient.getMaritalstatus());

        return result;
    }

    /**
     * Create communication sub structures for property export
     * @param contact Contact details to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makePropertyMapForContact(FhirPatientContactI contact, UserI user) {
        HashMap<String, Object> result = new HashMap<>();

        // Push name
        if (contact.getName() != null) {
            // @TODO
            //Datatypes.addIfPresent(result, " name", contact.getName());
        }

        // Push telecom
        ArrayList<Map<String, ?>> items = new ArrayList<>();
        for (FhirContactpointI item : contact.getTelecom()) {
            // @TODO
        }
        result.put("telecom", items);

        // Push address
        if (contact.getAddress() != null) {
            // @TODO
            //Datatypes.addIfPresent(result, " address", contact.getAddress());
        }

        // Push address
        if (contact.getOrganization() != null) {
            // @TODO
            //Datatypes.addIfPresent(result, " address", contact.getAddress());
        }

        // Push simple elements
        Datatypes.addIfPresent(result, " relationship", contact.getRelationship());
        Datatypes.addIfPresent(result, " gender", contact.getGender());

        if (contact.getPeriod_start() != null || contact.getPeriod_end() != null) {
            Map<String, Object> period = new HashMap<>();
            Datatypes.addIfPresent(period, " start", contact.getPeriod_start());
            Datatypes.addIfPresent(period, " end", contact.getPeriod_end());
            result.put("period", period);
        }

        return result;
    }

    /**
     * Create communication sub structures for property export
     * @param communication Communication specs to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makePropertyMapForCommunication(FhirPatientCommunicationI communication, UserI user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("language", communication.getLanguage());
        Datatypes.addIfPresent(result, " preferred", communication.getPreferred());
        return result;
    }

    /**
     * Create link sub structures for property export
     * @param link Link to export
     * @param user User requesting the action
     * @return Map with keys and values to transfer
     */
    private Map<String, Object> makePropertyMapForLink(FhirPatientLinkI link, UserI user) {
        HashMap<String, Object> result = new HashMap<>();
        // @TODO
        //result.put("other", );
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

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirPatientService.class);

    @Autowired
    private FhirIdentityService _identityService;
}
