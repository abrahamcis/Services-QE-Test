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
        Gson gson = new Gson();
        pokeInfo = gson.fromJson(base.responseBody, PokemonInfo.class);


       /* try {
        JSONObject info = new JSONObject(Objects.requireNonNull(base.response.getBody()));
        int id = info.getInt("id");
        String name = info.getString("name");
        int base_experience = info.getInt("base_experience");
        int height = info.getInt("height");
        boolean is_default = info.getBoolean("is_default");
        int weight = info.getInt("weight");
        Ability[] abilities = new Ability[info.getJSONArray("abilities").length()];
        for (int i = 0; i < info.getJSONArray("abilities").length(); i++) {
            abilities[i] = new Ability((JSONObject) info.getJSONArray("abilities").getJSONObject(i).get("ability"), (Boolean) info.getJSONArray("abilities").getJSONObject(i).get("is_hidden"), (Integer) info.getJSONArray("abilities").getJSONObject(i).get("slot"));
        }
        Type[] types = new Type[info.getJSONArray("types").length()];
        for (int j = 0; j < info.getJSONArray("types").length(); j++) {
            types[j] = new Type((JSONObject) info.getJSONArray("types").getJSONObject(j).get("type"), (Integer) info.getJSONArray("types").getJSONObject(j).get("slot"));
        }

        PokemonInfo newPokemon = new PokemonInfo(id, name, base_experience, height, is_default, weight, abilities, types);
        System.out.println("Id: " + newPokemon.getId());
        System.out.println("Name: " + newPokemon.getName());
        System.out.println("Base experience: " + newPokemon.getBase_experience());
        System.out.println("Height: " + newPokemon.getHeight());
        System.out.println("Weight: " + newPokemon.getWeight());
        System.out.println("Is default: " + newPokemon.is_default());

        for (int i = 0; i < newPokemon.getAbilities().length; i++) {
            //System.out.println("Ability "+(i+1)+": "+info.getJSONArray("abilities").getJSONObject(i));
            System.out.println("Ability " + (i + 1) + ": " +
                    "abilities: " + newPokemon.getAbilities()[i].getAbility() +
                    ", slot: " + newPokemon.getAbilities()[i].getSlot() +
                    ", is hidden: " + newPokemon.getAbilities()[i].isHidden());
        }

        for (int j = 0; j < newPokemon.getTypes().length; j++) {
            //System.out.println("Type "+(j+1)+": "+info.getJSONArray("types").getJSONObject(j));
            System.out.println("Type " + (j + 1) + ": " +
                    "type: " + newPokemon.getTypes()[j].getType() +
                    ", slot: " + newPokemon.getTypes()[j].getSlot());
        }

        }catch(Exception e) {
            if(base.ServiceApi.response.getStatusCode().value() == 404){
                System.out.println("Invalid pokemon name");
            }
        }*/
    }
}
