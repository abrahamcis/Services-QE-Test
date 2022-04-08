package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.controller.DataFactory;
import com.at.models.Curriculum;
import com.at.utils.BasicSecurityUtil;
import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;
import org.junit.Assert;

public class PUT {
    private BasicSecurityUtil base= Hooks.getBase();
    private Curriculum mongoCurriculum = Hooks.getCurriculumMongo();
    private Curriculum prevmongoCurriculum=null;
    @Given("^I create a new user and return his resourceID$")
    public void i_create_a_new_user_and_return_his_resourceID() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        base.apiResource= ApiPaths.postUserRoute;
        DataFactory.createCurriculumBlank();
        Curriculum curriculum = DataFactory.createCompleteCurriculum();
        System.out.println("Services route: "+base.ServiceApi.hostName+base.apiResource);
        base.response=base.ServiceApi.POSTMethod(base.ServiceApi.hostName ,base.apiResource,curriculum);
    }

    @Given("^I want to Update user by his ResourceID$")
    public void i_want_to_Update_user_by_his_ResourceID() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        prevmongoCurriculum= Hooks.getCurriculumMongo();
        if(base.ServiceApi==null){
            String responseBody = base.ServiceApi.response.getBody();
            Gson response_put = new Gson();
            Curriculum curriculum = response_put.fromJson(responseBody,Curriculum.class);
            ApiPaths.setUser_id("");
            ApiPaths.setUser_id(curriculum.getResourceId());
            base.apiResource= ApiPaths.getUserByResourceID;
        }
        ApiPaths.setUser_id("");
        ApiPaths.setUser_id(prevmongoCurriculum.getResourceId());
        base.apiResource= ApiPaths.getUserByResourceID;

    }
    @When("^I send a PUT request$")
    public void i_send_a_PUT_request() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(base.ServiceApi.hostName+base.apiResource);
        System.out.println(DataFactory.getCurriculumPersonalized());
        base.response=base.ServiceApi.PUTMethod(base.ServiceApi.hostName+base.apiResource,DataFactory.getCurriculumPersonalized());
    }
   @Then("^I compare last data in database with the new one$")
    public void i_compare_both_json_response_and_expect_to_be_similar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       mongoCurriculum = Hooks.getCurriculumMongo();
       System.out.println("Request info :"+ DataFactory.getCurriculumPersonalized());
        System.out.println("Response body  Assert: "+prevmongoCurriculum);
        Assert.assertEquals(true,prevmongoCurriculum.equals(DataFactory.getCurriculumPersonalized()));
    }
}
