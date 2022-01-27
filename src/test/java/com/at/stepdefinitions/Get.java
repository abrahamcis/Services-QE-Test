package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.utils.ApiTools;
import com.at.utils.BasicSecurityUtil;
import com.at.utils.ObjectTools;
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


    @Given("I am targeting {string} service")
    public void i_am_targeting_service(String service) throws Exception{
        base.ServiceApi = new ApiTools(base.environment,service);
    }

    @Given("I want to retrieve all users")
    public void i_want_to_retrieve_all_users() throws Exception{
        base.apiResource= ApiPaths.GET_POKEMON;
    }

    @When("I send a GET request")
    public void i_send_a_GET_request() {
        base.response=base.ServiceApi.retrieve(base.ServiceApi.hostName + base.apiResource);
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
    
    @Given("I have a pokemon name")
   	public void i_have_a_pokemon_name() {
   	  System.out.println("I´m working");
   	}

}
