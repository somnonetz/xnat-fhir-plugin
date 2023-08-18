package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirExtensionI;
import org.nrg.xdat.model.FhirAufnahmegrundextensionI;
import org.nrg.xdat.om.FhirExtension;
import org.nrg.xdat.om.FhirAufnahmegrundextension;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirAufnahmegrundextensionService extends ComplexDatatypeValidatable {

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the identifier creation
     * @return new object
     */
    public FhirAufnahmegrundextensionI createAufnahmegrundextension(Map<String, Object> data, UserI user) {
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
            FhirAufnahmegrundextension result = new FhirAufnahmegrundextension(user);

            FhirExtensionI ersteUndZweiteStelle = _extensionService.createExtension((Map<String, Object>) data.get("ErsteUndZweiteStelle"), user);
            if (ersteUndZweiteStelle != null) {
                result.setErsteundzweitestelle(ersteUndZweiteStelle);
            }

            FhirExtensionI dritteStelle = _extensionService.createExtension((Map<String, Object>) data.get("DritteStelle"), user);
            if (dritteStelle != null) {
                result.setDrittestelle(dritteStelle);
            }

            FhirExtensionI vierteStelle = _extensionService.createExtension((Map<String, Object>) data.get("VierteStelle"), user);
            if (vierteStelle != null) {
                result.setViertestelle(vierteStelle);
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
    public Map<String, Object> makePropertyMap(FhirAufnahmegrundextensionI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "ErsteUndZweiteStelle", _extensionService.makePropertyMap(entity.getErsteundzweitestelle(), user));
        Datatypes.addIfPresent(result, "DritteStelle", _extensionService.makePropertyMap(entity.getDrittestelle(), user));
        Datatypes.addIfPresent(result, "VierteStelle", _extensionService.makePropertyMap(entity.getViertestelle(), user));

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("ErsteUndZweiteStelle", "DritteStelle", "VierteStelle");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_extensionService, _extensionService, _extensionService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirEncounterLocationService.class);

    @Autowired
    private FhirExtensionService _extensionService;
}
