package de.htwberlin.cbmi.fhir.test;

import de.htwberlin.cbmi.fhir.service.*;
import org.hibernate.SessionFactory;
import org.nrg.framework.services.NrgEventService;
import org.nrg.prefs.repositories.ToolRepository;
import org.nrg.prefs.services.NrgPreferenceService;
import org.nrg.prefs.services.PreferenceService;
import org.nrg.prefs.services.ToolService;
import org.nrg.prefs.services.impl.DefaultNrgPreferenceService;
import org.nrg.prefs.services.impl.hibernate.HibernatePreferenceService;
import org.nrg.prefs.services.impl.hibernate.HibernateToolService;
import org.nrg.xdat.preferences.SiteConfigPreferences;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import reactor.bus.EventBus;

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

    @Bean
    public SiteConfigPreferences scp() {
        return null;
    }
}
