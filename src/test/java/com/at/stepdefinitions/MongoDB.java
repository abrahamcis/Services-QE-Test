package com.at.stepdefinitions;

import com.at.models.Curriculum;
import com.at.models.Skills;
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
    MongoDBConnection db=null;
    MongoCollection<Document> collectionArray=null;
    Document doc=null;
    private Curriculum mongoCurriculum = Hooks.getCurriculumMongo();
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
    @Given("^I query in the mongoDB an Aleatory document and print it$")
    public void i_query_in_the_mongoDB_an_Aleatory_document_and_print_it() throws Throwable {
        db = new MongoDBConnection("envi","db");
        collectionArray = db.getCollectionFromDataBase("Curriculum");
        doc = db.getARandomDocument(collectionArray);
        String resourceId=(String)doc.get("_id");
        System.out.println(resourceId);
        db.close();

    }

    @Given("^I want to retrieve a user with the mongoDB document$")
    public void i_want_to_retrieve_a_user_with_the_mongoDB_document() throws Throwable {

        Curriculum mongoCurriculum  = db.convertDocumentToACurriculum(doc);
        Hooks.setCurriculumMongo(mongoCurriculum);
        System.out.println(mongoCurriculum);

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
        Skills databaseValue = (Skills) doc.get(field);
        System.out.println(databaseValue.getName());
        Assert.assertEquals(databaseValue,value);
        db.close();
    }

}
