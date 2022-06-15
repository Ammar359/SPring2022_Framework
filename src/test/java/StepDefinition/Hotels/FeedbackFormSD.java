package StepDefinition.Hotels;


import Pages.Hotels.FeedbackPage;
import Pages.Hotels.LandingPage;
import Pages.Web.MyDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class FeedbackFormSD {

    FeedbackPage fPage = new FeedbackPage();
    LandingPage lPage = new LandingPage();

    @When("I click on feedback link")
    public void clickFeedbackLink() {
        lPage.clickFeedbackPage();
    }

    @When("I click on feedback submit button")
    public void submitFeedbackForm() {
        fPage.clickFormSubmitBtn();
    }

    @Then("I verify empty form submission error is displayed")
    public void verifyFormSubmissionError() {
        Assert.assertTrue(fPage.isEmptyFormSubmissionErrorDisplayed(), "Test Failed - Error is not displayed");
    }

    @Then("I verify red dotted border around star rating section")
    public void verifyRedDottedBorderAroundRating() {
        Assert.assertTrue(fPage.isRedDottedBorderDisplayed(),"Test Failed - Red dotted border is not displayed");
        MyDriver.getDriver().quit();
    }
}