package StepDefinition.Hotels;
import Pages.Hotels.LandingPage;
import Pages.Hotels.SignInPage;
import Pages.Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

public class SignInSD {


    LandingPage lpage = new LandingPage();
    SignInPage spage = new SignInPage();

    @Given("^I launch Landing page$")
    public void launchHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }

    @When("I click on sign in field")
    public void clickSignInField() {
        lpage.clickSignInField();
    }

    @When("I click on sign in button")
    public void clickSignInBtn() {
        lpage.clickSignInBtn();
    }

    @When("^I enter invalid email address (.+)$")
    public void enterSignInEmail() {
        spage.enterSignInEmail();

    }

    @When("I enter password in sign in form")
    public void enterSignInPassword() {
        spage.enterSignInPassword();
    }

    @When("I check sign in checkbox")
    public void clickSignInCheckbox() {

        spage.clickSignInCheckbox();
    }

    @When("I click sign in button")
    public void clickLogIn() {
        spage.clickSignInBtn();
    }

    @Then("I verify sign in error is displayed")
    public void verifySignInError() {
    Assert.assertTrue(spage.verifySignInErrorMessage());
    }
}