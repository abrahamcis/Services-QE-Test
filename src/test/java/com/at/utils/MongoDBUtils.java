package com.at.utils;

import com.at.utils.MongoDBConnection;

public class MongoDBUtils {
    public static boolean existID(String env, String mDataBase, String collection, String id) {
        MongoDBConnection db = new MongoDBConnection(env, mDataBase);
        boolean exist = db.compareID(collection, id);
        db.close();
        return exist;
    }

    public static String getJObjectByID(String env, String mDataBase, String collection, String id) {
        MongoDBConnection db = new MongoDBConnection(env, mDataBase);
        String monObj = db.getObjectByID(collection, id);
        db.close();
        return monObj;
    }

    public static String getJObjectByFirstName(String env, String mDataBase, String collection, String name) {
        MongoDBConnection db = new MongoDBConnection(env, mDataBase);
        String monObj = db.getObjectByFirstName(collection, name);
        db.close();
        return monObj;
    }

    public static String getRandomID(String env, String mDataBase, String collection) {
        MongoDBConnection db = new MongoDBConnection(env, mDataBase);
        String id = db.foundRandomID(collection);
        db.close();
        return id;
    }

    public static boolean compareJsonString(String env, String mDataBase, String collection, String json) {
        MongoDBConnection db = new MongoDBConnection(env, mDataBase);
        boolean bool;
        try {
            bool = db.compareJsonString(collection, json);
        } catch(Exception var9) {
            var9.printStackTrace();
            bool = false;
        } finally {
            db.close();
        }
        return bool;
    }

}
