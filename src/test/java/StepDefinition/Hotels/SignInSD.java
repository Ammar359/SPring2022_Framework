package StepDefinition.Hotels;

import Pages.Facebook.SignUpPage;
import Pages.Hotels.LandingPage;
import Pages.Hotels.SignInPage;
import Pages.Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

public class SignInSD {

       @Given("^I am on Hotels Landing page$")
       public void launchHotels(){
            MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        }
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

        @When("I enter email in sign in form")
        public void enterSignInEmail() {
            signInObj.enterSignInEmail();
        }

        @When("I enter password in sign in form")
        public void enterSignInPassword() {
            signInObj.enterSignInPassword();
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
            Assert.assertTrue(signInObj.verifySignInErrorMessage());
        }
    }
