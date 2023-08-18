package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirEncounterextensionaufnahmegrundI;
import org.nrg.xdat.model.FhirAufnahmegrundextensionI;
import org.nrg.xdat.om.FhirEncounterextensionaufnahmegrund;
import org.nrg.xdat.om.FhirAufnahmegrundextension;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.*;

@Service
public class FhirEncounterextensionaufnahmegrundService extends ComplexDatatypeValidatable {

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the creation
     * @return new object
     */
    public FhirEncounterextensionaufnahmegrundI createEncounterextensionaufnahmegrund(Map<String, Object> data, UserI user) {
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
            FhirEncounterextensionaufnahmegrund result = new FhirEncounterextensionaufnahmegrund(user);

            List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("extension");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirAufnahmegrundextensionI entity = _aufnahmegrundextensionService.createAufnahmegrundextension(item, user);
                    result.addExtension(entity);
                }
            }

            return result;
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
    public Map<String, Object> makePropertyMap(FhirEncounterextensionaufnahmegrundI entity, UserI user) {
        // A record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        List<Map<String, Object>> items = new ArrayList<>();
        for (FhirAufnahmegrundextensionI item : entity.getExtension()) {
            Datatypes.appendIfPresent(items, _aufnahmegrundextensionService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "extension", items);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("extension");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_aufnahmegrundextensionService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirEncounterLocationService.class);

    @Autowired
    private FhirAufnahmegrundextensionService _aufnahmegrundextensionService;
}
