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
 * Service to build and request FHIRAttachment records
 */
@Service
public class FhirAttachmentService extends DatatypeValidatable {
    /**
     * Build a new Attachment out of the given data
     * @param data JSON data submitted to create the new Attachment
     * @param user user that requested the identifier creation
     * @return new Attachment object
     */
    public FhirAttachment createAttachment(Map<String, Object> data, UserI user) {
        // Don't create new object without any data
        if (data == null) {
            return null;
        }

        // Verify handed properties
        if (!this.validateProperties(data)) {
            _log.debug("Attribute validation failed");
            return null;
        }

        try {
            // Build the result object
            FhirAttachment result = new FhirAttachment(user);
            result.setContenttype((String) data.get("contentType"));
            result.setLanguage((String) data.get("language"));
            result.setData((String)data.get("data"));
            result.setUrl((String) data.get("url"));
            result.setSize(data.get("size"));
            result.setHash((String)data.get("hash"));
            result.setTitle((String) data.get("title"));
            result.setCreation(data.get("creation"));

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
    public Map<String, Object> makePropertyMap(FhirAttachmentI entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "contentType", entity.getContenttype());
        Datatypes.addIfPresent(result, "language", entity.getLanguage());
        Datatypes.addIfPresent(result, "data", entity.getData());
        Datatypes.addIfPresent(result, "url", entity.getUrl());
        Datatypes.addIfPresent(result, "size", entity.getSize());
        Datatypes.addIfPresent(result, "hash", entity.getHash());
        Datatypes.addIfPresent(result, "title", entity.getTitle());
        Datatypes.addIfPresent(result, "creation", entity.getCreation());

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeSet("contentType", "language", "data", "url", "size", "hash", "title", "creation");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, String.class, Number.class, String.class, String.class, Date.class);
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirAddressService.class);
}
