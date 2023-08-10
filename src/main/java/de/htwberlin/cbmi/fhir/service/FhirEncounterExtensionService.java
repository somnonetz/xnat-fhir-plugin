package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirExtensionI;
import org.nrg.xdat.om.FhirExtension;
import org.nrg.xdat.model.FhirEncounterExtensionI;
import org.nrg.xdat.om.FhirEncounterExtension;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FhirEncounterExtensionService extends ComplexDatatypeValidatable {

    /**
     * Build a new extension out of the given data
     * @param data JSON data submitted to create the new extension
     * @param user user that requested the identifier creation
     * @return new extension object
     */
    public FhirEncounterExtensionI createEncounterExtension(Map<String, Object> data, UserI user) {
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
            FhirEncounterExtension result = new FhirEncounterExtension(user);
            FhirExtensionI entlassungsgrund = _extensionService.createExtension((Map<String, Object>)data.get("Entlassungsgrund"), user);
            if (entlassungsgrund != null) {
                result.setEntlassungsgrund(entlassungsgrund);
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
    public Map<String, Object> makePropertyMap(FhirEncounterExtensionI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "Entlassungsgrund", _extensionService.makePropertyMap(entity.getEntlassungsgrund(), user));


        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    @Override
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("Entlassungsgrund");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    @Override
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_extensionService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirExtensionService.class);

    @Autowired
    private FhirExtensionService _extensionService;
}
