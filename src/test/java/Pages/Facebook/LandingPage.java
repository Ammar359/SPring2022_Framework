package Pages.Facebook;


import Pages.Commands;

import Pages.Web.MyDriver;
import org.openqa.selenium.By;

public class LandingPage extends Commands {

    // Variables (Locators)
    By firstNameInputLocator = By.xpath("//*[@id='signupFormFirstNameInput']");
    By lastNameInputLocator = By.xpath("//*[@id='signupFormLastNameInput']");
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");
    By createNewAccountBtnLocator = By.xpath("//a[@data-testid='open-registration-form-button']");
    By signInCheckBox = By.xpath("//input[@id='signUpFormRememberMeCheck']");

    // Methods (to interact with webElements present on this webpage)

    public void firstName(){
        type(firstNameInputLocator,"^%#^");
    }
    public void enterLoginEmail(String loginEmail) {
        // MyDriver.getDriver().findElement(loginEmailLocator).sendKeys(loginEmail);
        type(loginEmailLocator, loginEmail);
    }

    public void enterLoginPassword(String loginPwd) {
        // MyDriver.getDriver().findElement(loginPassLocator).sendKeys(loginPwd);
        type(loginPassLocator, loginPwd);
    }

    public void clickLoginButton() {
        // MyDriver.getDriver().findElement(loginButtonLocator).click();
        clickIt(loginButtonLocator);
    }

    public void clickCreateNewAccountBtn() {
        // MyDriver.getDriver().findElement(createNewAccountBtnLocator).click();
        clickIt(createNewAccountBtnLocator);
    }

    public boolean isLoginBtnEnabled() {
        return MyDriver.getDriver().findElement(loginButtonLocator).isEnabled();
    }

    public boolean isCreateNewAccountBtnEnabled() {
        return isElementEnabled(createNewAccountBtnLocator);
    }

}