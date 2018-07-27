package de.htwberlin.cbmi.fhir.test;

import de.htwberlin.cbmi.fhir.service.FhirIdentityService;
import de.htwberlin.cbmi.fhir.utils.Datatypes;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class DatatypesTest {

    @Test
    public void testValidation() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("value", "pat001");
        List<String> keys = Datatypes.makeList("use", "type", "system", "value", "period.start", "period.end", "assigner");
        List<Class<?>> types = Datatypes.makeList(String.class, String.class, String.class, String.class, FhirIdentityService.class, Date.class, Integer.class);

        assertNull(Datatypes.validateMap(values, keys, types));
        values.put("type", "pat001");
        values.put("assigner", "pat001");
        assertEquals(Datatypes.validateMap(values, keys, types), "assigner");

        // Test subarray
        HashMap<String, Date> d1 = new HashMap<>();
        d1.put("start", new Date());
        values.put("period", d1);
        values.put("assigner", 12);
        assertNull(Datatypes.validateMap(values, keys, types));

        // Test subarray list
        HashMap<String, Date> d2 = new HashMap<>();
        d2.put("start", new Date());
        values.put("period", Datatypes.makeList(d1, d2));
        assertNull(Datatypes.validateMap(values, keys, types));

        // Test subarray fault
        HashMap<String, String> d3 = new HashMap<>();
        d3.put("end", "Huhu");
        values.put("period", Datatypes.makeList(d1, d2, d3));
        assertEquals(Datatypes.validateMap(values, keys, types), "period.end");
    }

    @Test
    public void testKeys() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("value", "pat001");
        values.put("use", "pat001");

        HashMap<String, Object> period = new HashMap<>();
        period.put("start", "pat001");
        period.put("end", "pat001");
        values.put("period", period);

        List<String> required = Datatypes.makeList("use");
        List<String> allowed = Datatypes.makeList("use", "type", "system", "value", "period.start", "period.end", "assigner");
        assertNull(Datatypes.validateKeys(values, required, null));
        assertNull(Datatypes.validateKeys(values, null, allowed));
    }

    @Test
    public void testPatientValidation() {
        String directory = System.getProperty("user.dir") + "/src/test/resources/json/";
        File f = new File(directory + "Patient1_isa");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            Map<String, Object> result = Datatypes.readJsonString(reader);
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }
}