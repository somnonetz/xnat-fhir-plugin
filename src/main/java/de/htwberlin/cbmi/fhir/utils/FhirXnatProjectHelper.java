package de.htwberlin.cbmi.fhir.utils;

import de.htwberlin.cbmi.fhir.service.FhirEncounterService;
import org.nrg.xdat.model.XnatSubjectdataI;
import org.nrg.xdat.om.XnatSubjectdata;
import org.nrg.xft.XFTTable;
import org.nrg.xft.search.TableSearch;
import org.nrg.xft.security.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class FhirXnatProjectHelper {

    /**
     * Build the subject id like it is stored in the database
     * @param id ID to build the identifier for
     * @return Result string
     */
    public static String getSubjectIdFromId(Integer id) {
        return String.format("XNAT_S%05d", id);
    }

    /**
     * Build the unique label for the given subject id
     * @param subjectId Subject id to build the label for
     * @return Record label
     */
    @Nonnull
    public static String getLabelForSubjectId(String subjectId) {
        return "fhir_subject_" + subjectId;
    }

    /**
     * Build the unique label for the given subject
     * @param subject Subject to build the label for
     * @return Record label
     */
    @Nonnull
    public static String getLabelForSubject(XnatSubjectdataI subject) {
        return getLabelForSubjectId(subject.getId());
    }

    /**
     * Find anew unique project id matching the XNAT schema
     * @param subject Subject to find new id for
     * @param user Authenticated user
     * @return New subject id to assign
     */
    public static String makeSubjectId(XnatSubjectdata subject, UserI user) {
        if (subject.getId() != null) {
            return subject.getId();
        }

        try {
            XFTTable table = TableSearch.Execute("SELECT id FROM xnat_subjectdata ORDER BY id DESC LIMIT 1", subject.getItem().getDBName(),null);
            table.resetRowCursor();
            int subjectId = 1;

            if (table.hasMoreRows()) {
                final Hashtable row = table.nextRowHash();
                final String databaseId  = (String)row.get("id");
                final Scanner sc = new Scanner(databaseId);
                sc.findInLine("(\\d+)$");
                final MatchResult result = sc.match();
                subjectId = Integer.parseInt(result.group(0)) + 1;
            }

            return getSubjectIdFromId(subjectId);
        }
        catch (Exception e) {
            _log.error(e.getMessage());
            return null;
        }
    }

    private static final Logger _log = LoggerFactory.getLogger(FhirXnatProjectHelper.class);
}
