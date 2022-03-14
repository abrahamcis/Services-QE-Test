package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.models.Ability;
import com.at.models.PokemonInfo;
import com.at.models.Type;
import com.at.utils.ApiTools;
import com.at.utils.BasicSecurityUtil;
import com.at.utils.ObjectTools;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.Objects;

public class Get {
    private BasicSecurityUtil base;
    private String searchName;
    private PokemonInfo pokeInfo;

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
        Assert.assertTrue(ObjectTools.verifyField(pokeInfo, field, expectedValue));
    }

    //Tania steps
    @Given("I have a pokemon name {string}")
   	public void i_have_a_pokemon_name(String searchName) {
        this.searchName = searchName;
   	    System.out.println("looking for "+searchName+" information");
   	}

    @When("I send the GET request with name")
    public void i_send_the_GET_request_with_name() {
        base.response=base.ServiceApi.retrieve(base.ServiceApi.hostName + searchName);
        base.responseBody = base.ServiceApi.response.getBody();
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode,base.ServiceApi.response.getStatusCode().value());
    }

    @And("I save the response in an object")
    public void iSaveTheResponseInAnObject() {
        try {
        Gson gson = new Gson();
        pokeInfo = gson.fromJson(base.responseBody, PokemonInfo.class);
        }catch(Exception e) {
            if(base.ServiceApi.response.getStatusCode().value() == 404){
                System.out.println("Invalid pokemon name");
            }
        }
    }

}
