package de.htwberlin.cbmi.fhir.utils;

import javax.annotation.Nullable;
import java.util.*;

public class ComplexDatatypeValidatable {
    /**
     * Validate the properties of the given object
     * @param attributes Attributes to validate
     * @return true if the properties match the requirements else false
     */
    public Collection<String> validateProperties(Map<String, ?> attributes) {
        return this.validateProperties(attributes, true);
    }

    /**
     * Validate the properties of the given object
     * @param attributes Attributes to validate
     * @param allowUnknownKeys true if you want to allow keys present in attributes that are unknown else false
     * @return List of invalid keys (missing or disallowed) or null if no errors were found
     */
    public Collection<String> validateProperties(Map<String, ?> attributes, boolean allowUnknownKeys) {
        // Validate keys
        Collection<String> required = getRequiredKeys();
        Collection<String> allowed = getAllowedKeys();
        Collection<? extends Object> types = getAllowedKeyTypes();

        Map<String, ? extends Object> allowedTypes = Datatypes.makeMap(allowed, types);

        // Validate required keys
        Collection<String> invalidKeys = Datatypes.validateKeys(attributes, required, allowedTypes, allowUnknownKeys);
        if (invalidKeys != null) {
            return invalidKeys;
        }

        // Validate types
        if (allowed != null && types != null && allowed.size() == types.size()) {
            String invalidKey = Datatypes.validateMap(attributes, allowed, types);
            if (invalidKey != null) {
                return Datatypes.makeList(invalidKey);
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    /**
     * Required keys in this datatype
     * @return Collection of keys required to be present
     */
    public Collection<String> getRequiredKeys() {
        return null;
    }

    /**
     * Required keys in this datatype with the given prefix
     * @return Collection of keys required to be present prefixed by prefix
     */
    public Collection<String> getRequiredKeys(String prefix) {
        return Datatypes.prefix(this.getRequiredKeys(), prefix);
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return null;
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return null;
    }

    /**
     * Allowed keys in this datatype with the given prefix
     * @return Collection of keys allowed to be present prefixed by prefix
     */
    public Collection<String> getAllowedKeys(String prefix) {
        return Datatypes.prefix(this.getAllowedKeys(), prefix);
    }

    /**
     * Export FHIR period datastructure
     * @param start Start date
     * @param end End Date
     * @param map Map to write to
     */
    public void exportPeriod(@Nullable Object start, @Nullable Object end, Map<String, Object> map) {
        if (start != null || end != null) {
            Map<String, Object> period = new HashMap<>();
            Datatypes.addIfPresent(period, " start", start);
            Datatypes.addIfPresent(period, " end", end);
            map.put("period", period);
        }
    }
}
