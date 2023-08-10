package org.apache.turbine.app.xnat.modules.screens;

import de.htwberlin.cbmi.fhir.service.FhirPatientService;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.nrg.xdat.XDAT;
import org.nrg.xdat.bean.FhirPatientBean;
import org.nrg.xdat.model.FhirPatientI;
import org.nrg.xdat.om.XnatSubjectdata;
import org.nrg.xft.XFTItem;
import org.nrg.xft.exception.ElementNotFoundException;
import org.nrg.xft.exception.FieldNotFoundException;
import org.nrg.xft.exception.XFTInitException;
import org.nrg.xnat.turbine.modules.screens.EditSubjectAssessorScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class XDATScreen_edit_fhir_patient extends EditSubjectAssessorScreen {
    @Override
    public String getElementName(){ return FhirPatientBean.SCHEMA_ELEMENT_NAME; }

    @Override
    public void finalProcessing(RunData data, Context context) {
        super.finalProcessing(data,context);

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

            context.put("label", FhirPatientService.getPatientDataLabelForSubjectId(subjectId));
            // Try to find data associated with the given subject
            // because a single subject can only have exactly one FHIR patient record
            FhirPatientI item = FhirPatientService.getPatientForSubject(subjectId, XDAT.getUserDetails());
            if (item != null) {
                // Publish an existing item for subjectId
                context.put("item", item);
            }
                // create a new item for subjectId
        }
        catch (XFTInitException | ElementNotFoundException | FieldNotFoundException e) {
            final String message = "An error occurred trying to get the subject ID when adding the patient information.";
            throw new RuntimeException(message, e);
        }
    }
}
