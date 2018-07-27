package de.htwberlin.cbmi.fhir.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.*;

public class Datatypes {

    /**
     * Add the given object to the map if it is present
     * @param map Map to add object to
     * @param k Key to store object for
     * @param v object to store
     */
    public static void addIfPresent(@Nonnull Map<String, Object> map, @Nonnull String k, @Nullable Object v) {
        if (v != null) {
            map.put(k, v);
        }
    }

    /**
     * Append the given object to the list if it is present
     * @param list List to append object to
     * @param v object to store
     */
    public static <T> void appendIfPresent(@Nonnull List<T> list, @Nullable T v) {
        if (v != null) {
            list.add(v);
        }
    }

    /**
     * Add the given list to the map if it is present and not empty
     * @param map Map to add object to
     * @param k Key to store object for
     * @param v object to store
     */
    public static void addIfNotEmpty(@Nonnull Map<String, Object> map, @Nonnull String k, @Nullable List<?> v) {
        if (v != null && v.size() > 0) {
            map.put(k, v);
        }
    }

    /**
     * Build a set out of the passed items
     * @param items Items to put into the set
     * @return Set with the passed items
     */
    @Nonnull
    public static <T> Set<T> makeSet(T... items) {
        /// Build a HashSet
        HashSet<T> result = new HashSet<>(items.length);
        for (T item : items) {
            result.add(item);
        }

        return result;
    }

    /**
     * Build a list out of the passed items
     * @param items Items to put into the list
     * @return Set with the passed items
     */
    @Nonnull
    public static <T> List<T> makeList(T... items) {
        return Arrays.asList(items);
    }

    /**
     * Prefix all items in the given Collection with the given prefix
     * @param items Items to prefix
     * @param prefix prefix to use
     * @return Prefixed collection if any items were given or null if not
     */
    @Nullable
    public static Collection<String> prefix(@Nullable Collection<String> items, @Nullable String prefix) {
        if (prefix == null) {
            return items;
        }

        Collection<String> result = null;
        if (items != null) {
            result = new ArrayList<>(items.size());
            for (String item : items) {
                result.add(prefix + "." + item);
            }
        }

        return result;
    }

    /**
     * Parse the JSON content read from the given reader and convert it to a java map object
     * @param reader Reader to fetch data from
     * @return Result object
     */
    public static Map<String, Object> readJsonString(Reader reader) {
        Stack<String> keyStack = new Stack<>();
        Object currentObject = null;
        Stack<Object> hierarchy = new Stack<>();

        final JsonParser parser = Json.createParser(reader);
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            Object content = null;
            boolean saveContent = false;
            switch (event) {
                case START_ARRAY:
                    currentObject = new ArrayList<>();
                    hierarchy.push(currentObject);
                    break;
                case START_OBJECT:
                    currentObject = new HashMap<String, Object>();
                    hierarchy.push(currentObject);
                    break;
                case END_ARRAY:
                case END_OBJECT:
                    content = hierarchy.pop();
                    if (!hierarchy.empty()) {
                        currentObject = hierarchy.peek();
                        saveContent = true;
                    }
                    break;
                case KEY_NAME:
                    keyStack.push(parser.getString());
                    break;
                case VALUE_STRING:
                    content = parser.getString();
                    saveContent = true;
                    break;
                case VALUE_NUMBER:
                    content = parser.getBigDecimal();
                    saveContent = true;
                    break;
                case VALUE_TRUE:
                    content = Boolean.TRUE;
                    saveContent = true;
                    break;
                case VALUE_FALSE:
                    content = Boolean.FALSE;
                    saveContent = true;
                    break;
                case VALUE_NULL:
                    content = null;
                    saveContent = true;
                    break;
            }

            if (saveContent) {
                if (currentObject instanceof List) {
                    ((List<Object>) currentObject).add(content);
                } else {
                    ((Map<String, Object>) currentObject).put(keyStack.pop(), content);
                }
            }
        }

