package de.htwberlin.cbmi.fhir.service;

import org.nrg.xdat.model.XnatSubjectdataI;
import org.nrg.xft.ItemI;
import org.nrg.xft.collections.ItemCollection;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    public SubjectService(final JdbcTemplate template) {
        _template = template;
    }

    public XnatSubjectdataI getSubject(final String subjectId, UserI user) {
        try {
            ItemCollection results = org.nrg.xft.search.ItemSearch.GetItems("xnat:subjectData/ID", subjectId, user, true);
            ItemI match = results.getFirst();
            if (match!=null) {
                XnatSubjectdataI result = (XnatSubjectdataI) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
                if (result != null) {
                    return result;
                }
                else {

                    _log.error("GetGeneratedItem hat null zurueckgegeben");
                    return null;
                }
            }
            else {
                _log.error("Nix jefunden");
                return null;
            }
        } catch (Exception e) {
            _log.error("AAAAAAAHHHHHHH" + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    private static final Logger _log = LoggerFactory.getLogger(SubjectService.class);
    private final JdbcTemplate _template;
}
