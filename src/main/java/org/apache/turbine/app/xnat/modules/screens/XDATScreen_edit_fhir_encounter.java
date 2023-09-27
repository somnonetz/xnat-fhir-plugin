package org.apache.turbine.app.xnat.modules.screens;

import de.htwberlin.cbmi.fhir.rest.FhirPatientApi;
import de.htwberlin.cbmi.fhir.service.FhirEncounterService;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.nrg.xdat.XDAT;
import org.nrg.xdat.bean.FhirEncounterBean;
import org.nrg.xdat.model.FhirEncounterI;
import org.nrg.xdat.om.XnatSubjectdata;
import org.nrg.xft.XFTItem;
import org.nrg.xft.exception.ElementNotFoundException;
import org.nrg.xft.exception.FieldNotFoundException;
import org.nrg.xft.exception.XFTInitException;
import org.nrg.xnat.turbine.modules.screens.EditSubjectAssessorScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XDATScreen_edit_fhir_encounter extends EditSubjectAssessorScreen {

    @Override
    public String getElementName(){ return FhirEncounterBean.SCHEMA_ELEMENT_NAME; }

    @Override
    public void finalProcessing(RunData data, Context context) {
        super.finalProcessing(data,context);

        // debug info
        /*
        _log.error("++++++++++++++++++++++++Context Content:");
        for (Object key : context.getKeys() ) {
            _log.error(key + " : " + context.get(key.toString()));
        }
        _log.error("++++++++++++++++++++++++Context End");
        */

        try {
            final String subjectId;
            if (!context.containsKey("subjectId")) {
                if (context.containsKey("part")) {
                    final Object part = context.get("part");
                    if (part instanceof XnatSubjectdata) {
                        subjectId = ((XnatSubjectdata) part).getId();
                    } else if (part instanceof XFTItem) {
                        subjectId = ((XFTItem) part).getStringProperty("ID");
                    } else {
                        subjectId = part.toString();
                    }
                    context.put("subjectId", subjectId);
                } else {
                    subjectId = (String) context.get("part_id");
                }
            } else {
                subjectId = (String) context.get("subjectId");
            }

            String label = FhirEncounterService.getNextEncounterDataLabel(XDAT.getUserDetails());
            context.put("label", label);

            FhirEncounterI item = FhirEncounterService.getEncounterForLabel(label, XDAT.getUserDetails());
            if (item != null) {
                context.put("item", item);
            }
        }
        catch (XFTInitException | ElementNotFoundException | FieldNotFoundException e) {
            final String message = "An error occurred trying to get the subject ID when adding the encounter information.";
            _log.error(message);
            throw new RuntimeException(message, e);
        }
    }

    private final Logger _log = LoggerFactory.getLogger(XDATScreen_edit_fhir_encounter.class);
}
