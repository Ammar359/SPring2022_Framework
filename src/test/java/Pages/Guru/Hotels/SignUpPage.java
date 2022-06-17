package Pages.Guru.Hotels;

import Pages.Commands;
import Pages.Web.MyDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class SignUpPage extends Commands {

    By emailInputLocator = By.xpath("//*[@id='signupFormEmailInput']");
    By firstNameInputLocator = By.xpath("//*[@id='signupFormFirstNameInput']");
    By lastNameInputLocator = By.xpath("//*[@id='signupFormLastNameInput']");
    By passwordInputLocator = By.xpath("//*[@id='signupFormPasswordInput']");
    By signUpCheckboxLocator = By.xpath("//*[@id='signUpFormRememberMeCheck']");
    By signUpBtnLocator = By.xpath("//*[@id='signupFormSubmitButton']");
    By signInCheckBox = By.xpath("//input[@id='signUpFormRememberMeCheck']");
    By continueBtn = By.xpath("//button[@id='signupFormSubmitButton']");


    // Locators for Privacy and Terms & Conditions pages
    By privacyPageLinkLocator = By.xpath("//a[text()='Privacy Statement']");
    By privacyPageHeadingLocator = By.xpath("//h2[text()='Privacy Statement']");
    By termsConditionsPageLinkLocator = By.xpath("//a[text()='Terms and Conditions']");
    By termsConditionsHeadingLocator = By.xpath("//h1[text()='Terms and Conditions']");

    // Sign up page Methods

    public void firstName(){
        type(firstNameInputLocator,"!@#");
    }
    public void lastName(){
        type(lastNameInputLocator,"%^&");
    }
    public void enterEmail() {
        type(emailInputLocator, "joelwilliams@lou.com");
    }

    public void enterPassword() {
        type(passwordInputLocator, "blablabla123@");
    }
    public void signInBox(){
        clickIt(signInCheckBox);
    }
    public void continueBtnBox(){
        clickIt(continueBtn);
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

        //        closeActiveBrowserWindow();
        switchToWindow(signUpPageWindowHandle);
    }


    // Terms and Conditions Methods
    public void clickTermsConditionsLink() {
        clickIt(termsConditionsPageLinkLocator);
        switchToWindow(signUpPageWindowHandle);
    }


    public boolean verifyTermsAndConditionsOnHotels() {

        String currentWindowHandle = MyDriver.getDriver().getWindowHandle();
        Set<String> allWindows = MyDriver.getDriver().getWindowHandles();
        String currentTitle = null;
        for (String window : allWindows) {
            if (!currentWindowHandle.equalsIgnoreCase(window)) {
                return verifyTermsAndConditionsOnHotels();
            }
        }


        return true;
    }
}