package StepDefinition;

import Web.MyDriver;
import cucumber.api.java.en.Given;

public class CommonSD {

    @Given("^I am on (facebook|darksky|hotels|Guru) landing page$")
    public void openWebPage(String webPageName) {
        switch (webPageName) {
            case "facebook":
                MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
                break;
            case "darksky":
                MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
                break;
            case "hotels":
                MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
                break;
            case "guru":
                MyDriver.launchUrlOnNewWindow("https://demo.guru99.com/test/delete_customer.php/delete_customer.php/");
            default:
                System.out.println("Invalid webpage name");
        }
        /*
            I am on facebook landing page

            I am on darksky landing page

            I am on hotels landing page
         */

    }
}