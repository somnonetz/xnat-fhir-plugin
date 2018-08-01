package de.htwberlin.cbmi.fhir.rest;

import de.htwberlin.cbmi.fhir.service.FhirPatientService;
import de.htwberlin.cbmi.fhir.service.SubjectService;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xdat.model.FhirPatientI;
import org.nrg.xdat.rest.AbstractXapiRestController;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

@Api(description = "XNAT FHIR Translator API - Patient Datatype")
@XapiRestController
@RequestMapping(value = "/fhir/Patient")
public class FhirPatientApi extends AbstractXapiRestController {

    @Autowired
    public FhirPatientApi(final UserManagementServiceI userManagementService, final RoleHolder roleHolder, final FhirPatientService patientService) {
        super(userManagementService, roleHolder);
        _patientService = patientService;
    }

    @ApiOperation(value = "Request a FHIRPatient record.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> get(@PathVariable final Integer id, HttpServletRequest request) {
        Hashtable<String, Object> properties = new Hashtable<>();
        final UserI user = getSessionUser();

        // Read the patient record from the data service
        FhirPatientI record = _patientService.getPatient(id, user);
        if (record == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Build the result map out of the fetched object
        Map<String, Object> data = _patientService.makePropertyMap(record, user);
        if (data != null) {
            data.put("resourceType", "Patient");
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Create a FHIRPatient record.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Record successfully created."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, ?>> create(@RequestBody Map<String, Object> data, HttpServletRequest request) {
        final UserI user = getSessionUser();

        // Read the JSON from the request
        /*Map<String, Object> data = null;
        try {
            data = Datatypes.readJsonString(request.getReader());
        }
        catch (IOException ioe) {
            _log.error("Failed to read submitted JSON");
            _log.error(ioe.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/

        // Check if parsing succeeded and data is valid for our request
        if (data == null) {
            _log.error("Request was empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Collection<String> invalidKeys = _patientService.validateProperties(data);
        if (invalidKeys != null) {
            _log.error("Property validation failed for keys: " + invalidKeys);
            _log.error("Data was: " + data);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // FHIR has no association of patients to projects
        // however XNAT requires such a mapping - we will put patients into the "fhir"-project for now
        FhirPatientI record = _patientService.createPatient(data, user);
        if (record != null) {
            Map<String, Object> result_data = _patientService.makePropertyMap(record, user);
            result_data.put("resourceType", "Patient");
            result_data.put("id", _patientService.getPatientId(record).toString());
            return new ResponseEntity<>(result_data, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // We want a default logger
    private final Logger _log = LoggerFactory.getLogger(FhirPatientApi.class);

    // Service to interact with persistence API
    private final FhirPatientService _patientService;
}
