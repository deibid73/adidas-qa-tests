package com.adidas.qa.stepdef;

import com.adidas.qa.http.HttpClient;
import com.adidas.qa.model.AdidasAPIModel;
import com.github.kevinsawicki.http.HttpRequest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dmontero
 */
public class StepDefAdidasAPI extends StepDefBase {

    JSONArray components;
    AdidasAPIModel model;

    @Given("^I get the API response under 1 sec$")
    public void iGetTheAPIResponse() throws Throwable {
        model = new AdidasAPIModel();
        model.getAdidasAPIModel();
        assert model.api != null;
    }

    @When("^I get all the components list$")
    public void iGetAllTheComponentsList() throws Throwable {
        components = model.api.getJSONArray("component_presentations");

    }

    @Then("^all the components have analytics_name in them$")
    public void allTheComponentsHaveAnalytics_nameInThem() throws Throwable {
        for (int i = 0; i < components.length(); i++) {
            JSONObject component = components.getJSONObject(i);
            assertThat("The component has analytics data", component.toString(), Matchers.containsString("analytics_name"));
        }
    }

    @Then("^all the images load$")
    public void allTheImagesLoad() throws Throwable {

        HttpRequest request;
        HttpClient client=new HttpClient();
        ArrayList<String> urls=model.getListOfUrls(components);
        for(String url:urls){
            request=client.httpGet(url,"image/jpeg");
            assertThat ("The image loads correctly",request.code(), Matchers.is(200));
        }
    }
}
