package Tests.Facebook;

import Helper.Misc;
import Pages.Facebook.LandingPage;
import Pages.Facebook.LoginErrorPage;
import Pages.Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {

    // Verify user can login with valid credentials
    @Test
    public void validCredentials() {

    }


    // Verify user cannot login with invalid credentials
    /*
        1. Open facebook.com
        2. Enter invalid credentials ($%^&*( / abcd@1234)
        3. Verify user gets error
     */
    @Test
    public void InvalidCredentials() {
      MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        LandingPage landingPage = new LandingPage();
        landingPage.enterLoginEmail("$%^&*(");
        landingPage.enterLoginPassword("abcd@1234");
        landingPage.clickLoginButton();

        Misc.pause(10);

        LoginErrorPage lePage = new LoginErrorPage();
        Assert.assertTrue(lePage.isLoginErrorDisplayed(), "Login error msg is not displayed for invalid credentials flow");
    }

    // Verify user cannot login with empty credentials
    @Test
    public void emptyCredentials() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        LandingPage landingPage = new LandingPage();
        landingPage.clickLoginButton();

        Misc.pause(10);

        LoginErrorPage lePage = new LoginErrorPage();
        Assert.assertTrue(lePage.isLoginErrorDisplayed(), "Login error msg is not displayed for empty credentials flow");

    }






}