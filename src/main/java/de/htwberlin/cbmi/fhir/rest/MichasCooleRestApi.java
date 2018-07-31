package de.htwberlin.cbmi.fhir.rest;

import de.htwberlin.cbmi.fhir.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xdat.model.XnatSubjectassessordataI;
import org.nrg.xdat.model.XnatSubjectdataI;
import org.nrg.xdat.om.FhirContactpoint;
import org.nrg.xdat.om.FhirPatient;
import org.nrg.xdat.om.XnatSubjectdata;
import org.nrg.xdat.rest.AbstractXapiRestController;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import org.nrg.xft.security.UserI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Api(description = "XNAT FHIR Translator API")
@XapiRestController
@RequestMapping(value = "/old_fhir")
public class MichasCooleRestApi extends AbstractXapiRestController {

    protected static <A> String _s(A input) {
        if (input != null) {
            return input.toString();
        }
        else {
            return "null";
        }
    }

    @Autowired
    public MichasCooleRestApi(final UserManagementServiceI userManagementService, final RoleHolder roleHolder, final SubjectService service) {
        super(userManagementService, roleHolder);
        _service = service;
    }

    @ApiOperation(value = "Returns a list of all subject mappings.",
            notes = "Disregards source system.",
            response = Hashtable.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject successfully retrieved."),
            @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Hashtable<String, Object>> getEntities(@PathVariable final String id, HttpServletRequest request) {
        //Enumeration<String> attributeNames = request.getAttributeNames();
        Hashtable<String, Object> properties = new Hashtable<>();

        final UserI user = getSessionUser();
        XnatSubjectdataI subject = _service.getSubject(id, user);

        List<XnatSubjectassessordataI> experiments = subject.getExperiments_experiment();
        ArrayList<Hashtable<String, String>> experimentList = new ArrayList<>();
        for (XnatSubjectassessordataI experiment : experiments) {
            Hashtable<String, String> experimentData = new Hashtable<>();
            experimentData.put("ID", _s(experiment.getId()));
            experimentData.put("xsiType", _s(experiment.getXSIType()));
            experimentData.put("original", _s(experiment.getOriginal()));
            experimentData.put("acquired_at", _s(experiment.getAcquisitionSite()));
            experimentData.put("label", _s(experiment.getLabel()));
            experimentData.put("age", _s(experiment.getAge()));
            experimentData.put("note", _s(experiment.getNote()));
            experimentList.add(experimentData);
        }

        properties.put("experiments", experimentList);
        properties.put("resourceType", "patient");

        ArrayList<Hashtable<String, String>> identifierList = new ArrayList<>();
        Hashtable<String, String> identifier = new Hashtable<>();
        identifier.put("value", subject.getLabel());
        identifierList.add(identifier);

        properties.put("identifier", identifierList);

        //properties.put("project", subject.getProject());
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @ApiOperation(value = "Bind a new Fhir patient data entity.",
            response = Boolean.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Fhir patient successfully bound."),
            @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
            @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
    public ResponseEntity<Boolean> makePatient(@PathVariable final String id, HttpServletRequest request) {
        final UserI user = getSessionUser();
        XnatSubjectdata subject = (XnatSubjectdata)_service.getSubject(id, user);
        if (subject == null) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }

        try {
            FhirPatient patientData = new FhirPatient(user);

            FhirContactpoint telecom = new FhirContactpoint(user);
            telecom.setRank(1);
            telecom.setUse("work");
            telecom.setSystem("phone");
            telecom.setValue("030/50193415");

            /*FhirPeriod period = new FhirPeriod(user);
            period.setStart(new Date());
            telecom.setPeriod((ItemI)period);*/
            telecom.setPeriod_start(new Date());
            patientData.addTelecom(telecom);

            patientData.setSubjectId(subject.getId());
            patientData.setId("FHIR_" + subject.getId());
            patientData.setLabel(subject.getLabel() + " FHIR extensions");
            patientData.setProject(subject.getProject());
            patientData.setGender("male");

            subject.addExperiments_experiment(patientData);
            patientData.save(user, true, true, null);
            //subject.save(user, true, true, null);
        } catch (Exception e) {
            _log.error(e.getMessage());
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //properties.put("project", subject.getProject());
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);
    }

    private final Logger _log = LoggerFactory.getLogger(MichasCooleRestApi.class);
    private final SubjectService _service;
}
