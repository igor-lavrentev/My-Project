package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;


public class Task3 {
    public static void main(String[] args) throws IOException, ParseException {

        String values = args[0];

        String tests = args[1];

        String report = args[2];

        JSONParser parser = new JSONParser();
        JSONObject valuesJson = new JSONObject();
        JSONObject testsJson = new JSONObject();

        try {
            valuesJson = (JSONObject) parser.parse(new FileReader(values));
            testsJson = (JSONObject) parser.parse(new FileReader(tests));

        } catch (IOException e) {
            System.out.println(e);
        }
        sorted(valuesJson, testsJson, report);
    }

    private static void sorted(JSONObject valuesJson, JSONObject testsJson, String report) throws IOException, ParseException {

        HashMap<Long,String> newRep = new HashMap<>();
        JSONArray valuesArray = (JSONArray) valuesJson.get("values");

        for (Object valueObj : valuesArray){
            JSONObject value = (JSONObject) valueObj;
            newRep.put((Long) value.get("id"),(String) value.get("value"));
        }

        JSONObject reportData;
        try (FileWriter file = new FileWriter(report)) {
            file.write(testsJson.toJSONString());
        } catch (IOException e) {
        }

        JSONParser parser = new JSONParser();
        reportData = (JSONObject) parser.parse(new FileReader(report));

        reportData.replace("tests", arrayParser(reportData.get("tests"), newRep));

        try (FileWriter file = new FileWriter(report)) {
            file.write(reportData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray arrayParser(Object values, HashMap<Long,String> newRep) {

        JSONArray arr = (JSONArray) values;

        for (int i = 0; i < arr.size(); i++) {
            JSONObject test = (JSONObject) arr.get(i);

            if (test.containsKey("values")) {
                test.replace("values", arrayParser(test.get("values"), newRep));
            }

            if (test.containsKey("value") && test.containsKey("id") && newRep.containsKey(test.get("id"))){
                test.replace("value", newRep.get(test.get("id")));
            }
        }
        return arr;
    }
}