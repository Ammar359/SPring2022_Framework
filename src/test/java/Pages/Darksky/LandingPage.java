package Pages.Darksky;

import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends Commands {

    // Locators of Landing Page elements
    By timeMachineLocator = By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']");
    By searchInputLocator = By.xpath("//form[@id='searchForm']//input");
    By searchBtnLocator = By.xpath("//form[@id='searchForm']//a[@class='searchButton']");
    String weatherAttributeValue_starts = "//div[@class='";
    String weatherAttributeValue_ends = "']//span[contains(@class, '__value')]";

    By currentForecastLocator = By.xpath("//span[@class='summary swap']");



    // Method to interact with Landing Page elements
    // method to scroll and find if Time Machine button is enabled


    public void enterSearchLocation(String location) {
        clearField(searchInputLocator);
        type(searchInputLocator, location);
    }

    public void clickSearchButton() {
        clickIt(searchBtnLocator);
    }

    // method to scroll to Time Machine button
    public WebElement scrollToTimeMachineButton() {
        return scrollToElement(timeMachineLocator);
    }

    // method to check if Time Machine button is enabled
    public boolean isTimeMachineButtonEnabled() {
        return scrollToTimeMachineButton().isEnabled();
    }

    public String getWeatherAttributeValue(String attribute) {
        String xpathValue = weatherAttributeValue_starts + attribute.toLowerCase() + weatherAttributeValue_ends;
        return getTextOfWebElement(By.xpath(xpathValue));
    }

    public String getForecast() {
        return getTextOfWebElement(currentForecastLocator);
    }

    public boolean isForecastDisplayed() {
        return isElementDisplayed(currentForecastLocator);
    }


    // method to check if Time Machine button is displayed


    // method to click Time Machine button




}