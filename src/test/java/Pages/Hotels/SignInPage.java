package Pages.Hotels;
import Pages.Commands;
import org.openqa.selenium.By;
public class SignInPage extends Commands {
    //Locators

    By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
    By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
    By loginCheckboxLocator = By.xpath("//input[@type='checkbox']");
    By loginBtnLocator = By.xpath("//*[@id='loginFormSubmitButton']");
    By signInErrorMessageLocator = By.xpath("//h3");


    public void enterSignInEmail(String email) {
        type(emailInputLocator, email);
    }

    public void enterSignInPassword(String password) {
        type(passwordInputLocator, password);
    }

    public void clickSignInCheckbox() {
       clickIt(loginCheckboxLocator);
    }
    public void clickSignInBtn() {
        clickIt(loginBtnLocator);
    }
    public boolean verifySignInError() {
        return isElementDisplayed(signInErrorMessageLocator);
    }
}
