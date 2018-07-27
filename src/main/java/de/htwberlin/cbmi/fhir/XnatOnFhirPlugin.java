package de.htwberlin.cbmi.fhir;

import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntityService;
import org.nrg.xdat.bean.FhirContactpointBean;
import org.nrg.xdat.bean.FhirHumannameBean;
import org.nrg.xdat.bean.FhirIdentifierBean;
import org.nrg.xdat.bean.FhirPatientBean;
import org.nrg.xdat.bean.FhirAddressBean;
import org.nrg.xdat.bean.FhirReferenceBean;
import org.nrg.xdat.bean.FhirAttachementBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(
        name = "XNAT to FHIR Interface Plugin", value = "xnat-on-fhir",
        namespace = "de.htwberlin.cbmi",
        description = "Dies ist das Testplugin mit dem wir ausprobieren, ob man in XNAT Plugins machen kann :)",
        dataModels = {
                @XnatDataModel(value = FhirContactpointBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR ContactPoint",
                        plural = "FHIR ContactPoints"),
                @XnatDataModel(value = FhirIdentifierBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR Identifier",
                        plural = "FHIR Identifiers"),
                @XnatDataModel(value = FhirHumannameBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR HumanName",
                        plural = "FHIR HumanNames"),
                @XnatDataModel(value = FhirAddressBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR Address",
                        plural = "FHIR Addresses"),
                @XnatDataModel(value = FhirAttachementBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR Attachement",
                        plural = "FHIR Attachements"),
                @XnatDataModel(value = FhirReferenceBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR Reference",
                        plural = "FHIR References"),
                @XnatDataModel(value = FhirPatientBean.SCHEMA_ELEMENT_NAME,
                        singular = "FHIR Patient",
                        plural = "FHIR Patients")
                })
@ComponentScan({"de.htwberlin.cbmi.fhir", "de.htwberlin.cbmi.fhir.entity", "de.htwberlin.cbmi.fhir.rest",
        "de.htwberlin.cbmi.fhir.service"})
public class XnatOnFhirPlugin {
    //@Bean
    /*public String cbmiPluginMessage() {
        return "Hello there from the cbmi plugin!";
    }*/
}
