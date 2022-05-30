package StepDefinition;

import Pages.Guru.LandingPage;
import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class OthersSD {
    LandingPage lPage = new LandingPage();

    @Given("^I am on Guru landing page$")
    public void openGugu() {
        MyDriver.launchUrlOnNewWindow("https://demo.guru99.com/test/delete_customer.php/delete_customer.php/");
    }

    @When("I enter the customer id as (.+)")
    public void enterCustomerId(String idValue) {
        lPage.enterCustomerId(idValue);
    }

    @When("I click on Submit button")
    public void clickSubmit() {
        lPage.clickSubmitBtn();
    }

    @Then("I verify '(.+)' is displayed")
    public void verifyCustomerDeleted(String msg) {
        lPage.clickOkOnAlert();
        Assert.assertEquals(lPage.getAlertText(), msg, "Error");

    }


}