        parser.close();
        return (Map<String, Object>)currentObject;
    }

    /**
     * Validate items in map if the keys are allowed and of the correct type
     * @param map Map to check items for
     * @param keys Keys to check (may contain . to address subkeys)
     * @param types Corresponding types of the given keys
     * @return The name of the key that failed validation or null if the map passed validation
     */
    public static String validateMap(Map<String, ?> map, Iterable<String> keys, Iterable<Class<?>> types) {
        Iterator<String> keyIterator = keys.iterator();
        Iterator<Class<?>> typeIterator = types.iterator();

        while (keyIterator.hasNext() && typeIterator.hasNext()) {
            String key = keyIterator.next();
            Class type = typeIterator.next();

            if (!Datatypes.validateMapItem(map, key, type)) {
                return key;
            }
        }

        return null;
    }

    /**
     * validate the keys in the given map
     * @param map Map to check keys for
     * @param required Required keys (. is supported for sub-structures)
     * @param allowed Allowed keys (. is supported for sub-structures)
     * @return null if no problems were found or a list of keys either missing or not allowed
     */
    public static Collection<String> validateKeys(Map<String, ?> map, Collection<String> required, Collection<String> allowed) {
        Set<String> presentKeys = new HashSet<>(Datatypes.getMapKeys(map, null));
        if (required != null && !presentKeys.containsAll(required)) {
            // Find missing keys
            Set<String> missingKeys = new HashSet<>(required);
            missingKeys.removeAll(presentKeys);
            return missingKeys;
        }

        if (allowed != null) {
            Set<String> allowedSet = new HashSet<>(allowed);
            for (String item : allowed) {
                allowedSet.addAll(Arrays.asList(item.split("\\.")));
            }

            if (!allowedSet.containsAll(presentKeys)) {
                // Find disallowed keys
                Set<String> disallowedKeys = new HashSet<>(presentKeys);
                disallowedKeys.removeAll(allowed);
                return disallowedKeys;
            }
        }

        return null;
    }


    /**
     * Return all keys found in the given map
     * @param map Map to collect keys for
     * @param base Base to use as a prefix for all keys
     */
    public static Collection<String> getMapKeys(Map<String, ?> map, String base) {
        Collection<String> result = new HashSet<>();
        if (map != null) {
            for (String key : map.keySet()) {
                String k = (base != null) ? base + "." + key : key;
                result.add(k);
                Object o = map.get(key);

                // If o is present it is required to be a Map or a Collection
                if (o instanceof Map) {
                    result.addAll(Datatypes.getMapKeys((Map<String, ?>) o, k));
                } else if (o instanceof Collection) {
                    Collection items = (Collection) o;
                    for (Object item : items) {
                        // Collect items for all subitems
                        if (item instanceof Map) {
                            result.addAll(Datatypes.getMapKeys((Map<String, ?>) item, k));
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Validate the type of the value for the given key - if no value is assigned to the key the check passes
     * @param map Map to look for key
     * @param key Key to access
     * @param type Type to check given data for
     * @return true if the type was successful else false
     */
    private static boolean validateMapItem(Map<String, ?> map, String key, Class<?> type) {
        if (!key.contains(".")) {
            Object o = map.get(key);

            // if the key is not present it passes validation
            if (o == null) {
                return true;
            }

            // Check if this type is an DatatypeValidatable and can validate the data itself
            if (DatatypeValidatable.class.isAssignableFrom(type)) {
                try {
                    Method method = type.getMethod("validateProperties", Map.class);
                    return (Boolean)method.invoke(null, map);
                }
                catch (Exception e) { }
            }

            // in all other cases we will check assign capability of o
            return type.isInstance(o);
        }
        else {
            // Split the key and pick the object assigned to the key
            String[] keys = key.split("\\.");
            key = keys[0];
            StringBuilder subkey = new StringBuilder(keys[1]);
            for (int index = 2; index < keys.length; index++) {
                subkey.append(".");
                subkey.append(keys[index]);
            }

            Object o = map.get(key);
            // if the key is not present it passes validation
            if (o == null) {
                return true;
            }

            // If o is present it is required to be a Map or a Collection
            if (o instanceof Map) {
                return Datatypes.validateMapItem((Map<String, ?>)o, subkey.toString(), type);
            }
            else if (o instanceof Collection) {
                Collection items = (Collection)o;
                for (Object item : items) {
                    // Each item in the collection must be a Map
                    // or validation will fail
                    if (!(item instanceof Map)) {
                        return false;
                    }

                    // Validate item
                    if (!Datatypes.validateMapItem((Map<String, ?>)item, subkey.toString(), type)) {
                        return false;
                    }
                }

                return true;
            }
            else {
                // Unknown datatype
                return false;
            }
        }
    }
}
