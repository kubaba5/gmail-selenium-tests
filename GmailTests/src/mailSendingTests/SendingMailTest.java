package mailSendingTests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.NewMailPage;

import java.util.concurrent.TimeUnit;


public class SendingMailTest {

    private static WebDriver driver;

    private static String gmailLoginUrl = "http://gmail.com";
    private String gmailHomeUrl = "https://mail.google.com/mail/#inbox";
    private String newMailUrl = "https://mail.google.com/mail/#inbox?compose=new";

    private static String name = "mojnowymailjhb";
    private static String password = "StrongPassword123";

    private String addressee = "kubaba5b@gmail.com";
    private String topic = "test topic";
    private String content = "Lorem ipsum";


    @Test
    public void SendingMailTest(){
        driver.get(newMailUrl);
        NewMailPage newMailPage = new NewMailPage(driver);

        utilities.DriverFactory.waitForElementToBeVisible(driver, newMailPage.getToField());

        newMailPage.provideAddressee(addressee);
        newMailPage.provideTopic(topic);
        newMailPage.provideContent(content);
        newMailPage.getSendButton().click();

        utilities.DriverFactory.waitForElementToBeVisible(driver, newMailPage.getSentMessageToast());

        Assertions.assertEquals(newMailPage.getSentMessageToast(), "Wysłano nową wiadomość");
    }

    @BeforeAll
    public static void setUp(){
        System.out.println("Setting up test");
        driver = utilities.DriverFactory.open("chrome");
        driver.get(gmailLoginUrl);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideLogin(name);
        loginPage.getLoginNextButton().click();

        utilities.DriverFactory.waitForElementToBeVisible(driver, loginPage.getPassword());

        loginPage.providePassword(password);
        loginPage.getPasswordNextButton().click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Odebrane']")));

    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Its after our test");
        driver.close();
    }

}