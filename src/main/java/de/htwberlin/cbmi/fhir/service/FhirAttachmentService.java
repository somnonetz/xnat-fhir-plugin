package de.htwberlin.cbmi.fhir.service;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Nullable;
import javax.xml.bind.DatatypeConverter;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.apache.commons.lang3.ArrayUtils;
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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
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
        Collection<String> invalidProperties = this.validateProperties(data);
        if (invalidProperties != null) {
            _log.debug("Attribute validation failed for: " + invalidProperties);
            return null;
        }

        try {
            // Build the result object
            FhirAttachment result = new FhirAttachment(user);
            result.setContenttype((String) data.get("contentType"));
            result.setLanguage((String) data.get("language"));
            result.setLabel((String) data.get("title"));
            result.setCreation(data.get("creation"));

            String base64Data = (String) data.get("data");
            if (base64Data != null) {
                // Build local URI
                byte bytes[] = DatatypeConverter.parseBase64Binary(base64Data);
                result.setUri("/data/xnat/archive/" + FhirAttachment.SCHEMA_ELEMENT_NAME + "/" + UUID.randomUUID().toString());
                File path = new File(this.getResourcePath(result));
                File parent = new File(path.getParent());
                if (!parent.exists() && !parent.mkdirs()) {
                    _log.error("Failed to create parent directory to store the file");
                    return null;
                }

                FileOutputStream fos = new FileOutputStream(path);
                fos.write(bytes);
                fos.close();

                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                byte[] hash = digest.digest(bytes);

                // Validate hashes
                String base64Hash = (String) data.get("hash");
                if (base64Hash != null) {
                    byte[] testHash = DatatypeConverter.parseBase64Binary(base64Hash);
                    if (!Arrays.equals(testHash, hash)) {
                        _log.error("Submitted hash does not match calculated hash of input data");
                        return null;
                    }
                }

                result.setFileSize(bytes.length);
                result.setHash(DatatypeConverter.printBase64Binary(hash));
                if (result.getContenttype() == null) {
                    result.setContenttype(Files.probeContentType(Paths.get(path.toURI())));
                }
            }
            else {
                result.setUri((String) data.get("url"));
                result.setFileSize(data.get("size"));
                result.setHash((String)data.get("hash"));
            }

            // Set XNAT resource properties
            result.setFileCount(1);

            /*
            result.setContenttype((String) data.get("contentType"));
            result.setLanguage((String) data.get("language"));
            result.setData((String)data.get("data"));
            result.setUrl((String) data.get("url"));
            result.setSize(data.get("size"));
            result.setHash((String)data.get("hash"));
            result.setTitle((String) data.get("title"));
            result.setCreation(data.get("creation"));
             */

            return result;
        }
        catch (Exception e) {
            _log.error("Attachement generation failed", e);
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
    public Map<String, Object> makePropertyMap(FhirAttachment entity, UserI user) {
        // An entity record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "contentType", entity.getContenttype());
        Datatypes.addIfPresent(result, "language", entity.getLanguage());

        File path = new File(this.getResourcePath(entity));
        if (path.exists() && path.isFile()) {
            try {
                byte[] fileContent = Files.readAllBytes(path.toPath());
                Datatypes.addIfPresent(result, "data", DatatypeConverter.printBase64Binary(fileContent));
            } catch (IOException e) {
                _log.error("Failed to read file bytes", e);
                return null;
            }
        }

        Datatypes.addIfPresent(result, "hash", entity.getHash());
        Datatypes.addIfPresent(result, "url", entity.getUri());
        Datatypes.addIfPresent(result, "size", entity.getFileSize());
        Datatypes.addIfPresent(result, "title", entity.getLabel());
        Datatypes.addIfPresent(result, "creation", entity.getCreation());

        return result;
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        return Datatypes.makeList("contentType", "language", "data", "url", "size", "hash", "title", "creation");
    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<? extends Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, String.class, String.class, String.class, Number.class, String.class,
                String.class, String.class);
    }

    private String getResourcePath(FhirAttachment attachement) {
        return attachement.getFullPath("/");
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirAddressService.class);
}
