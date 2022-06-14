package StepDefinition.Darksky;

import Pages.Darksky.LandingPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchSD {
    LandingPage lpage = new LandingPage();

//    @Given("I am on darksky landing page")
//    public void openDarksky() {
//        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
//    }


    @When("I search temperature using (.+)")
    public void searchTempFor(String searchFor) {
        lpage.enterSearchLocation(searchFor);
        lpage.clickSearchButton();
    }


    @Then("I verify forecast is displayed for (.+)")
    public void isForecastDisplayed(String searchedFor) {
        Assert.assertTrue(lpage.isForecastDisplayed(), "Forecast is not displayed for " + searchedFor);
    }




}