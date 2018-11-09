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
 * Service to build and request FHIRAddress records
 */
@Service
public class FhirAddressService extends ComplexDatatypeValidatable {
    /**
     * Build a new address out of the given data
     * @param data JSON data submitted to create the new address
     * @param user user that requested the identifier creation
     * @return new address object
     */
    public FhirAddressI createAddress(Map<String, Object> data, UserI user) {
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
            FhirAddress result = new FhirAddress(user);
            result.setUse((String) data.get("use"));
            result.setText((String) data.get("text"));
            result.setType((String) data.get("type"));
            result.setCity((String) data.get("city"));
            result.setDistrict((String) data.get("district"));
            result.setState((String) data.get("state"));
            result.setPostalcode((String) data.get("postalCode"));
            result.setCountry((String) data.get("country"));

            List<String> items = (List<String>) data.get("line");
            if (items != null) {
                for (String item : items) {
                    FhirAddressLineI entity = new FhirAddressLine(user);
                    entity.setLine(item);
                    result.addLine(entity);
                }
            }

            Map<String, Object> period = (Map<String, Object>)data.get("period");
            if (period != null) {
                result.setPeriod_start((String)period.get("start"));
                result.setPeriod_end((String)period.get("end"));
            }

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
    public Map<String, Object> makePropertyMap(FhirAddressI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "use", entity.getUse());
        Datatypes.addIfPresent(result, "text", entity.getText());
        Datatypes.addIfPresent(result, "type", entity.getType());
        Datatypes.addIfPresent(result, "city", entity.getCity());
        Datatypes.addIfPresent(result, "district", entity.getDistrict());
        Datatypes.addIfPresent(result, "state", entity.getState());
        Datatypes.addIfPresent(result, "postalCode", entity.getPostalcode());
        Datatypes.addIfPresent(result, "country", entity.getCountry());
        List<String> items = new ArrayList<>();
        for (FhirAddressLineI item : entity.getLine()) {
            items.add(item.getLine());
        }
        Datatypes.addIfNotEmpty(result, "line", items);
        this.exportPeriod(entity.getPeriod_start(), entity.getPeriod_end(), result);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("use", "type", "text", "line", "city", "district", "state", "postalCode",
                "country", "period", "period.start", "period.end");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class,
                String.class, Map.class, String.class, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirAddressService.class);
}
