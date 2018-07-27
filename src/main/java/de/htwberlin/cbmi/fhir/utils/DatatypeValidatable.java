package de.htwberlin.cbmi.fhir.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public abstract class DatatypeValidatable {
    /**
     * Validate the properites of the given object
     * @param attributes Attributes to validate
     * @return true if the properties match the requirements else false
     */
    public static boolean validateProperties(Map<String, ?> attributes) {
        // Validate keys
        Collection<String> required = getRequiredKeys();
        Collection<String> allowed = getRequiredKeys();

        // Validate required keys
        if (Datatypes.validateKeys(attributes, required, allowed) != null) {
            return false;
        }

        // Validate types
        Collection<Class<?>> types = getAllowedKeyTypes();
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
    public static Collection<String> getRequiredKeys() {
        return null;
    }

    /**
     * Required keys in this datatype with the given prefix
     * @return Collection of keys required to be present prefixed by prefix
     */
    public static Collection<String> getRequiredKeys(String prefix) {
        return Datatypes.prefix(DatatypeValidatable.getRequiredKeys(), prefix);
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public static Collection<String> getAllowedKeys() {
        return null;
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public static Collection<Class<?>> getAllowedKeyTypes() {
        return null;
    }

    /**
     * Allowed keys in this datatype with the given prefix
     * @return Collection of keys allowed to be present prefixed by prefix
     */
    public static Collection<String> getAllowedKeys(String prefix) {
        return Datatypes.prefix(DatatypeValidatable.getAllowedKeys(), prefix);
    }
}
