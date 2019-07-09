package com.saptool.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;


public class Json {

    public static void writeExistingJsonFile(DefaultListModel listModel, String scriptName,String jPath)
    {
        JSONParser parser = new JSONParser();
        String testdata[]=null;
        File file = new File(jPath);
        try {
            Object obj=null;
            JSONObject jsonObject=null;
            if(file.length() != 0) {
                obj = parser.parse(new FileReader(jPath));
                jsonObject = (JSONObject) obj;
            } else{
                jsonObject = new JSONObject();
            }


            for (int i = 0; i <= listModel.size() - 1; i++) {
                testdata= listModel.get(i).toString().split("\\=");
                jsonObject.put(testdata[0], testdata[1]);
            }
//
            writeJson(jsonObject,jPath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void writeJson(JSONObject obj,String jsonFilePath){

        try (FileWriter file = new FileWriter(jsonFilePath)) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

    public static JSONObject parseStringToJsonObject(String filePath) {
        JSONObject jsonObject = null;
        try {
            // read the json file
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static List<String> getKeys(String jsonPath) {
        List<String> listKeyValues = new ArrayList<String>();
        String keyStr;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(jsonPath));

            JSONObject jsonObject = (JSONObject) obj;

            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
               // keyStr=jsonObject.get(key).toString();

                listKeyValues.add(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listKeyValues;
    }
    public static String getValue(String jsonPath,String keyStr) {
        String valStr=null;

        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(jsonPath));

            JSONObject jsonObject = (JSONObject) obj;
            valStr=jsonObject.get(keyStr).toString();

        }catch (Exception e){
            e.printStackTrace();
        }

        return valStr;
    }

    public static DefaultListModel getKeyandValues(String jsonPath){
        DefaultListModel keyandvaluesListmodel= new DefaultListModel();
        keyandvaluesListmodel.removeAllElements();
        String valStr;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(jsonPath));

            JSONObject jsonObject = (JSONObject) obj;

            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                valStr=jsonObject.get(key).toString();

                keyandvaluesListmodel.addElement(key+"="+valStr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return keyandvaluesListmodel;
    }
}