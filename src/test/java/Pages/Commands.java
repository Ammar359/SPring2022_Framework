package Pages;

import Pages.Web.MyDriver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Commands {
    Alert myAlert;
    // Create a local method to find WebElement
    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }
    public WebElement findWebElementWithWait(By locator) {
        Wait fWait = new FluentWait(MyDriver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage("Fluent wait timeout, waited for 30-seconds");
        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }
    // Create a local method to find WebElements
    public List<WebElement> findWebElements(By locator) {
        return MyDriver.getDriver().findElements(locator);
    }
    // Create a local method to type in the webElement
    public void type(By locator, String data) {
        findWebElement(locator).sendKeys(data);
    }
    public String getCurrentTitle(){
        return MyDriver.getDriver().getTitle();
    }
    public String getTextOfWebElement(By locator) {
        return findWebElement(locator).getText();
    }

    public String getAttributeValueFromWebElement(By locator, String attribute) {
        return findWebElement(locator).getAttribute(attribute);
    }

    // Create a local method to click on the webElement
    public void clickIt(By locator) {
        findWebElementWithWait(locator).click();
    }

    //Method to get text of element
    public String getTextOfElement(By locator) {
        return findWebElement(locator).getText();
    }
    // Create a local method to click on the webElement after scroll
    public void clickItWithScroll(By locator) {
        scrollToElement(locator).click();
    }


    // Create a local method to find if element is enabled
    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }
    // Create a local method to select a value from a dropdown
    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement ddElement = findWebElement(locator);
        Select dropdown = new Select(ddElement);
        dropdown.selectByVisibleText(dataToSelect);
    }

    // Create a local method to find if element is displayed
    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public String getPageSource(){
        return MyDriver.getDriver().getPageSource();
    }
    // Create custom method to scroll
    public WebElement scrollToElement(By locator) {
        WebElement element = null;
        for (int i=0 ; i <= 20 ; i++) {
            try {
                element = findWebElementWithWait(locator);
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                //scroll by 100
                JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,100)");
            }
        }
        return element;
    }

    public void scrollToElementWithOutClick(By locator){
        WebElement element = null;
        for (int i=0 ; i <= 20 ; i++) {
            try {
                element = findWebElementWithWait(locator);
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                //scroll by 100
                JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,100)");
            }
        }
    }

    public void verifyIsEquals(String element1,String element2){
        Assert.assertEquals(element1, element2, "They are not equal");

    }
    // custom methods to switch to a window
    public void switchToWindow(String newHandle) {
        MyDriver.getDriver().switchTo().window(newHandle);
    }
    public void switchToWindowAndClose(String handle){
        MyDriver.getDriver().switchTo().window(handle).close();
    }
    // custom method to get current window-handle
    public String getCurrentWindowHandle() {
        return MyDriver.getDriver().getWindowHandle();
    }
    // custom method to get all window-handles
    public Set<String> getAllWindowHandles() {
        return MyDriver.getDriver().getWindowHandles();
    }
    // custom method to select date from Calendar
    public void selectDateInCalendar(By locator, String userDate) {
        List<WebElement> allDates = MyDriver.getDriver().findElements(locator);
        for (WebElement dateElement : allDates) {
            String dateValue = dateElement.getAttribute("data-day");
            if (dateValue.equals(userDate)) {
                dateElement.click();
                break;
            }
        }
    }
    public void selectFromSuggestions(By locator, String userSuggestion) {
        List<WebElement> allSuggestions = MyDriver.getDriver().findElements(locator);
        for (WebElement suggestion : allSuggestions) {
            if(suggestion.getText().equalsIgnoreCase(userSuggestion)) {
                suggestion.click();
                break;
            }
        }
    }


    public void scrollToButton(By locator){
        for (int i = 0; i <= 25; i++) {
            try {
                findWebElementWithWait(locator);
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor jsE = (JavascriptExecutor) MyDriver.getDriver();
                jsE.executeScript("scrollBy(0,1000)");
            }
        }
    }

    public void scrollAndClickToButtonDarkSky(By locator){
        for (int i = 0; i <= 20; i++) {
            try {
                findWebElementWithWait(locator);
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor jsE = (JavascriptExecutor) MyDriver.getDriver();
                jsE.executeScript("scrollBy(0,200)");
            }
        }
    }
    public String getTextFromElementDarkSky(By locator){
        return findWebElement(locator).getText();
    }
    public List<String> convertListToSet (Set<String> input){
        List<String> arrList = new ArrayList<>();
        for (String val : input){
            arrList.add(val);
        }
        return arrList;
    }
    public int NumOfWindowHandles (){
        return getAllWindowHandles().size();
    }
    public boolean isItSelected(By locator){
        return findWebElement(locator).isSelected();
    }
    public void switchToAlert() {
//        WebDriverWait eWait = new WebDriverWait(MyDriver.getDriver(), 5);
//        eWait.until(ExpectedConditions.alertIsPresent());
        myAlert = MyDriver.getDriver().switchTo().alert();
    }
    public void clickPositiveActionBtnOnAlert() {
        if(myAlert == null) {
            switchToAlert();
        }
        myAlert.accept();
    }
    public void clickNegativeActionBtnOnAlert() {
        if(myAlert == null) {
            switchToAlert();
        }
        myAlert.dismiss();
    }
    public String getTextFromAlert() {
        if(myAlert == null) {
            switchToAlert();
        }
        return myAlert.getText();
    }
    public void typeInAlert(String data) {
        if(myAlert == null) {
            switchToAlert();
        }
        myAlert.sendKeys(data);
    }

    // Custom method/function to switch on Frame using iframe-id
    public void switchToFrame (String frameId) {
        MyDriver.getDriver().switchTo().frame(frameId);
    }

    // Custom method/function to switch on Frame using iframe-element
    public void switchToFrame (By locator) {
        WebElement myFrame = findWebElement(locator);
        MyDriver.getDriver().switchTo().frame(myFrame);
    }

    // Custom method/function to switch on Frame using iframe-index
    public void switchToFrame (int frameIndex) {
        MyDriver.getDriver().switchTo().frame(frameIndex);
    }

    public void switchToMainWindowFromFrame () {
        MyDriver.getDriver().switchTo().defaultContent();
    }

    public void scrollIntoElementToView(By locator){
        WebElement element = MyDriver.getDriver().findElement(locator);
        JavascriptExecutor jS = (JavascriptExecutor) MyDriver.getDriver();
        jS.executeScript("arguments[0].scrollIntoView();",element);
    }







}