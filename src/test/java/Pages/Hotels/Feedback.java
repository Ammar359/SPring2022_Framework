package Pages.Hotels;

import Helper.Misc;
import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Feedback extends Commands {

    By allStarsLocator = By.xpath("//div[@class='radio-group']/div/label");
    By starRatingLegendLocator = By.xpath("//div[@class='radio-legend']//*");
    By commentInputFieldLocator = By.xpath("//*[@id='verbatim']");
    By returnQuestionsDropdownLocator = By.xpath("//*[@id='will-you-return']");
    By emailInputLocator = By.xpath("//*[@id='email_address']");
    By privacyPolicyLinkLocator = By.xpath("//a[contains(text(),'Privacy Policy')]");

    By priorBookingBtnLocator = By.xpath("//label[contains(@for,'booked-here-before')]");
    By wereYouSuccessfulBtnLocator = By.xpath("//label[contains(@for,'were-you-successful')]");

    By submitBtnLocator = By.xpath("//*[@id='submit-button']");
    By emptyFormSubmissionErrorLocator = By.xpath("//*[@id='required']");
    By redDottedBorderLocator = By.xpath("//*[contains(@style,'2px dotted rgb')]");
    By thankYouForFeedbackMessageLocator = By.xpath("//*[@id='thank-you']");


    public void clickFormSubmitBtn() {
        scrollIntoElementToView(submitBtnLocator);
        clickIt(submitBtnLocator);
    }
    public boolean isEmptyFormSubmissionErrorDisplayed() {
        return isElementDisplayed(emptyFormSubmissionErrorLocator);
    }
    public boolean isRedDottedBorderDisplayed() {
        return isElementDisplayed(redDottedBorderLocator);
    }

    public void clickOnStarRating(String starValue) {
        List<WebElement> stars = findWebElements(allStarsLocator);
        for (WebElement value : stars) {
            if (value.getAttribute("for").contains(starValue)) {
                value.click();
                break;
            }
        }
    }

    public void enterTextInComments(String inputText) {
        type(commentInputFieldLocator, inputText);
    }

    public void selectDropdownQuestion(String dropdownOption) {
        selectInDropdown(returnQuestionsDropdownLocator, dropdownOption);
    }

    public void selectPriorBookingAnswer(String answer) {
        List<WebElement> buttons = findWebElements(priorBookingBtnLocator);
        for (WebElement btn : buttons) {
            if (btn.getAttribute("for").contains(answer.toLowerCase())) {
                btn.click();
                break;
            }
        }
    }

    public void selectWereYouSuccessfulAnswer(String answer) {
        List<WebElement> buttons = findWebElements(wereYouSuccessfulBtnLocator);
        for (WebElement btn : buttons) {
            if (btn.getAttribute("for").contains(answer.toLowerCase())) {
                btn.click();
                break;
            }
        }
    }

    public void enterUserEmail(String email) {
        type(emailInputLocator, email);
    }

    public boolean isThankYouMessageDisplayed() {
        Misc.pause(2);
        return isElementDisplayed(thankYouForFeedbackMessageLocator);
    }
}