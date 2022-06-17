package Pages.Guru.Hotels;

import Helper.Misc;
import Pages.Web.MyDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchResultSD {
    LandingPage lpage = new LandingPage();
    SearchResultSD sr = new SearchResultSD();

    @Given("I am on www.hotels.com")
    public void launchHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
    }
    @When("I click on auto suggestion button ")
    public void destination(){
        sr.typeInDestinationBox("Bora Bora");
    }

    @And("^I type (.+) in destination box$")
    public void typeInDestinationBox (String cityName) {
        sr.typeInDestinationBox("bora".toUpperCase());
        Misc.pause(2);
    }

    @When("^I enter checkin and checkout dates$")
    public void getCheckInAndOutDates () {
      //  sr.clickCheckInTable();
        //sr.selectDateFromAnyMonth("August 2022","1");
        //sr.selectDateFromAnyMonth("August 2022","10");
        //sr.clickDoneBtn();
        //Misc.pause(2);
        //sr.clickOnSearchBtn();

    }

    @Then("^I verify tell us how we can improve our site text is displayed$")
    public boolean verifyHowWeCanImproveTextIsDisplayed () {
Assert.assertTrue(sr.verifyShareFeedbackIsDidplayed());
        return false;
    }


    @Then("^I verify share feedback button is displayed$")
    public boolean verifyShareFeedbackIsDidplayed () {
     Assert.assertTrue(verifyShareFeedbackIsDidplayed(),"Message is Displayed");
        // Assert.assertTrue(sr.verifyShareFeedbackIsDisplayed();
        return true;
    }

    }
