package Tests.Facebook;

import Helper.Misc;
import Pages.Facebook.LandingPage;
import Pages.Facebook.SignUpPage;
import Web.MyDriver;
import org.testng.annotations.Test;

public class Signup {

    // TC -> Select date of birth values in the sign up dropdown
    //      Jan 01 1990
    /*
        Steps:
        1. Launch browser
        2. open facebook.com
        3. Click 'Create new account' button (LandingPage)
        4. Select Jan 1 1990 in date of birth dropdown (SignUpPage)
     */
    @Test
    public void usePom_2() {

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        LandingPage lPage = new LandingPage();
        lPage.clickCreateNewAccountBtn();

        Misc.pause(5);

        SignUpPage sPage = new SignUpPage();
        // sPage.selectBirthDate("Jan 1 1990");

        sPage.selectBirthMonth("Jan");
        sPage.selectBirthDay("1");
        sPage.selectBirthYear("1990");

    }
}