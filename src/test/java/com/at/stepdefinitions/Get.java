package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.models.Curriculum;
import com.at.utils.ApiTools;
import com.at.utils.BasicSecurityUtil;
import com.at.utils.ObjectTools;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Get {
    private BasicSecurityUtil base;

    public Get(BasicSecurityUtil base){

        this.base=base;
    }

    @Given("I am working on {string} environment")
    public void i_am_working_on_environment(String env) throws Exception{
        base.environment=env;
    }
    //rest Asurured

    @Given("I am targeting {string} service")
    public void i_am_targeting_service(String service) throws Exception{
        base.ServiceApi = new ApiTools(base.environment,service);
    }

    @Given("I want to retrieve all users")
    public void i_want_to_retrieve_all_users() throws Exception{
        base.apiResource= ApiPaths.SCE_GET_USERS;
    }

    @When("I send a GET request")
    public void i_send_a_GET_request() {
        System.out.println(base.ServiceApi.hostName + base.apiResource);
        base.response=base.ServiceApi.retrieve(base.ServiceApi.hostName + base.apiResource);
    }

    @Given("I want to retrieve a user by his resourceID {string}")
    public void i_want_to_retrieve_all_users(String resourceID) throws Exception{
        ApiPaths.setUser_id(resourceID);
        base.apiResource= ApiPaths.getUserByResourceID;
    }

    @Then("I get response for GET request")
    public void i_get_response_for_GET_request() {
        String responseBody = base.ServiceApi.response.getBody();
        // convert String to an Json object
        // convert String to a GSON builder - googleAPI- java objects
        Gson response_get = new Gson();
        //.class are use to pass classes as variable
        System.out.println(base.ServiceApi.response.getBody());
        Curriculum curriculum = response_get.fromJson(responseBody, Curriculum.class);

        System.out.println(curriculum);
    }
    @Then("the status code should be {string}")
    public void the_status_code_should_be(String statusCode) {
        int status= Integer.parseInt(statusCode);
        Assert.assertEquals(status,base.ServiceApi.response.getStatusCode().value());
    }

    @Then("information retrieved from service should match with DB")
    public void information_retrieved_from_service_should_match_with_DB() {
        //Add validations to DB
        throw new io.cucumber.java.PendingException();
    }

    @And("I set {string} as {string} value on the request")
    public void iSetAsValueOnTheRequest(String field, String value) {
        //ObjectTools.updateField(Object, field, value);
    }

    @And("I delete the field {string}")
    public void iDeleteTheField(String field) {
        //ObjectTools.deleteField(Object, field);
    }


    @And("Verify field {string} as {string} in response")
    public void verifyFieldAsInResponse(String field, String expectedValue) {
        //Assert.assertTrue(ObjectTools.verifyField(Object, field, expectedValue));
    }
}
