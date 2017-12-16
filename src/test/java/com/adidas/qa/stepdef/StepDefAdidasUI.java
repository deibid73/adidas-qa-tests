package com.adidas.qa.stepdef;


import com.adidas.qa.model.AdidasPageObjectModel;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;


public class StepDefAdidasUI extends StepDefBase {

    AdidasPageObjectModel model;

    @Given("^I open the adidas home page$")
    public void iOpenTheAdidasHomePage() throws Throwable {
        model = new AdidasPageObjectModel();
        assertThat("Verify the page is successfully displayed ", model.title, Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Given("^I select the (.*) locale$")
    public void iSelectTheLocale(String language) throws Throwable {

        model.selectLanguageLocator(language);


    }

    @When("^I select the (.*) link")
    public void selectMenLinkByText(String which) throws Throwable {
        switch (which) {
            case "Men":
                model.clickMenLocator();
                break;
            case "Women":
                model.clickWomenLocator();
                break;
            case "Kids":
                model.clickKidsLocator();
                break;
            case "Customise":
                model.clickCustomiseLocator();
                break;
        }

    }

    @After
    public void closePage() {

       if(model!=null) model.quit();
    }

    @Then("^the (.*) home page is loaded$")
    public void theHomePageIsLoaded(String page) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat("We are redirected to /"+page,model.getLocation(),Matchers.containsString("/"+page));
    }


}
