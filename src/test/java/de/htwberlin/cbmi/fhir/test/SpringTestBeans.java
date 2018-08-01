package de.htwberlin.cbmi.fhir.test;

import de.htwberlin.cbmi.fhir.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestBeans {
    @Bean
    public FhirPatientService fps() {
        return new FhirPatientService();
    }

    @Bean
    public FhirAddressService fas() {
        return new FhirAddressService();
    }

    @Bean
    public FhirAttachmentService fatts() {
        return new FhirAttachmentService();
    }

    @Bean
    public FhirCodeableConceptService fccs() {
        return new FhirCodeableConceptService();
    }

    @Bean
    public FhirCodingService fcs() {
        return new FhirCodingService();
    }

    @Bean
    public FhirContactPointService fcps() {
        return new FhirContactPointService();
    }

    @Bean
    public FhirIdentityService fis() {
        return new FhirIdentityService();
    }

    @Bean
    public FhirNameService fns() {
        return new FhirNameService();
    }

    @Bean
    public FhirReferenceService frs() {
        return new FhirReferenceService();
    }
}
