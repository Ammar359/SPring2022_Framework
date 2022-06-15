package StepDefinition.Hotels;

import Pages.Hotels.SignInPage;
import Pages.Hotels.SignUpPage;
import Pages.Web.MyDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SignUpSD {

    SignUpPage supage = new SignUpPage();
    SignInPage sipage = new SignInPage();

    @When("I click on privacy page link")
    public void clickPrivacyPageLink() {
   supage.clickPrivacyPageLink();
    }

    @Then("I verify that link opened in new tab")
    public boolean verifyPrivacyPage() {
        Assert.assertEquals(supage.getPrivacyPageHeading(), "Test Failed");
        MyDriver.getDriver().close();
        return false;
    }

    @When("I close privacy page")
    public void closePrivacyPage() {
      closePrivacyPage();
    }

    @When("I click on terms and conditions page link")
    public void clickTermsConditionsLink() {

        supage.clickTermsConditionsLink();
    }

    @When("I verify that it is a correct page")
    public boolean verifyTermsConditionsPage() {
        Assert.assertTrue(verifyTermsConditionsPage(),"Terms and condition page");
        return true;
    }
}
