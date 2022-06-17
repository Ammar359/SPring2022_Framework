package Pages.Hotels;

import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpPage extends Commands {

    By emailInputLocator = By.xpath("//*[@id='signupFormEmailInput']");
    By firstNameInputLocator = By.xpath("//*[@id='signupFormFirstNameInput']");
    By lastNameInputLocator = By.xpath("//*[@id='signupFormLastNameInput']");
    By passwordInputLocator = By.xpath("//*[@id='signupFormPasswordInput']");
    By signUpCheckboxLocator = By.xpath("//*[@id='signUpFormRememberMeCheck']/following-sibling::span");
    By continueBtnLocator = By.xpath("//*[@id='signupFormSubmitButton']");
    By signUpFormEntryErrorLocator = By.xpath("//*[contains(@id,'error')]");

    // Locators for Privacy and Terms & Conditions pages

    By privacyPageLinkLocator = By.xpath("//a[text()='Privacy Statement']");
    By privacyPageHeadingLocator = By.xpath("//h2[text()='Privacy Statement']");
    By termsConditionsPageLinkLocator = By.xpath("//a[text()='Terms and Conditions']");
    By termsConditionsHeadingLocator = By.xpath("//h1[text()='Terms and Conditions']");


    // Sign Up Form Methods
    public void enterEmail(String email) {
        type(emailInputLocator, email);
    }

    public void enterFirstName(String firstName) {
        type(firstNameInputLocator, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameInputLocator, lastName);
    }

    public void enterPassword(String password) {
        type(passwordInputLocator, password);
    }

    public boolean signUpErrors(String errorDescription) {
        List<WebElement> errorMessages = findWebElements(signUpFormEntryErrorLocator);
        boolean isErrorDisplayed = false;
        for (WebElement message : errorMessages) {
            if(message.getText().contains(errorDescription)) {
                isErrorDisplayed = true;
                break;
            }
        }
        return isErrorDisplayed;
    }

    public boolean isSignUpCheckboxEnabled() {
        return isElementEnabled(signUpCheckboxLocator);
    }

    public boolean isSignUpCheckboxDisplayed() {
        return isElementDisplayed(signUpCheckboxLocator);
    }

    public boolean isContinueBtnEnabled() {
        return isElementEnabled(continueBtnLocator);
    }

    public boolean isContinueBtnDisplayed() {
        return isElementDisplayed(continueBtnLocator);
    }


    // Privacy Page Methods
    String signUpPageWindowHandle;
    public void clickPrivacyPageLink() {
        clickIt(privacyPageLinkLocator);
        signUpPageWindowHandle = getCurrentWindowHandle();
        switchToWindow(signUpPageWindowHandle);
    }
    public String getPrivacyPageHeading() {
        return getTextOfWebElement(privacyPageHeadingLocator);
    }
    public void closePrivacyPage() {
        closePrivacyPage();

        switchToWindow(signUpPageWindowHandle);
    }
    // Terms and Conditions Methods
    public void clickTermsConditionsLink() {
        clickIt(termsConditionsPageLinkLocator);
        switchToWindow(signUpPageWindowHandle);
    }
    public String getTermsConditionsPageHeading() {
        return getTextOfWebElement(termsConditionsHeadingLocator);
    }
}