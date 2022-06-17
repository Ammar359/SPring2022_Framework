package Pages.Hotels;

import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DealPage extends Commands {

    By dealOfferImageLocator = By.xpath("(//div[contains(@class,'resp-section')])[3]//div[contains(@class,'teaser')]");
    By freeCancellationHeadingLocator = By.xpath("//div[contains(@class,'PageHeading')]//*[contains(text(),'Amazing deals with free cancellation')]");
    By saveOnNextTripHeadingLocator = By.xpath("//ul[@class='breadcrumb']/following-sibling::div/*[contains(text(),'Save on your next')]");
    By searchBookGoHeadingLocator = By.xpath("//*[contains(text(),'Search, book, and save')]");

    public boolean isHeadingDisplayedBox() {
        return isElementDisplayed(searchBookGoHeadingLocator);
    }

    public boolean isHeadingsDisplayed() {
        return isElementDisplayed(saveOnNextTripHeadingLocator);
    }

    public boolean isHeadingDisplayed() {
        return isElementDisplayed(freeCancellationHeadingLocator);
    }

    public boolean areOffersDisplayed() {
        List<WebElement> deals = findWebElements(dealOfferImageLocator);
        boolean isOfferDisplayed = true;
        for (WebElement offer : deals) {
            if (!offer.isDisplayed()) {
                isOfferDisplayed = false;
                break;
            }
        }
        return isOfferDisplayed;
    }

    public boolean areOffersEnabled() {
        List<WebElement> deals = findWebElements(dealOfferImageLocator);
        boolean isOfferEnabled = true;
        for (WebElement offer : deals) {
            if (!offer.isEnabled()) {
                isOfferEnabled = false;
                break;
            }
        }
        return isOfferEnabled;
    }

    public void clickOffer(String offer) {
        List<WebElement> deals = findWebElements(dealOfferImageLocator);
        if (offer.equalsIgnoreCase("Manage Booking")) {
            deals.get(0).click();
        } else if (offer.equalsIgnoreCase("Free Cancellation")) {
            deals.get(1).click();
        } else if (offer.equalsIgnoreCase("Great Outdoors")) {
            deals.get(2).click();
        }
    }
}