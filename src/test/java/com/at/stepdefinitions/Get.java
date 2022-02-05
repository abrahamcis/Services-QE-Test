package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.model.PokeInfo;
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
    private PokeInfo pokeInfo;

    public Get(BasicSecurityUtil base){
        this.base=base;
    }

    @Given("I am working on {string} environment")
    public void i_am_working_on_environment(String env) throws Exception{
        base.environment=env;
    }


    @Given("I am targeting {string} service")
    public void i_am_targeting_service(String service) throws Exception{
        base.ServiceApi = new ApiTools(base.environment,service);
    }

    @Given("I want to retrieve all users")
    public void i_want_to_retrieve_all_users() throws Exception{
        base.apiResource= ApiPaths.SCE_GET_USERS;
    }

    @Given("I want to retrieve {string} information")
    public void i_want_to_retrieve_poke(String pokeName) throws Exception{
        base.apiResource= ApiPaths.GET_POKE + pokeName;
    }

    @When("I send a GET request")
    public void i_send_a_GET_request() {
        base.response=base.ServiceApi.retrieve(base.ServiceApi.hostName + base.apiResource);
        base.responseBody = base.response.getBody();
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

    @And("I build the response object")
    public void iBuildTheResponseObject() {
        Gson gson = new Gson();
        pokeInfo = gson.fromJson(base.responseBody, PokeInfo.class);
    }
}
