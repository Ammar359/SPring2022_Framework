package Pages.Hotels;

import Helper.Misc;
import Pages.Commands;

import org.openqa.selenium.By;


public class SignInPage extends Commands {

    //@Test
         //public void signInErrorMessage (){
      //  MyDriver.launchUrlOnNewWindow("https://www.hotels.com/login");
        //MyDriver.getDriver().manage().window().maximize();
    By signInLocator = By.xpath("//button[contains(text(),'Sign in')]");
    By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
    By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
    By loginCheckboxLocator = By.xpath("//input[@type='checkbox']");
    By loginBtnLocator = By.xpath("//*[@id='loginFormSubmitButton']");
    By signInErrorMessageLocator = By.xpath("//*[@id='loginFormErrorBanner']");


    public void enterSignInEmail() {
        type(emailInputLocator, "elliewilliams@lou.com");
        Misc.pause(1);
    }

    public void enterSignInPassword() {
        type(passwordInputLocator, "blablabla123123");
        Misc.pause(2);
    }

    public void clickSignInCheckbox() {
        clickIt(loginCheckboxLocator);
    }

    public void clickSignInBtn() {
        clickIt(loginBtnLocator);
        Misc.pause(2);
    }

    public boolean verifySignInErrorMessage() {
        return isElementDisplayed(signInErrorMessageLocator);
    }
}