package Tests.Darksky;

import Pages.Darksky.LandingPage;

import Pages.Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeMachine {

    // Verify user is able to click Time Machine button
    /*
        Steps:
        1. Launch darksky page
        2. Scroll down to Time Machine button
        3. Verify Time Machine button is enabled
     */
    @Test
    public void verifyTimeMachineClickable() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

        LandingPage lpage = new Pages.Darksky.LandingPage();
        Assert.assertTrue(lpage.isTimeMachineButtonEnabled(), "Error");

    }


}