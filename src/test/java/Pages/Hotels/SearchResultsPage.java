package Pages.Hotels;

import Helper.Misc;
import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends Commands {

    By clickDestination = By.xpath("//button[@data-stid='location-field-destination-menu-trigger']");
    By destinationBox = By.xpath("//input[@id='location-field-destination']");
    By boraBoraLocator = By.xpath("//button[@aria-label='Bora Bora Leeward Islands, French Polynesia']");


    String monthDate_1 = "//h2[text()='";
    String monthDate_2 = "']/following-sibling::table//button[@data-day]";
    By calendarHeadingLocator = By.xpath("(//div[@data-stid='date-picker-month'])[1]//h2");
    By nextMonthArrowLocator = By.xpath("(//button[@data-stid='date-picker-paging'])[2]");
    By checkInBoxLocator = By.id("d1-btn");
    By checkOutBoxLocator = By.id("d2-btn");
    By doneButton = By.xpath("//button[@data-stid='apply-date-picker']");
    By searchButton = By.xpath("//button[text()='Search']");

    By howWeImproveLocator = By.xpath("//span[text()='Tell us how we can improve our site']");
    By shareFeedbackLinkLocator = By.xpath("//a[text()='Share feedback']");
    //By howToImproveLocatedAtTheEndLocator = By.xpath("//section[@data-stid='section-results']/following::div[@data-stid='shared-ui-voice-of-the-customer']//span[text()='Tell us how we can improve our site']");
    // By shareFeedbackLocatedAtTheEndLocator = By.xpath("//section[@data-stid='section-results']/following::div[@data-stid='shared-ui-voice-of-the-customer']//span[text()='Tell us how we can improve our site']");





    public void typeTheDestination (String cityName) {
        clickIt(clickDestination);
        type(destinationBox,cityName);
        Misc.pause(2);
        clickIt(boraBoraLocator);
    }
    public void clickCheckInTable () {
        clickIt(checkInBoxLocator);
    }
    public void clickCheckOutTable () {
        clickIt(checkOutBoxLocator);
    }
    public void goToTheMonth(String monthYear) {
        for (int i=0 ; i<12 ; i++) {
            if (getTextOfWebElement(calendarHeadingLocator).equalsIgnoreCase(monthYear)) {
                break;
            }
            clickIt(nextMonthArrowLocator);
        }
    }
    public void selectDateFromAnyMonth(String monthYear, String dateValue) {
        goToTheMonth(monthYear);
        By allDatesLocator = By.xpath(monthDate_1 + monthYear + monthDate_2);
        selectDateInCalendar(allDatesLocator, dateValue);
    }
    public void clickDoneBtn () {
        clickIt(doneButton);
    }
    public void clickOnSearchBtn () {
        clickIt(searchButton);
    }
    public WebElement scrollToShareFeedback () {
        return scrollToElement(shareFeedbackLinkLocator);
    }
    public boolean isShareFeedbackDisplayed() {
        scrollToElement(shareFeedbackLinkLocator);
        return   isElementDisplayed(shareFeedbackLinkLocator);
        //isElementEnabled(shareFeedbackLinkLocator);
    }
    public boolean howWeImproveIsDisplayed () {
        scrollToElement(howWeImproveLocator);
        return isElementDisplayed(howWeImproveLocator);
    }
    public boolean isShareFeedbackEnabled() {
        scrollToElement(shareFeedbackLinkLocator);
        return  isElementEnabled(shareFeedbackLinkLocator);
    }








}