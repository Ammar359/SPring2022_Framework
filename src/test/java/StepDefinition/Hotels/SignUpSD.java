package StepDefinition.Hotels;

import Pages.Hotels.SignUpPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
public class SignUpSD {

    SignUpPage sup = new SignUpPage();

    @When("^I enter email (.+) in sign up form$")
    public void enterSignUpEmail(String userInput) {
        sup.enterEmail(userInput);
    }

    @When("^I enter first name (.+) in sign up form$")
    public void enterSignUpFirstName(String userInput) {
        sup.enterFirstName(userInput);
    }

    @When("^I enter last name (.+) in sign up form$")
    public void enterSignUpLastName(String userInput) {
        sup.enterLastName(userInput);
    }

    @When("^I enter password (.+) in sign up form$")
    public void enterSignUpPassword(String userInput) {
        sup.enterPassword(userInput);
    }

    @Then("^I verify (.+) sign up error is displayed$")
    public void verifyFirstNameErrorMessage(String userInput) {
        Assert.assertTrue(sup.signUpErrors(userInput),"Test Fail - Error was not displayed");
    }

    @Then("I verify that sign up checkbox is enabled and displayed")
    public void verifySignUpCheckbox() {
        Assert.assertTrue(sup.isSignUpCheckboxEnabled(),"Test Fail - Checkbox is not enabled");
        Assert.assertTrue(sup.isSignUpCheckboxDisplayed(),"Test Fail - Checkbox is not displayed");
    }

    @Then("I verify that continue button is displayed and not enabled")
    public void verifyContinueButton() {
        Assert.assertFalse(sup.isContinueBtnEnabled(),"Test Fail - Continue button was enabled");
        Assert.assertTrue(sup.isContinueBtnDisplayed(),"Test Fail - Continue button was not displayed");
    }

    @When("I click on privacy page link")
    public void clickPrivacyPageLink() {
        sup.clickPrivacyPageLink();
    }
    @Then("I verify that link opened privacy page")
    public void verifyPrivacyPage() {
        Assert.assertEquals(sup.getPrivacyPageHeading(),"Privacy Statement","Test Failed - Heading does not match");
    }
    @When("I close privacy page")
    public void closePrivacyPage() {
        sup.closePrivacyPage();
    }

    @When("I click on terms and conditions page link")
    public void clickTermsConditionsLink() {
        sup.clickTermsConditionsLink();
    }
    @When("I verify that it is a correct page")
    public void verifyTermsConditionsPage() {
        Assert.assertEquals(sup.getTermsConditionsPageHeading(),"Terms and Conditions");
    }
}