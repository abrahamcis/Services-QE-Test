package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.controller.DataFactory;
import com.at.models.*;
import com.at.utils.*;
import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Post {
    private BasicSecurityUtil base= Hooks.getBase();
    /*public Post(BasicSecurityUtil base){
        this.base=base;
    }*/

    @Given("I want to Post a new client")
    public void i_want_to_Post_a_new_client() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(base);
        base.apiResource= ApiPaths.postUserRoute;
        System.out.println(base.ServiceApi.hostName + base.apiResource);
    }
    @Given("I set up Curriculum to blank")
    public void i_set_up_Curriculum_to_blank() {
        DataFactory.createCurriculumBlank();
    }
    @When("I send the Post request")
    public void i_send_the_Post_request() {
        Curriculum curriculum = DataFactory.createCompleteCurriculum();
        System.out.println(base.ServiceApi.hostName+base.apiResource);
        base.response=base.ServiceApi.POSTMethod(base.ServiceApi.hostName ,base.apiResource,curriculum);
    }

    @When("I recieve the Json response")
    public void i_recieve_the_Json_response() {
        String responseBody = base.ServiceApi.response.getBody();
        // convert String to an Json object
        // convert String to a GSON builder - googleAPI- java objects
        Gson response_get = new Gson();
        //.class are use to pass classes as variable
        System.out.println(base.ServiceApi.response.getBody());
        Curriculum curriculum = response_get.fromJson(responseBody, Curriculum.class);
    }
    @When("I send the invalid Post request")
    public void i_send_the_invalid_Post_request() {
        Curriculum curriculum = DataFactory.createIncompleteCurriculum();
        System.out.println(base.ServiceApi.hostName+base.apiResource);
        base.response=base.ServiceApi.POSTMethod(base.ServiceApi.hostName ,base.apiResource,curriculum);
    }
    @When("I get a invalid Json response")
    public void i_get_a_invalid_Json_response() {
        String responseBody = base.ServiceApi.response.getBody();
        System.out.println(base.ServiceApi.response.getBody());
    }
    @When("^I set up user personal info firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" phone number \"([^\"]*)\" country \"([^\"]*)\" city \"([^\"]*)\"$")
    public void i_set_up_user_personal_info_firstName_lastName_email_phone_number(String firstName, String lastName, String email, String phoneNumber, String country, String city) {
        DataFactory.setPersonalData(firstName,lastName,email,phoneNumber,country, city);
    }

    @When("I set up user skills")
    public void i_set_up_user_skills() {
        DataFactory.setSkills();
    }

    @When("^I set up user languages Language \"([^\"]*)\" with a level \"([^\"]*)\"$")
    public void i_set_up_user_languages_Language_with_a_level(String language, String level) {
        DataFactory.setLanguages(language,level);
    }

    @When("I set up user Work Experience")
    public void i_set_up_user_Work_Experience() {
        DataFactory.setWorkExperience();
    }

    @When("^I set up user Education With Bachelor \"([^\"]*)\" to \"([^\"]*)\" forever \"([^\"]*)\" from \"([^\"]*)\"$")
    public void i_set_up_user_Education_With_Bachelor_to_forever_from(String bachelor, String to, String forever, String from) {
        DataFactory.setEducation(bachelor,to,forever,from);
    }

    @When("^I set up user Challenges date start \"([^\"]*)\" description \"([^\"]*)\" name \"([^\"]*)\" url \"([^\"]*)\"$")
    public void i_set_up_user_Challenges_date_start_description_name_url(String date, String description, String name, String url) {
        DataFactory.setChallenge(date,description,name,url);
    }

    @When("^I set up user Config color \"([^\"]*)\" font family \"([^\"]*)\" generic font \"([^\"]*)\"$")
    public void i_set_up_user_Config_color_font_family_generic_font(String color, String fontFamily, String genericFont) {
        DataFactory.setConfig(color,fontFamily,genericFont);
    }

    @When("^I set up user Social Media facebook \"([^\"]*)\" instagram \"([^\"]*)\" linkedin \"([^\"]*)\" pinterest \"([^\"]*)\" snapchat \"([^\"]*)\" twitter \"([^\"]*)\"$")
    public void i_set_up_user_Social_Media_facebook_instagram_linkedin_pinterest_snapchat_twitter(String facebook, String instagram, String linkedin, String pinterest, String snapchat, String twitter) {
        DataFactory.setSocialMedia(facebook,instagram,linkedin,pinterest,snapchat,twitter);
    }

    @When("I send the Curriculum in a POST request")
    public void i_send_the_Curriculum_in_a_POST_request() {
        Curriculum curriculum = DataFactory.getCurriculumPersonalized();
        System.out.println(base.ServiceApi.hostName+base.apiResource);
        base.response=base.ServiceApi.POSTMethod(base.ServiceApi.hostName ,base.apiResource,curriculum);
    }
    @Then("^I validate Json response and missing field should be displaying in response \"([^\"]*)\"$")
    public void i_validate_Json_response_and_missing_field_should_be_displaying_in_response(String field) {
        String completeText = base.ServiceApi.response.getBody();
        String subString = field;
        boolean condition = true;
        boolean containString=completeText.contains(subString);
        Assert.assertEquals(condition,containString);
    }
}
