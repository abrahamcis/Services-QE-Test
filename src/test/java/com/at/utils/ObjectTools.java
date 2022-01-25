package com.at.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ObjectTools {

    public static String getField(String json, String field){
        return JsonPath.parse(json).read(field).toString();
    }

    public static String getField(Object json, String field){
        Gson gson = new Gson();
        return getField(gson.toJson(json), field);
    }

    public static JsonObject deleteField(Object json, String field){
        Gson gson = new Gson();
        String jsonString = gson.toJson(json);
        DocumentContext context = JsonPath.parse(jsonString);
        context.delete(field);
        return new GsonBuilder().create().toJsonTree(context.json()).getAsJsonObject();
    }

    public static JsonObject updateField(Object json, String field, String value){
        Gson gson = new Gson();
        DocumentContext context;
        String jsonString = gson.toJson(json);

        if(value.equals("null")){
            context = JsonPath.parse(jsonString).set(field, null);
        }else {
           context = JsonPath.parse(jsonString).set(field, value);
        }
        return new GsonBuilder().create().toJsonTree(context.json()).getAsJsonObject();
    }

    public static JsonObject addField(Object json, String field, String name, String value){
        Gson gson = new Gson();
        DocumentContext context;
        String jsonString = gson.toJson(json);
        if(value.equals("blank")){
            value = " ";
        }

        context = JsonPath.parse(jsonString).put(field, name, value);
        return new GsonBuilder().create().toJsonTree(context.json()).getAsJsonObject();
    }

    public static boolean verifyField(String jsonString, String field, String expectedValue){
        String actualValue = JsonPath.parse(jsonString).read(field).toString();
        if(expectedValue.equals("blank")){
            expectedValue = " ";
        }
        return actualValue.equalsIgnoreCase(expectedValue);
    }

    public static boolean verifyField(Object json, String field, String value){
        Gson gson = new Gson();
        return verifyField(gson.toJson(json), field, value);
    }
}
