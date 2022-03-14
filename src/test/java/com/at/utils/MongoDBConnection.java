package com.at.utils;



import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class MongoDBConnection {

    private static MongoClient mClient;
    private static MongoDatabase mDataBase;

    public MongoDBConnection(String env, String db) {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            System.out.println("Debugin env:"+env);
            String uriString = prop.getProperty(env + "." + db);
            // this connects to the database using a inner method to connect to service https:local,etc
            System.out.println(uriString);
            mClient = MongoClients.create("mongodb+srv://ATAdmin:administrator@cluster0.8ifkg.mongodb.net/test");
            System.out.println("Debugging db"+db);
            mDataBase = getDB("AT");
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to make connection!");
        }
    }

    private MongoDatabase getDB(String db) {
        return mClient.getDatabase(db);
    }

    public void close() {
        try {
            if (mClient != null) {
                mClient.close();
                mClient = null;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean compareID(String collection, String id) {
        boolean exist = false;
        MongoCollection<Document> coll = mDataBase.getCollection(collection);
        FindIterable<Document> findIterable = coll.find(Filters.eq("_id", new ObjectId(id)));
        try {
            for (Document doc : findIterable) {
                JSONObject mObject = new JSONObject(doc.toJson());
                String mongoID = mObject.getJSONObject("_id").get("$oid").toString();
                exist = mongoID.equals(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            exist = false;
        }
        return exist;
    }

    public String getObjectByID(String collection, String id) {
        String mObject = "";
        MongoCollection<Document> coll = mDataBase.getCollection(collection);
        FindIterable<Document> findIterable = coll.find(Filters.eq("_id", new ObjectId(id)));
        try {
            for (Document doc : findIterable) {
                JSONObject monObject = new JSONObject(doc.toJson());
                mObject = monObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mObject;
    }

    public String foundRandomID(String collection) {
        String id = "";
        MongoCollection<Document> coll = mDataBase.getCollection(collection);
        FindIterable<Document> findIterable = coll.find();
        try {
            JSONArray jResult = new JSONArray();
            JSONObject mObject = new JSONObject();
            for (Document doc : findIterable) {
                jResult.put(mObject = new JSONObject(doc.toJson()));
            }
            int jArrayLength = jResult.length() - 1;
            mObject = jResult.getJSONObject((int) (Math.random() * (jArrayLength - 0 + 1) + 0));
            id = mObject.getJSONObject("_id").get("$oid").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean compareJsonString(String collection, String object) {
        boolean bool = false;
        String data = "", category = "", title = "", description = "", img="";
        String status = "";

        MongoCollection<Document> coll = mDataBase.getCollection(collection);
        FindIterable<Document> findIterable = coll.find();

        for (Document document : findIterable) {
            JSONObject mongo = new JSONObject(document.toJson());
            String id = mongo.getJSONObject("_id").get("$oid").toString();
            String[] categoryList = { "JAVA", "PEGA", "JS" };
            if (mongo.has("category")) {
                category = categoryList[parseInt(mongo.get("category").toString()) - 1];
            }
            if (mongo.has("title")) {
                title = mongo.getString("title");
            }
            if (mongo.has("description")) {
                description = mongo.getString("description");
            }
            if (mongo.has("img")) {
                description = mongo.getString("img");
            }
            if (mongo.has("status")) {
                status = mongo.get("status").toString();
            } else {
                status = "";
            }

            data = data + id + category + title + description + img + status;
        }
        bool = compareAll(data, data);

        return bool;

    }
    public boolean compareAll(String mongoJson, String object) {
        boolean bool = false;
        if (mongoJson.equals(object)) {
            bool = true;
        }
        return bool;
    }
    public MongoCollection<Document> getCollectionFromDataBase(String collection){
        return mDataBase.getCollection(collection);
    }
    public Document getDocumentByKeyValue(MongoCollection<Document> collection, String key, String value){
        return collection.find(Filters.eq(key,value)).first();
    }
    public Object getElementByKeyFromDocument(Document document, String key){
        return document.get(key);
    }
}
