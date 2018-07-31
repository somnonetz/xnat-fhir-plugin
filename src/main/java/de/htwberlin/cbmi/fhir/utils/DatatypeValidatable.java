package de.htwberlin.cbmi.fhir.utils;

import javax.annotation.Nullable;
import java.util.*;

public abstract class DatatypeValidatable {
    /**
     * Validate the properites of the given object
     * @param attributes Attributes to validate
     * @return true if the properties match the requirements else false
     */
    public boolean validateProperties(Map<String, ?> attributes) {
        // Validate keys
        Collection<String> required = getRequiredKeys();
        Collection<String> allowed = getAllowedKeys();

        // Validate required keys
        if (Datatypes.validateKeys(attributes, required, allowed) != null) {
            return false;
        }

        // Validate types
        Collection<Object> types = getAllowedKeyTypes();
        if (allowed != null && types != null && allowed.size() == types.size()) {
            return Datatypes.validateMap(attributes, allowed, types) == null;
        }
        else {
            return true;
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
    public Collection<Object> getAllowedKeyTypes() {
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
