package Pages.Guru.Hotels;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Helper.Misc;
import org.testng.Assert;

public class TravelerBoxSD {

    TravelerBox gn = new TravelerBox();
    String beforeText = "";
    String afterText = "";

        @When("^I click traveler box$")
        public void clickTravelerBox () {
            gn.clickTravelersBox();
        }

        @Then("^I increase adults number$")
        public void addAdults () {
            for (int i=1; i<5; i++) {
                gn.clickAdultIncreaseBtn();

            }

        }
        @Then("^I increase children number$")
        public void clickChildrenBtn () {
            for (int i = 1; i <= 2; i++) {
                gn.clickChildrenIncreaseBtn();
            }

        }
        @Then("^I choose first children age$")
        public void addChildrenAge () {
            gn.getChildrenAgeFromDropDown_1();
            gn.getChildrenAgeFromDropDown_2();
        }
        @Then("^I choose second children age$")
        public void addChildrenAge_2 () {
            gn.getChildrenAgeFromDropDown_2();
            Misc.pause(2);
            gn.clickOnDoneBtn();
        }
        @Then("^verify  number of guests are matching$")
        public void verifyNumberOfGuestsAreMatching () {
            int numOfAdultInInt =  Integer.valueOf(gn.getAdultNumber());
            int numOfChildrenInInt =  Integer.valueOf(gn.getChildrenNumber());
            int totalNumber = numOfAdultInInt + numOfChildrenInInt;
            System.out.println("*******" + totalNumber);

            String textAfterSplit = gn.getNumberOfGuestsOnHomePage().split(" ")[2];
            System.out.println("********* " + textAfterSplit);
            int totalOnHomePage = Integer.valueOf(textAfterSplit);
          Assert.assertEquals(totalNumber,totalOnHomePage,"Sum of adult and children in Traveler box are not matching as selected.");


        }


    }
