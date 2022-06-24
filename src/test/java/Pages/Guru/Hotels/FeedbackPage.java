package Pages.Guru.Hotels;


import Pages.Commands;

import org.openqa.selenium.By;

public class FeedbackPage extends Commands {


    By feedBackButtonLocator = By.xpath("//div[contains(text(),'Feedback')]");
    By submitBtnLocator = By.xpath("//*[@id='submit-button']");
    By emptyFormSubmissionErrorLocator = By.xpath("//*[@id='required']");
    By redDottedBorderLocator = By.xpath("//*[contains(@style,'2px dotted rgb')]");




    public void clickFeedback(){
        clickIt(feedBackButtonLocator);
    }
    public void clickFormSubmitBtn() {
        clickIt(submitBtnLocator);
    }

    public boolean isEmptyFormSubmissionErrorDisplayed() {
        return isElementDisplayed(emptyFormSubmissionErrorLocator);
    }

    public boolean isRedDottedBorderDisplayed() {
        return isElementDisplayed(redDottedBorderLocator);
        }

}