package StepDefinition.Facebook;

import Pages.Facebook.LandingPage;
import Pages.Facebook.LoginErrorPage;
import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSD {
    LandingPage lpage = new LandingPage();
    LoginErrorPage lePage = new LoginErrorPage();


//    // Glue code
//    @Given("^I am on facebook landing page$")
//    public void openFacebook() {
//        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
//    }

//    @Given("^I am on (facebook|darksky|hotels) landing page$")
//    public void openWebPage(String webPageName) {
//        switch (webPageName) {
//            case "facebook":
//                MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
//                break;
//            case "darksky":
//                MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
//                break;
//            case "hotels":
//                MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
//                break;
//            default:
//                System.out.println("Invalid webpage name");
//        }
//        /*
//            I am on facebook landing page
//
//            I am on darksky landing page
//
//            I am on hotels landing page
//         */
//
//    }

    @When("^I click on login button$")
    public void clickLoginBtn() {
        lpage.clickLoginButton();
    }

//    @Given("^I enter (.+) in login username$")
//    public void enterLoginUsername(String username) {
//        lpage.enterLoginEmail(username);
//    }
//
//    @Given("^I enter (.+) in login password$")
//    public void enterLoginPwd(String pwd) {
//        lpage.enterLoginPassword(pwd);
//    }


    /*
        pattern starts with I
         enter ANYTHING in login <password or username>patternEnds
     */
    @Given("^I enter (.+) in login (password|username)$")
    public void enterLoginCredentials(String data, String field) {
        switch (field.toLowerCase()) {
            case "username":
                lpage.enterLoginEmail(data);
                break;
            case "password":
                lpage.enterLoginPassword(data);
                break;
            default:
                System.out.println("Incorrect field name -> " + field);
        }
    }

    @Then("^I [vV]erify error is displayed$")
    public void isLoginErrorDisplayed() {
        Assert.assertTrue(lePage.isLoginErrorDisplayed(), "Login error is not displayed");
    }





}