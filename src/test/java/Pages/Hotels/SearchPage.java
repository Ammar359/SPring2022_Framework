package Pages.Hotels;
import Helper.Misc;
import Pages.Commands;
import Pages.Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
public class SearchPage extends Commands {

    //All Locator variables

    By popularCheckboxLocator = By.xpath("//*[@name='popularFilter']");
    By sortByLocator = By.xpath("//*[@id='sort']");
    By sortBySuggestionsLocator = By.xpath("//*[@id='sort']//option");
    By lowestPriceLocator = By.xpath("(//*[@data-test-id='price-summary-message-line']//span/div)[1]");
    By starRatingLocator = By.xpath("//div[@class='uitk-button-toggle']/input[@name='star']");
    By searchPropertyFieldLocator = By.xpath("//button[@aria-label='Search by property name']");
    By searchPropertyTypeFieldLocator = By.xpath("//input[@placeholder='e.g. Best Western']");
    By noMatchesErrorLocator = By.xpath("//*[@data-stid='section-results']//h3[text()='No matches']");
    By getErrorFilterLocator2 = By.xpath("//*[@aria-label='Remove PPPPPP']");
    By shareFeedbackTextLocator = By.xpath("//*[@data-stid='voice-of-the-customer']/span");
    By shareFeedbackBtnLocator = By.xpath("//*[@data-stid='voice-of-the-customer']/a");
    By selectedStarFilterVerificationLocator = By.xpath("//div[@class='all-b-padding-half']//div/span");
    By finalHotelPrice = By.xpath("//*[@data-test-id='price-summary-message-line']//div[contains(text(),'The price is')]/following-sibling::span/div");


    //All Methods

    public boolean isPopularFilterChecked() {
        List<WebElement> popularCheckboxes = findWebElements(popularCheckboxLocator);
        for (WebElement i : popularCheckboxes) {
            if (i.isSelected()) {
                return true;
            }
        }
        return false;
    }
    public void clickSortByField() {
        clickIt(sortByLocator);
    }

    public void clickPriceSuggestion() {
        // I need help with removing wait from here
        selectFromSuggestions(sortBySuggestionsLocator, "Price");
        Misc.pause(5);
    }

    public int getLowestPrice() {
        String price = getTextOfElement(finalHotelPrice);
        return Integer.valueOf(price.substring(1));
    }

    public boolean verifyAppliedPriceFilter() {
        List<WebElement> hotelPrices = findWebElements(finalHotelPrice);
        boolean isPriceFilterCorrect = true;
        for (int i = 0; i < hotelPrices.size() - 1; i++) {
            String currentPrice = hotelPrices.get(i).getText().substring(1);
            String nextPrice = hotelPrices.get(i + 1).getText().substring(1);
            if (Integer.valueOf(currentPrice) > Integer.valueOf(nextPrice)) {
                isPriceFilterCorrect = false;
            }
        }
        return isPriceFilterCorrect;
    }

    public boolean verifyStarOrder() {
        List<WebElement> starRatings = findWebElements(starRatingLocator);
        boolean result = true;
        for (int i = 1; i <= starRatings.size() - 1; i++) {
            String currentStar = MyDriver.getDriver().findElement(By.xpath("(//div[@class='uitk-button-toggle']/input[@name='star'])[" + i + "]")).getAttribute("value");
            String nextStar = MyDriver.getDriver().findElement(By.xpath("(//div[@class='uitk-button-toggle']/input[@name='star'])[" + (i + 1) + "]")).getAttribute("value");
            if (Integer.valueOf(currentStar) + 10 != Integer.valueOf(nextStar)) {
                result = false;
            }
        }
        return result;
    }

    public void selectStarRating(String value) {

        MyDriver.getDriver().findElement(By.xpath("(//div[@class='uitk-button-toggle']/input[@name='star'])" + "[" + value + "]" + "/following-sibling::label")).click();
        Misc.pause(5);
    }

    public boolean verifyAppliedStarFilter() {
        List<WebElement> starFilterDescription = findWebElements(selectedStarFilterVerificationLocator);
        boolean isStarFilterCorrect = true;
        for (WebElement description : starFilterDescription) {
            if (!description.getText().equalsIgnoreCase("5 out of 5")) {
                isStarFilterCorrect = false;
            }
        }
        return isStarFilterCorrect;
    }

    public void clickSearchByProperty() {
        clickIt(searchPropertyFieldLocator);
    }

    public void typeProperty() {
        type(searchPropertyTypeFieldLocator, "PPPPPP");
        WebElement toClick = findWebElement(searchPropertyTypeFieldLocator);
        toClick.sendKeys(Keys.RETURN);
    }
    public boolean isNoMatchesErrorDisplayed() {
        return isElementDisplayed(noMatchesErrorLocator);
    }
    public boolean isRemovableFilterDisplayed() {
        return isElementDisplayed(getErrorFilterLocator2);
    }
    public boolean isShareFeedbackTextDisplayed() {
        scrollToElement(shareFeedbackTextLocator);
        return isElementDisplayed(shareFeedbackTextLocator);
    }
    public boolean isShareFeedbackBtnDisplayed() {
        return isElementDisplayed(shareFeedbackTextLocator);
    }
    public boolean isShareFeedbackBtnEnabled() {
        return isElementEnabled(shareFeedbackTextLocator);
    }
}