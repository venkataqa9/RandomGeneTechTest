package com.codeGen.steps;

import com.codeGen.factory.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class RandomGenSteps {

    @Given("^I navigate to generate random date$")
    public void iNavigateToGenerateRandomDate() {
        Pages.randomGenPage().navigateToGenerateRandomDatePage();
    }

    @And("^I enter count as (\\d+) in how many dates to generate$")
    public void iEnterInHowManyDatesToGenerate(int count) {
        Pages.randomGenPage().enterNumberOfDates(count);
    }

    @When("^I select generate random dates$")
    public void iSelectGenerateRandomDates() {
        Pages.randomGenPage().selectGenerateRandomDates();
    }

    @Then("^I should see dates are generated$")
    public void iShouldSeeDatesAreGenerated() {
        Assert.assertFalse(Pages.randomGenPage().randomDatesAreNotDisplayed());
    }
}
