package de.htwberlin.cbmi.fhir.service;

import javax.annotation.Nullable;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.bean.FhirIdentifierBean;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.model.*;
import org.nrg.xdat.om.*;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service to build and request FHIRIdentity records
 */
@Service
public class FhirNameService extends DatatypeValidatable {
    /**
     * Build a new name out of the given data
     * @param data JSON data submitted to create the new name
     * @param user user that requested the identifier creation
     * @return new name object
     */
    public FhirHumannameI createName(Map<String, Object> data, UserI user) {
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
            FhirHumanname result = new FhirHumanname(user);
            result.setUse((String) data.get("use"));
            result.setText((String) data.get("text"));
            result.setFamily((String) data.get("family"));

            List<String> items = (List<String>) data.get("given");
            if (items != null) {
                for (String item : items) {
                    FhirHumannameGivenI entity = new FhirHumannameGiven(user);
                    entity.setGiven(item);
                    result.addGiven(entity);
                }
            }

            items = (List<String>) data.get("prefix");
            if (items != null) {
                for (String item : items) {
                    FhirHumannamePrefixI entity = new FhirHumannamePrefix(user);
                    entity.setPrefix(item);
                    result.addPrefix(entity);
                }
            }

            items = (List<String>) data.get("suffix");
            if (items != null) {
                for (String item : items) {
                    FhirHumannameSuffixI entity = new FhirHumannameSuffix(user);
                    entity.setSuffix(item);
                    result.addSuffix(entity);
                }
            }


            Map<String, Object> period = (Map<String, Object>)data.get("period");
            if (period != null) {
                result.setPeriod_start(period.get("start"));
                result.setPeriod_end(period.get("end"));
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
    public Map<String, Object> makePropertyMap(FhirHumannameI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "use", entity.getUse());
        Datatypes.addIfPresent(result, "text", entity.getText());
        Datatypes.addIfPresent(result, "family", entity.getFamily());

        List<String> items = new ArrayList<>();
        for (FhirHumannameGivenI item : entity.getGiven()) {
            items.add(item.getGiven());
        }
        Datatypes.addIfNotEmpty(result, "given", items);

        items = new ArrayList<>();
        for (FhirHumannamePrefixI item : entity.getPrefix()) {
            items.add(item.getPrefix());
        }
        Datatypes.addIfNotEmpty(result, "prefix", items);

        items = new ArrayList<>();
        for (FhirHumannameSuffixI item : entity.getSuffix()) {
            items.add(item.getSuffix());
        }
        Datatypes.addIfNotEmpty(result, "suffix", items);
        this.exportPeriod(entity.getPeriod_start(), entity.getPeriod_end(), result);

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("use", "text", "family", "given", "prefix", "suffix",
                "period", "period.start", "period.end");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, String.class, String.class, String.class,
                Map.class, String.class, String.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirNameService.class);

    @Autowired
    private FhirReferenceService _referenceService;
}
