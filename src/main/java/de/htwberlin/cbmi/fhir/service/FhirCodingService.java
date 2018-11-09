package de.htwberlin.cbmi.fhir.service;

import javax.annotation.Nullable;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.model.*;
import org.nrg.xdat.om.*;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service to build and request FhirCoding records
 */
@Service
public class FhirCodingService extends ComplexDatatypeValidatable {
    /**
     * Build a new coding out of the given data
     * @param data JSON data submitted to create the new coding
     * @param user user that requested the coding creation
     * @return new coding object
     */
    public FhirCodingI createCoding(Map<String, Object> data, UserI user) {
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
            // Build the result object
            FhirCoding result = new FhirCoding(user);
            result.setSystem((String) data.get("system"));
            result.setVersion((String) data.get("version"));
            result.setCode((String) data.get("code"));
            result.setDisplay((String) data.get("display"));
            result.setUserselected(data.get("userSelected"));

            return result;
        }
        catch (Exception e) {
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
    public Map<String, Object> makePropertyMap(FhirCodingI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "system", entity.getSystem());
        Datatypes.addIfPresent(result, "version", entity.getVersion());
        Datatypes.addIfPresent(result, "code", entity.getCode());
        Datatypes.addIfPresent(result, "display", entity.getDisplay());
        Datatypes.addIfPresent(result, "userSelected", entity.getUserselected());

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("system", "version", "code", "display", "userSelected");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, String.class, Boolean.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirCodingService.class);
}
