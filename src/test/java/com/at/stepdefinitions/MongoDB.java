package com.at.stepdefinitions;

import com.at.utils.MongoDBConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.bson.Document;
import org.junit.Assert;

public class MongoDB {
    MongoDBConnection db;
    MongoCollection<Document> collectionArray;
    Document doc;
    @Given("^I set up environment \"([^\"]*)\" and database name \"([^\"]*)\"$")
    public void i_set_up_environment_and_database_name(String env, String dataBase) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        db = new MongoDBConnection(env,dataBase);
    }

    @Given("^I set up collection name \"([^\"]*)\"$")
    public void i_set_up_collection_name(String collection) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      collectionArray = db.getCollectionFromDataBase(collection);
        System.out.println(collectionArray.toString());
    }

    @When("^I query by field \"([^\"]*)\" and value \"([^\"]*)\"$")
    public void i_query_by_field_and_value(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        doc= db.getDocumentByKeyValue(collectionArray,field,value);
        System.out.println("Docuemnt: "+doc);
    }

    @Then("^I expect the field \"([^\"]*)\" has the value \"([^\"]*)\"$")
    public void i_expect_the_field_has_the_value(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String databaseValue = (String)doc.get(field);
        System.out.println(databaseValue);
        Assert.assertEquals(databaseValue,value);
    }

}
