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
 * Service to build and request FhirContactPoint records
 */
@Service
public class FhirContactPointService extends ComplexDatatypeValidatable {
    /**
     * Build a new contact Point out of the given data
     * @param data JSON data submitted to create the new name
     * @param user user that requested the identifier creation
     * @return new name object
     */
    public FhirContactpointI createContactPoint(Map<String, Object> data, UserI user) {
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
            FhirContactpoint result = new FhirContactpoint(user);
            result.setValue((String) data.get("value"));
            result.setUse((String) data.get("use"));
            result.setSystem((String) data.get("system"));
            result.setRank(data.get("rank"));

            Map<String, Object> period = (Map<String, Object>)data.get("period");
            if (period != null) {
                result.setPeriod_start((String)period.get("start"));
                result.setPeriod_end((String)period.get("end"));
            }

            return result;
        }
        catch (Exception e) {
            _log.error(e.getMessage());
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
    public Map<String, Object> makePropertyMap(FhirContactpointI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "value", entity.getValue());
        Datatypes.addIfPresent(result, "use", entity.getUse());
        Datatypes.addIfPresent(result, "system", entity.getSystem());
        Datatypes.addIfPresent(result, "rank", entity.getRank());
        this.exportPeriod(entity.getPeriod_start(), entity.getPeriod_end(), result);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("system", "value", "use", "rank",
                "period", "period.start", "period.end");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, Integer.class,
                Map.class, String.class, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirContactPointService.class);
}
