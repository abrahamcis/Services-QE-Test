package com.at.stepdefinitions;

import com.at.globalclasses.ApiPaths;
import com.at.globalclasses.ApiTools;
import com.at.globalclasses.BasicSecurityUtil;
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
        base.apiResource= ApiPaths.SCE_GET_USERS;
    }

    @When("I send a GET request")
    public void i_send_a_GET_request() {
        base.response=base.ServiceApi.retrieve(base.ServiceApi.hostName+base.apiResource);
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

}
