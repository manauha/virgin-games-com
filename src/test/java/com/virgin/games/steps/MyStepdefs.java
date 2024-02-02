package com.virgin.games.steps;

import com.virgin.games.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs {
    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
    }

    @And("I navigate to given url")
    public void iNavigateToGivenUrl() {
    }

    @Then("I verify that home page is visible successfully")
    public void iVerifyThatHomePageIsVisibleSuccessfully() {
        new HomePage().verifyHomepage();

    }

    @And("I verify {string} is visible")
    public void iVerifyIsVisible(String welcome) {
        Assert.assertEquals(new HomePage().verifyWelcomeTextIsVisible(), welcome, "Error");
    }

    @And ("I click on Allow All cookies")
    public void iClickOnAllowAllCookies() {
        new HomePage().clickOnAllowAllCookies();
    }


    @When("I am on the homepage")
    public void iAmOnTheHomepage() {
    }

    @And("I click on the {string} on TopMenu")
    public void iClickOnTheOnTopMenu(String tab) {
        new HomePage().clickOnTheOnTopMenu(tab);
    }

    @Then("I navigated to the clicked {string} successfully")
    public void iNavigatedToTheClickedSuccessfully(String tabPage) {
        new HomePage().navigatedToTheClickedSuccessfully(tabPage);
    }


    @And("I go down to legal lines")
    public void iGoDownToLegalLines() {
        new HomePage().goDownToLegalLines();

    }

    @Then("I click on Modern Slavery Statement")
    public void iClickOnModernSlaveryStatement() {
        new HomePage().clickOnModernSlaveryStatement();
    }


    @And("I navigate to {string} Page Successfully")
    public void iNavigateToPageSuccessfully(String act) {
        Assert.assertEquals(new HomePage().navigateToPageSuccessfully(), act, "Error - Statement ");
    }

    @And("I verify page URL")
    public void iVerifyPageURL() {
        new HomePage().verifyPageTheURL();
    }
}