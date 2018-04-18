package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverFactory;

public class LoginPage extends PageObject {
    @FindBy(id = "identifierId")
    private WebElement loginField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(id = "identifierNext")
    private WebElement loginNextButton;
    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    NewMailPage nmp = new NewMailPage(driver);
    DriverFactory df = new DriverFactory();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void provideLogin(String login) {
        this.loginField.sendKeys(login);
    }

    public void providePassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void loginToTheSystem(String login, String password) {
        provideLogin(login);
        loginNextButton.click();
        df.waitForElementToBeVisible(driver, passwordField);
        providePassword(password);
        passwordNextButton.click();
        df.waitForElementToBeVisible(driver, nmp.getReceivedLabel());
    }
}