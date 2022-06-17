package StepDefinition.Hotels;
import Pages.Hotels.LandingPage;
import Pages.Hotels.SignInPage;
import Pages.Hotels.SignUpPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
public class SignInSD {

    LandingPage obj = new LandingPage();
    SignUpPage signUpObj = new SignUpPage();
    SignInPage signInObj = new SignInPage();
    @When("I click on sign in field")
    public void clickSignInField() {
        obj.clickSignInField();
    }
    @When("I click on sign in button")
    public void clickSignInBtn() {
        obj.clickSignInBtn();
    }

    @When("^I enter email (.+) in sign in form$")
    public void enterSignInEmail(String userInput) {
        signInObj.enterSignInEmail(userInput);
    }

    @When("^I enter password (.+) in sign in form$")
    public void enterSignInPassword(String userInput) {
        signInObj.enterSignInPassword(userInput);
    }

    @When("I check sign in checkbox")
    public void clickSignInCheckbox() {
        signInObj.clickSignInCheckbox();
    }
    @When("I click sign in button")
    public void clickLogIn() {
        signInObj.clickSignInBtn();
    }
    @Then("I verify sign in error is displayed")
    public void verifySignInError() {
        Assert.assertTrue(signInObj.verifySignInError());
    }
    @When("I click on sign up button")
    public void clickSignUpBtn() {
        obj.clickSignUpBtn();
    }
}