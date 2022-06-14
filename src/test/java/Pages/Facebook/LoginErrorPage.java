package Pages.Facebook;

import Pages.Commands;
import org.openqa.selenium.By;

public class LoginErrorPage extends Commands {


    By loginErrorLocator = By.xpath("//div[contains(text(),'or mobile number you entered isn')]");


    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorLocator);
    }



}