package com.at.constants;

public class ApiPaths {
    public static final String SCE_GET_USERS="/person/157a6b59-f89a-4a7e-8250-b8f25b75ffec";
    public static String getUserByResourceID="/person/";
    public static String postUserRoute="/person";

    public static void setUser_id(String user_id){
        getUserByResourceID="/person/";
        getUserByResourceID=getUserByResourceID+user_id;
    }
}
