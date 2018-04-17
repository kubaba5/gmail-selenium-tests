package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(id = "identifierId")
    private WebElement login;
    @FindBy(css = "input[type='password']")
    private WebElement password;
    @FindBy(id = "identifierNext")
    private WebElement loginNextButton;
    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void provideLogin(String login) {
        this.login.sendKeys(login);
    }

    public void providePassword(String password) {
        this.password.sendKeys(password);
    }

    public WebElement getLoginNextButton(){
        return loginNextButton;
    }

    public WebElement getPasswordNextButton(){
        return passwordNextButton;
    }

    public WebElement getPassword(){
        return password;
    }
}