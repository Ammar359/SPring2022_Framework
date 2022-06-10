
        package Pages.Hotels;

        import Helper.DateLib;
        import Helper.Misc;
        import Pages.Commands;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import java.util.List;

public class LandingPage extends Commands {

    // Navi link Locators
    By topMenuSignInBtnLocator = By.xpath("//nav//button[text()='Sign in']");
    By innerMenuSignInBtnLocator = By.xpath("//div[@class='actions']//a[@data-stid='link-header-account-signin']");
    By signInBtnLocator = By.xpath("//nav//button[text()='Sign in']");
    By signUpBtnLocator = By.xpath("//div[@class='actions']//a[@data-stid='link-header-account-signup']");
    By fiveBottomLinksInInnerNavMenuLocator = By.xpath("//div[@class='header-guest-heading']/following-sibling::div//a");
    By hotelRewardsLinkLocator = By.xpath("//div[@class='header-guest-heading']/following-sibling::div//a/div[text()='Hotels.com® Rewards']");
    By feedbackLinkLocator = By.xpath("//div[@class='header-guest-heading']/following-sibling::div//a/div[text()='Feedback']");

    // Check in/out locators

    By checkInBoxLocator = By.id("d1-btn");
    By checkOutBoxLocator = By.id("d2-btn");
    By checkOutDaysLocator = By.xpath("//h2[text()='June 2022']/following-sibling::table//button[@data-day]");

    // Search Suggestion Box locators

    By searchBtnLocator = By.xpath("//button[text()='Search']");
    By searchErrorLocator = By.xpath("//div[@class='uitk-error-summary']");
    By searchBarLocator = By.xpath("//button[@aria-label='Going to']");
    By searchBarInputLocator = By.id("location-field-destination");
    By destinationSuggestions = By.xpath("//div[@class='uitk-typeahead-results']//div[contains(@class,'truncat') and not(contains(@class,'uitk'))]");

    // Traveler Box section locators

    By travelersMenuLocator = By.xpath("//div[@id='adaptive-menu']");
    By addAdultBtnLocator = By.xpath("//input[@id='adult-input-0']/following-sibling::button");
    By addChildBtnLocator = By.xpath("//input[@aria-label='Children Ages 0 to 17']/following-sibling::button");
    By childrenAgeErrorLocator = By.xpath("//div[@class='uitk-error-summary']/h3");
    By firstChildAgeDropdownLocator = By.xpath("//select[@id='child-age-input-0-0']");
    By secondChildAgeDropdownLocator = By.xpath("//select[@id='child-age-input-0-1']");
    By travelerDoneBtnLocator = By.xpath("//button[@data-testid='guests-done-button']");
    By travelerCountBeforeSearchLocator = By.xpath("//button[@data-testid='travelers-field-trigger']");
    By travelerCountAfterSearchLocator = By.xpath("//button[@data-stid='open-room-picker']/preceding-sibling::input");

    // Calendar locators

    By currentMonthYear = By.xpath("(//div[@class='uitk-date-picker-month']/h2)[1]");
    By nextMonthBtnLocator = By.xpath("(//button[@data-stid='date-picker-paging'])[2]");
    By previousMonthBtnLocator = By.xpath("//button[@data-stid='date-picker-paging' and @disabled]");
    By calendarDoneBtnLocator = By.xpath("//button[@data-stid='apply-date-picker']");
    By calendarDisabledPastDays = By.xpath("//*[@class='uitk-date-picker-weeks']//button[contains(@class,'is-disabled')]");

    // Others

    By rewardNightPromoLocator = By.xpath("//span[contains(text(), 'every 10 nights')]");


    // Sign in/out
    public void clickSignInField() {
        clickIt(topMenuSignInBtnLocator);
    }

    public void clickSignInBtn() {
        findWebElementWithWait(innerMenuSignInBtnLocator).click();
    }

    public void clickSignUpBtn() {
        findWebElementWithWait(signUpBtnLocator).click();
    }

    public void clickFeedbackPage() {
        clickIt(feedbackLinkLocator);
        String landingPageHandle = getCurrentWindowHandle();
        switchToWindow(landingPageHandle);
    }


    // Check in/out  methods
    public void clickCheckInBtn() {
        // I need help with removing wait from here
        clickIt(checkInBoxLocator);
        Misc.pause(1);
    }

