package StepDefinition.Hotels;
import Pages.Hotels.Feedback;
import Pages.Hotels.LandingPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
public class FeedbackSD {

    Feedback fPage = new Feedback();
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
    }

    @When("^I select (.+) star rating$")
    public void selectStarRating(String starValue) {
        fPage.clickOnStarRating(starValue);
    }

    @When("^I enter (.+) in comments field$")
    public void enterTextInCommentsField(String userInput) {
        fPage.enterTextInComments(userInput);
    }

    @When("^I select (.+) as answer in dropdown question$")
    public void chooseDropdownAnswer(String answerToSelect) {
        fPage.selectDropdownQuestion(answerToSelect);
    }

    @When("^I select (.+) as answer in prior booking question$")
    public void selectPriorBookingAnswerBtn(String userAnswer) {
        fPage.selectPriorBookingAnswer(userAnswer);
    }

    @When("^I select (.+) as answer in were you successful question$")
    public void selectWereYouSuccessfulAnswerBtn(String userAnswer) {
        fPage.selectWereYouSuccessfulAnswer(userAnswer);
    }

    @When("^I enter (.+) in email input field$")
    public void enterEmail(String userEmail) {
        fPage.enterUserEmail(userEmail);
    }

    @Then("I verify form is submitted")
    public void verifyFormSubmissionMessage() {
        Assert.assertTrue(fPage.isThankYouMessageDisplayed());
    }
}