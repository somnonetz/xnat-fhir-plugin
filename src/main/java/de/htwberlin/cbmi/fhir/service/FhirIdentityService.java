package de.htwberlin.cbmi.fhir.service;

import javax.annotation.Nullable;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.bean.FhirIdentifierBean;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.model.FhirCodeableconceptI;
import org.nrg.xdat.model.FhirIdentifierI;
import org.nrg.xdat.model.FhirReferenceI;
import org.nrg.xdat.om.FhirIdentifier;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service to build and request FHIRIdentity records
 */
@Service
public class FhirIdentityService extends ComplexDatatypeValidatable {

    /**
     * Search matching identifier based on the unique value field
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirIdentifier record or null if none was found
     */
    @Nullable
    public FhirIdentifierI getIdentifier(String value, UserI user) {
        return this.getFromDB("value", value, user);
    }

    /**
     * Search matching identifier based on the database id
     * @param id record id
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirIdentifier record or null if none was found
     */
    @Nullable
    public FhirIdentifierI get(Integer id, UserI user) {
        return this.getFromDB("ID", id, user);
    }

    /**
     * Build a new identifier out of the given data
     * @param data JSON data submitted to create the new identifier
     * @param user user that requested the identifier creation
     * @return new identifer object
     */
    public FhirIdentifierI createIdentifier(Map<String, Object> data, UserI user) {
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

        // Build the result object
        try {
            FhirIdentifier result = new FhirIdentifier(user);
            result.setUse((String) data.get("use"));

            FhirCodeableconceptI type = _codeableConceptService.createCodeableConcept((Map<String, Object>) data.get("type"), user);
            if (type != null) {
                result.setType(type);
            }

            result.setSystem((String) data.get("system"));
            result.setValue((String) data.get("value"));

            // TODO: Check if this works
            if (data.get("assigner") != null) {
                FhirReferenceI assigner = _referenceService.createReference((Map<String, Object>) data.get("assigner"), user);
                if (assigner == null) {
                    throw new Exception("Assigner with id " + data.get("assigner") + " not found in the system");
                }
                result.setAssigner(assigner);
            }

            return result;
        } catch (Exception e) {
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
    public Map<String, Object> makePropertyMap(FhirIdentifierI entity, UserI user) {
        // A record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "use", entity.getUse());
        Datatypes.addIfPresent(result, "type", _codeableConceptService.makePropertyMap(entity.getType(), user));
        Datatypes.addIfPresent(result, "system", entity.getSystem());
        Datatypes.addIfPresent(result, "value", entity.getValue());

        if (entity.getPeriod_start() != null || entity.getPeriod_end() != null) {
            Map<String, Object> period = new HashMap<>();
            Datatypes.addIfPresent(period, " start", entity.getPeriod_start());
            Datatypes.addIfPresent(period, " end", entity.getPeriod_end());
            result.put("period", period);
        }

        Datatypes.addIfPresent(result, "assigner", _referenceService.makePropertyMap(entity.getAssigner(), user));

        return result;
    }

    /**
     * Search unique identifier based on the database
     * @param path Search path
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirIdentifier record or null if none was found
     */
    @Nullable
    private FhirIdentifierI getFromDB(String path, Object value, UserI user) {
        try {
            String xmlPath = String.format("%s/%s", FhirIdentifierBean.SCHEMA_ELEMENT_NAME, path);
            ItemCollection results = ItemSearch.GetItems(xmlPath, value, user, true);
            if (results.size() == 0) {
                _log.debug("Unable to find FhirIdentifier with %s=%s", path, value);
                return null;
            }

            if (results.size() > 1) {
                _log.info("Found multiple FhirIdentifier with %s=%s. But record should be unique. Proceed with first match.", path, value);
            }

            ItemI match = results.getFirst();
            return (FhirIdentifierI) BaseElement.GetGeneratedItem(match);
        } catch (Exception e) {
            _log.error("Failed to unpack FhirIdentifier: " + e.toString());
            return null;
        }
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("use", "type", "system", "value",
                "period", "period.start", "period.end", "assigner");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, _codeableConceptService, String.class, String.class,
                Map.class, String.class, String.class, _referenceService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirIdentityService.class);

    @Autowired
    private FhirReferenceService _referenceService;

    @Autowired
    private FhirCodeableConceptService _codeableConceptService;
}
