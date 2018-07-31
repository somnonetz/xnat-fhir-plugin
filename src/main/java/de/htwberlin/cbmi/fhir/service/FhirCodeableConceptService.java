package de.htwberlin.cbmi.fhir.service;

import javax.annotation.Nullable;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.model.FhirCodeableconceptI;
import org.nrg.xdat.model.FhirCodingI;
import org.nrg.xdat.om.FhirCodeableconcept;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service to build and request FHIRCodableConcept records
 */
@Service
public class FhirCodeableConceptService extends DatatypeValidatable {
    /**
     * Build a new codeable concept out of the given data
     * @param data JSON data submitted to create the new codeable concept
     * @param user user that requested the codeable concept creation
     * @return new codeable concept object
     */
    public FhirCodeableconceptI createCodeableConcept(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        // Verify handed properties
        if (!this.validateProperties(data)) {
            _log.debug("Attribute validation failed");
            return null;
        }

        // Build the result object
        try {
            FhirCodeableconcept result = new FhirCodeableconcept(user);
            result.setText((String) data.get("text"));
            List<Map<String, Object>> items = (List<Map<String, Object>>) data.get("coding");
            if (items != null) {
                for (Map<String, Object> item : items) {
                    FhirCodingI entity = _codingService.createCoding(item, user);
                    result.addCoding(entity);
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
    public Map<String, Object> makePropertyMap(FhirCodeableconceptI entity, UserI user) {
        // A record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "text", entity.getText());
        List<Map<String, Object>> items = new ArrayList<>();
        for (FhirCodingI item : entity.getCoding()) {
            Datatypes.appendIfPresent(items, _codingService.makePropertyMap(item, user));
        }
        Datatypes.addIfNotEmpty(result, "coding", items);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        Collection<String> result = Datatypes.makeSet("text", "coding");
        result.addAll(_codingService.getAllowedKeys("coding"));
        return result;
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, _codingService);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirCodeableConceptService.class);

    @Autowired
    private FhirCodingService _codingService;
}