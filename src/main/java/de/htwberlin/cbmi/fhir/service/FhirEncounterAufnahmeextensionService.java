package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirEncounterextensionaufnahmegrundI;
import org.nrg.xdat.model.FhirEncounterAufnahmeextensionI;
import org.nrg.xdat.om.FhirEncounterextensionaufnahmegrund;
import org.nrg.xdat.om.FhirEncounterAufnahmeextension;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirEncounterAufnahmeextensionService extends ComplexDatatypeValidatable {

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the identifier creation
     * @return new object
     */
    public FhirEncounterAufnahmeextensionI createAufnahmegrundextension(Map<String, Object> data, UserI user) {
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
            FhirEncounterAufnahmeextension result = new FhirEncounterAufnahmeextension(user);

            FhirEncounterextensionaufnahmegrundI aufnahmegrund = _extensionaufnahmegrundService.createEncounterextensionaufnahmegrund((Map<String, Object>) data.get("Aufnahmegrund"), user);
            if (aufnahmegrund != null) {
                result.setAufnahmegrund(aufnahmegrund);
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
    public Map<String, Object> makePropertyMap(FhirEncounterAufnahmeextensionI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "Aufnahmegrund", _extensionaufnahmegrundService.makePropertyMap(entity.getAufnahmegrund(), user));

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("Aufnahmegrund");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_extensionaufnahmegrundService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirEncounterLocationService.class);

    @Autowired
    private FhirEncounterextensionaufnahmegrundService _extensionaufnahmegrundService;
}