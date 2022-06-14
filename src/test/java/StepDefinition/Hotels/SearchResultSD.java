package StepDefinition.Hotels;

import Helper.Misc;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchResultSD {

    SearchResultSD sr = new SearchResultSD();


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
    Assert.assertTrue(verifyHowWeCanImproveTextIsDisplayed(),"Message is Displayed");
        //        Assert.assertTrue(sr.verifyHowWeCanImproveTextIsDisplayed();
        return true;
    }


    @Then("^I verify share feedback button is displayed$")
    public boolean verifyShareFeedbackIsDidplayed () {
     Assert.assertTrue(verifyShareFeedbackIsDidplayed(),"Message is Displayed");
        // Assert.assertTrue(sr.verifyShareFeedbackIsDidplayed();
        return true;
    }

    }
