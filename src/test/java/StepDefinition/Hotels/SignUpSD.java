package StepDefinition.Hotels;

import Pages.Hotels.SignInPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SignUpSD {
    SignInPage sup = new SignInPage();

    @When("I click on privacy page link")
    public void clickPrivacyPageLink() {
       clickPrivacyPageLink();
    }

    @Then("I verify that link opened privacy page")
    public boolean verifyPrivacyPage() {
       Assert.assertTrue(verifyPrivacyPage(),"Priavcy Statement");

        return true;
    }

    @When("I close privacy page")
    public void closePrivacyPage() {
      closePrivacyPage();
    }

    @When("I click on terms and conditions page link")
    public void clickTermsConditionsLink() {
        clickTermsConditionsLink();
    }

    @When("I verify that it is a correct page")
    public boolean verifyTermsConditionsPage() {
        Assert.assertTrue(verifyTermsConditionsPage(),"Terms and condition page");
        return true;
    }
}
