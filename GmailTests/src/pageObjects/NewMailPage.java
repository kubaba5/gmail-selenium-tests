package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewMailPage extends PageObject {

    @FindBy(css = "textarea[name='to']")
    WebElement toField;
    @FindBy(css = "input[name='subjectbox']")
    WebElement subjectBox;
    @FindBy(css = "div[class='Am Al editable LW-avf']")
    WebElement content;
    @FindBy(css = "div[aria-label='Wyślij \u202A(⌘Enter)\u202C']")
    WebElement sendButton;
    @FindBy(css = "div[class='vh']")
    WebElement sentMessageToast;
    @FindBy(css = "a[title='Odebrane']")
    WebElement receivedLabel;
    @FindBy(css = "span[role='heading']")
    WebElement errorHeader;
    @FindBy(css = "div[class='Kj-JD-Jz']")
    WebElement errorCommunicate;

    public NewMailPage(WebDriver driver) {
        super(driver);
    }

    public void provideAddressee(String addressee) {
        this.toField.sendKeys(addressee);
    }

    public void provideTopic(String topic) {
        this.subjectBox.sendKeys(topic);
    }

    public void provideContent(String content) {
        this.content.sendKeys(content);
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getSentMessageToast() {
        return sentMessageToast;
    }

    public WebElement getToField() {
        return toField;
    }

    public WebElement getReceivedLabel() {
        return receivedLabel;
    }

    public WebElement getErrorHeader() {
        return errorHeader;
    }

    public WebElement getErrorCommunicate() {
        return errorCommunicate;
    }
}
