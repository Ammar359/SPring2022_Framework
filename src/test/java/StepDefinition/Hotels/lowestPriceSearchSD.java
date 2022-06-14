package StepDefinition.Hotels;

import Pages.Hotels.SearchResultsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
/**
public class lowestPriceSearchSD {

    SearchResultsPage obj = new SearchResultsPage();

    @Then("I verify all popular filters are unchecked")
    public boolean verifyCheckboxes() {
        Assert.assertTrue(verifyCheckboxes(),"Checkboxes are marked");
        return true;
        //Assert.assertFalse(obj.isPopularFilterChecked());
    }

    @When("I sort the search results using price")
    public void sortByPrice() {
        sortByPrice();
        // obj.clickSortByField();
        //obj.clickPriceSuggestion();
    }
    @Then("^I verify lowest price is less then or equal to (.+)$")
    public void verifyLowestPrice(String hotelPrice) {
        int price = Integer.valueOf(hotelPrice.substring(1));
       // Assert.assertTrue(obj.getLowestPrice() <= price);
    }

    @Then("I verify Star rating is displayed in increasing order")
    public void verifyStarOrder() {
        Assert.assertTrue(obj.verifyStarOrder());
    }

    @And("I enter PPPP in search by property")
    public void clickPropertySearch() {
        obj.clickSearchByProperty();
        obj.typeProperty();
    }
    @Then("I verify the No Matches error is displayed on the page")
    public void verifyNoMatchError() {
        Assert.assertTrue(obj.isNoMatchesErrorDisplayed());
    }
    @Then("I verify invalid data entered is displayed as one of the filters")
    public void verifyInvalidDataFilter() {
        Assert.assertTrue(obj.isRemovableFilterDisplayed());
    }

}
 */