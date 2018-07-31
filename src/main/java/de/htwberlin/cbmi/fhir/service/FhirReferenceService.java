package de.htwberlin.cbmi.fhir.service;

import de.htwberlin.cbmi.fhir.utils.DatatypeValidatable;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.nrg.xdat.base.BaseElement;
import org.nrg.xdat.bean.*;
import org.nrg.xdat.model.FhirIdentifierI;
import org.nrg.xdat.model.FhirReferenceI;
import org.nrg.xdat.om.FhirReference;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.search.ItemSearch;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FhirReferenceService extends DatatypeValidatable {

    /**
     * Search matching reference based on the unique reference field
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirReferenceI record or null if none was found
     */
    @Nullable
    public FhirReferenceI getReference(String value, UserI user) {
        return this.getFromDB("reference", value, user);
    }

    /**
     * Search matching reference based on the database id
     * @param id record id
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirReferenceI record or null if none was found
     */
    @Nullable
    public FhirReferenceI get(Integer id, UserI user) {
        return this.getFromDB("ID", id, user);
    }

    /**
     * Resolve the given reference description
     * @param reference internal logical idenfier @see https://www.hl7.org/fhir/resource.html#id
     * @param user User that requests the object
     * @return Item associated with this reference or null if none was found
     */
    public ItemI resolve(String reference, UserI user) {
        return resolve(reference, null, null, user);
    }
    /**
     * Resolve the given reference description
     * @param reference internal logical idenfier @see https://www.hl7.org/fhir/resource.html#id
     * @param identifier literal identifier @see https://www.hl7.org/fhir/resource.html#identifiers
     * @param user User that requests the object
     * @return Item associated with this reference or null if none was found
     */
    public ItemI resolve(String reference, FhirIdentifierI identifier, UserI user) {
        return resolve(reference, identifier, null, user);
    }

    /**
     * Resolve the given reference description
     * @param reference internal logical idenfier @see https://www.hl7.org/fhir/resource.html#id
     * @param identifier literal identifier @see https://www.hl7.org/fhir/resource.html#identifiers
     * @param display Display information of the record
     * @param user User that requests the object
     * @return Item associated with this reference or null if none was found
     */
    public ItemI resolve(String reference, FhirIdentifierI identifier, String display, UserI user) {
        return null;
    }

    /**
     * Build a new reference out of the given data
     * @param data JSON data submitted to create the new reference
     * @param user user that requested the identifier creation
     * @return new reference object
     */
    public FhirReferenceI createReference(Map<String, Object> data, UserI user) {
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
            FhirReference result = new FhirReference(user);
            result.setReference((String) data.get("reference"));
            FhirIdentifierI identifier = _identityService.createIdentifier((Map<String, Object>)data.get("identifier"), user);
            if (identifier != null) {
                result.setIdentifier(identifier);
            }
            result.setDisplay((String) data.get("display"));

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
    public Map<String, Object> makePropertyMap(FhirReferenceI entity, UserI user) {
        // A record should be present for export
        if (entity == null) {
            return null;
        }

        // Build result hashmap
        HashMap<String, Object> result = new HashMap<>();

        // Push simple elements
        Datatypes.addIfPresent(result, "reference", entity.getReference());
        Datatypes.addIfPresent(result, "identifier", _identityService.makePropertyMap(entity.getIdentifier(), user));
        Datatypes.addIfPresent(result, "display", entity.getDisplay());

        return result;
    }

    public String translateDatatype(String fhirType) {
        switch (fhirType) {
            case "Patient":
                return FhirPatientBean.SCHEMA_ELEMENT_NAME;
            case "ContactPoint":
                return FhirContactpointBean.SCHEMA_ELEMENT_NAME;
            case "Identifier":
                return FhirIdentifierBean.SCHEMA_ELEMENT_NAME;
            case "HumanName":
                return FhirHumannameBean.SCHEMA_ELEMENT_NAME;
            case "Address":
                return FhirAddressBean.SCHEMA_ELEMENT_NAME;
            case "Attachement":
                return FhirAttachmentBean.SCHEMA_ELEMENT_NAME;
            default:
                return null;
        }
    }

    /**
     * Allowed keys in this datatype
     * @return Collection of keys allowed to be present
     */
    public Collection<String> getAllowedKeys() {
        Collection<String> result =  Datatypes.makeSet("reference", "identifier", "display");
        result.addAll(_identityService.getAllowedKeys("identifier"));
        return result;

    }

    /**
     * Allowed key types in this datatype
     * @return Collection of types aligned to getAllowedKeys() allowed to be present
     */
    public Collection<Object> getAllowedKeyTypes() {
        return Datatypes.makeList(String.class, _identityService, String.class);
    }

    /**
     * Search unique identifier based on the database
     * @param path Search path
     * @param value Value to match
     * @param user User authenticated in the system (will be handed to ItemSearch.GetItems)
     * @return FhirIdentifier record or null if none was found
     */
    @Nullable
    private FhirReferenceI getFromDB(String path, Object value, UserI user) {
        try {
            String xmlPath = String.format("%s/%s", FhirReferenceBean.SCHEMA_ELEMENT_NAME, path);
            ItemCollection results = ItemSearch.GetItems(xmlPath, value, user, true);
            if (results.size() == 0) {
                _log.debug("Unable to find FhirReference with %s=%s", path, value);
                return null;
            }

            if (results.size() > 1) {
                _log.info("Found multiple FhirReference with %s=%s. But record should be unique. Proceed with first match.", path, value);
            }

            ItemI match = results.getFirst();
            return (FhirReferenceI) BaseElement.GetGeneratedItem(match);
        } catch (Exception e) {
            _log.error("Failed to unpack FhirReference: " + e.toString());
            return null;
        }
    }

    /// We want a logger to tell everyone about errors
    private static final Logger _log = LoggerFactory.getLogger(FhirReferenceService.class);

    @Autowired
    private FhirIdentityService _identityService;
}
