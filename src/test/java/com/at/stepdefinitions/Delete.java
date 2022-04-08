package com.at.stepdefinitions;

import com.at.models.Curriculum;
import com.at.utils.BasicSecurityUtil;
import cucumber.api.java.en.When;

public class Delete {
    private BasicSecurityUtil base= Hooks.getBase();
    private Curriculum mongoCurriculum = Hooks.getCurriculumMongo();
    @When("^I send Delete request$")
    public void i_send_Delete_request() throws Throwable {
        System.out.println(base.apiResource);
        base.ServiceApi.retrieveDelete(base.ServiceApi.hostName,base.apiResource);

    }
}
