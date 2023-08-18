package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.ComplexDatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirEncounterLocationI;
import org.nrg.xdat.model.FhirReferenceI;
import org.nrg.xdat.model.FhirCodeableconceptI;
import org.nrg.xdat.om.FhirEncounterLocation;
import org.nrg.xdat.om.FhirReference;
import org.nrg.xdat.om.FhirCodeableconcept;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirEncounterLocationService extends ComplexDatatypeValidatable {

    /**
     * Build a new object out of the given data
     * @param data JSON data submitted to create the new object
     * @param user user that requested the identifier creation
     * @return new object
     */
    public FhirEncounterLocationI createEncounterLocation(Map<String, Object> data, UserI user) {
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
            FhirEncounterLocation result = new FhirEncounterLocation(user);

            FhirReferenceI location = _referenceService.createReference((Map<String, Object>) data.get("location"), user);
            if (location != null) {
                result.setLocation(location);
            }

            result.setStatus((String) data.get("status"));

            FhirCodeableconceptI physicalType = _codeableConceptService.createCodeableConcept((Map<String, Object>) data.get("physicalType"), user);
            if (physicalType != null) {
                result.setPhysicaltype(physicalType);
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
    public Map<String, Object> makePropertyMap(FhirEncounterLocationI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "location", _referenceService.makePropertyMap(entity.getLocation(), user));
        Datatypes.addIfPresent(result, "status", entity.getStatus());
        Datatypes.addIfPresent(result, "physicalType", _codeableConceptService.makePropertyMap(entity.getPhysicaltype(), user));
        this.exportPeriod(entity.getPeriod_start(), entity.getPeriod_end(), result);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("location", "status", "physicalType", "period", "period.start", "period.end");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(_referenceService, String.class, _codeableConceptService, Map.class, String.class, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirEncounterLocationService.class);

    @Autowired
    private FhirCodeableConceptService _codeableConceptService;

    @Autowired
    private FhirReferenceService _referenceService;
}
