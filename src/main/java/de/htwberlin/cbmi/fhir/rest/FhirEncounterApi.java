package de.htwberlin.cbmi.fhir.rest;

import de.htwberlin.cbmi.fhir.service.FhirEncounterService;
import org.nrg.xdat.model.FhirEncounterI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xapi.rest.AbstractXapiRestController;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Api("XNAT FHIR Translator API - Encounter")
@XapiRestController
@RequestMapping(value = "/fhir/encounter")
public class FhirEncounterApi extends AbstractXapiRestController {

    @Autowired
    public FhirEncounterApi(final UserManagementServiceI userManagementService, final RoleHolder roleHolder, final FhirEncounterService encounterService) {
        super(userManagementService, roleHolder);
        _encounterService = encounterService;
    }

    @ApiOperation(value = "Create a FHIR Encounter record.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Record successfully created."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> data, HttpServletRequest request) {
        final UserI user = getSessionUser();

        // Check if parsing succeeded and data is valid for our request
        if (data == null) {
            _log.error("Request was empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Collection<String> invalidKeys = _encounterService.validateProperties(data);
        if (invalidKeys != null) {
            _log.error("Property validation failed for keys: " + invalidKeys);
            _log.error("Data was: " + data);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FhirEncounterI record = _encounterService.createEncounter(data, user);
        if (record != null) {
            Map<String, Object> result_data = _encounterService.makePropertyMap(record, user);
            result_data.put("resourceType", "Encounter");
            result_data.put("id", _encounterService.getEncounterId(record).toString());
            return new ResponseEntity<>(result_data, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Request a FHIR Encounter record with subject ID.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{subject_id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> get(@PathVariable final String subject_id, HttpServletRequest request) {

        final UserI user = getSessionUser();

        FhirEncounterI record = _encounterService.getEncounterForSubject(subject_id, user);
        return getSingleRecord(record, user);
    }

    @ApiOperation(value = "Request a FHIR Encounter record with patient ID.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "/patient/{patient_id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getForPatient(@PathVariable final String patient_id, HttpServletRequest request) {

        final UserI user = getSessionUser();

        FhirEncounterI record = _encounterService.getEncounterForPatient(patient_id, user);
        return getSingleRecord(record, user);
    }

    @ApiOperation(value = "Request a FHIR Encounter record with case ID.", response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "/case/{case_id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getForCase(@PathVariable final String case_id, HttpServletRequest request) {

        final UserI user = getSessionUser();

        FhirEncounterI record = _encounterService.getEncounterForCase(case_id, user);
        return getSingleRecord(record, user);
    }

    @ApiOperation(value = "Request a FHIR Encounter record with department ID.",
            response = Map.class, responseContainer = "list")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "/department/{department_id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getForDepartment(@PathVariable final String department_id, HttpServletRequest request) {

        final UserI user = getSessionUser();

        List<FhirEncounterI> records = _encounterService.getEncounterForDepartment(department_id, user);

        return getListRecord(records, user);
    }

    @ApiOperation(value = "Request a FHIR Encounter record with period.",
            response = Map.class, responseContainer = "list")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Record successfully received."),
            @ApiResponse(code = 401, message = "Must be authenticated to access this REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "/period", params = {"start", "end"}, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getForPeriod(@RequestParam(value = "start") String start,
                                                                  @RequestParam(value = "end") String end, HttpServletRequest request) {

        final UserI user = getSessionUser();

        List<FhirEncounterI> records = _encounterService.getEncounterForPeriod(start, end, user);

        return getListRecord(records, user);
    }

    private ResponseEntity<List<Map<String, Object>>> getListRecord(List<FhirEncounterI> records, UserI user) {
        if (records == null || records.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Map<String, Object>> retVal = new ArrayList<>();

        for(FhirEncounterI oneEncounter : records) {
            Map<String, Object> data = _encounterService.makePropertyMap(oneEncounter, user);
            if (data != null) {
                data.put("resourceType", "Encounter");
                retVal.add(data);
            }
        }

        if (retVal.size() > 0) {
            return new ResponseEntity<>(retVal, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<Map<String, Object>> getSingleRecord(FhirEncounterI record, UserI user) {

        if (record == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Build the result map out of the fetched object
        Map<String, Object> data = _encounterService.makePropertyMap(record, user);
        if (data != null) {
            data.put("resourceType", "Encounter");
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private final Logger _log = LoggerFactory.getLogger(FhirEncounterApi.class);

    // Service to interact with persistence API
    private final FhirEncounterService _encounterService;
}