    public void clickCheckOutBtn() {

        clickIt(checkOutBoxLocator);
        Misc.pause(1);
    }
    public void selectCheckoutDay(String day) {
        List<WebElement> daysToSelect = findWebElements(checkOutDaysLocator);
        for (WebElement value : daysToSelect) {
            if (value.getAttribute("data-day").equals(day)) {
                value.click();
            }
        }
    }


    // Search bar methods
    public void clickSearchBtn() {
        clickIt(searchBtnLocator);
    }

    public boolean isSearchErrorDisplayed() {
        return isElementDisplayed(searchErrorLocator);
    }

    public void clickSearchBar() {
        clickIt(searchBarLocator);
    }

    public void typeInSearchBar(String destination) {
        // I need help with removing wait from here
        type(searchBarInputLocator, destination);
        Misc.pause(2);
    }

    public void clickDestinationSuggestion(String destination) {
        selectFromSuggestions(destinationSuggestions, destination);
    }



    public void clickNextMonthBtn() {
        // I need help with removing wait from here
        clickIt(nextMonthBtnLocator);
        Misc.pause(1);
    }
    public void selectDayMonthYear(String date) {
        String monthYear = date.split(" ")[1] + " " + date.split(" ")[2];
        String day = date.split(" ")[0];
        By dayLocator = By.xpath("(//div[@class='uitk-date-picker-month'])[1]/h2[text()='" + monthYear + "']/following-sibling::table//button[@data-day='" + day + "']");
        for (int i = 0; i < 12; i++) {
            if (getTextOfWebElement(currentMonthYear).equalsIgnoreCase(monthYear)) {
                clickIt(dayLocator);
                break;
            }
            clickNextMonthBtn();
        }
    }

    public boolean isDisabledPastDayCountCorrect() {
        int totalDisabledDayCount = findWebElements(calendarDisabledPastDays).size();
        int todayDate = DateLib.getCurrentDateAsInt();
        return todayDate - 1 == totalDisabledDayCount;
    }

    public boolean isPreviousMonthBtnDisabled() {
        return isElementDisplayed(previousMonthBtnLocator);
    }

    public void clickCalendarDoneBtn() {
        clickIt(calendarDoneBtnLocator);
    }


    // Travelers methods
    String travelerCountBeforeSearch = "";
    String travelerCountAfterSearch = "";
    int totalAdultCount;
    int totalChildCount;

    public void clickOnTravelersBox() {
        clickIt(travelersMenuLocator);
    }

    public void increaseChildTravelerCount(int childNumber) {
        for (int i = 0; i < childNumber; i++) {
            clickIt(addChildBtnLocator);
            totalChildCount = Integer.valueOf(childNumber);
        }
    }

    public void increaseAdultTravelerCount(int adultNumber) {

        for (int i = 0; i < adultNumber-2; i++) {
            clickIt(addAdultBtnLocator);
            totalAdultCount = Integer.valueOf(adultNumber);
        }
    }

    public boolean isTravelerErrorDisplayed() {
        return isElementDisplayed(childrenAgeErrorLocator);
    }

    public void selectFirstChildAge(String age) {
        if (age.equalsIgnoreCase("Under 1")) {
            age = "0";
        }
        selectInDropdown(firstChildAgeDropdownLocator, age);
    }

    public void selectSecondChildAge(String age) {
        if (age.equalsIgnoreCase("Under 1")) {
            age = "0";
        }
        selectInDropdown(secondChildAgeDropdownLocator, age);
    }

    public void clickTravelerDoneBtn() {
        clickIt(travelerDoneBtnLocator);
    }

    public void saveTravelerCountBeforeSearch() {
        travelerCountBeforeSearch = getAttributeValueFromWebElement(travelerCountBeforeSearchLocator, "aria-label");
    }
    public void saveTravelerCountAfterSearch() {
        travelerCountAfterSearch = getAttributeValueFromWebElement(travelerCountAfterSearchLocator, "value");
    }
    public boolean isTravelersCountSameBeforeAndAfter() {
        return travelerCountBeforeSearch == travelerCountAfterSearch;
    }

    public boolean isTotalTravelerCountCorrect() {
        String var = getAttributeValueFromWebElement(travelerCountBeforeSearchLocator).toString().split("")[2];   //split(" ")[2];
        return Integer.valueOf(var) == totalAdultCount + totalChildCount;
    }

    private By getAttributeValueFromWebElement(By travelerCountBeforeSearchLocator) {
    return travelerCountBeforeSearchLocator;
    }
}