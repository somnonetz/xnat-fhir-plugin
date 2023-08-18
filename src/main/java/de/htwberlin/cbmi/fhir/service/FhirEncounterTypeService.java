package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirEncounterTypeI;
import org.nrg.xdat.model.FhirCodeableconceptI;
import org.nrg.xdat.om.FhirEncounterType;
import org.nrg.xdat.om.FhirCodeableconcept;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirEncounterTypeService extends ComplexDatatypeValidatable {

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the identifier creation
     * @return new object
     */
    public FhirEncounterTypeI createEncounterType(Map<String, Object> data, UserI user) {
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
            FhirEncounterType result = new FhirEncounterType(user);

            FhirCodeableconceptI kontaktEbene = _codeableConceptService.createCodeableConcept((Map<String, Object>) data.get("Kontaktebene"), user);
            if (kontaktEbene != null) {
                result.setKontaktebene(kontaktEbene);
            }

            FhirCodeableconceptI kontaktArt = _codeableConceptService.createCodeableConcept((Map<String, Object>) data.get("KontaktArt"), user);
            if (kontaktArt != null) {
                result.setKontaktart(kontaktArt);
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
    public Map<String, Object> makePropertyMap(FhirEncounterTypeI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        Datatypes.addIfPresent(result, "Kontaktebene", _codeableConceptService.makePropertyMap(entity.getKontaktebene(), user));
        Datatypes.addIfPresent(result, "KontaktArt", _codeableConceptService.makePropertyMap(entity.getKontaktart(), user));

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("Kontaktebene", "KontaktArt");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_codeableConceptService, _codeableConceptService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirSinglestringvalueService.class);

    @Autowired
    private FhirCodeableConceptService _codeableConceptService;
}
