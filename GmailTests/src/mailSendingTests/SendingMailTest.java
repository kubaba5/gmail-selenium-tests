package mailSendingTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.NewMailPage;
import utilities.DriverFactory;

public class SendingMailTest {

    private static WebDriver driver;

    private static String gmailLoginUrl = "http://gmail.com";
    private String newMailUrl = "https://mail.google.com/mail/#inbox?compose=new";

    private static String name = "mojnowymailjhb";
    private static String password = "StrongPassword123";

    private String addressee = "kubaba5b@gmail.com";
    private String topic = "test topic";
    private String content = "Lorem ipsum";

    private String sentCommunicate = "Wiadomość została wysłana. Wyświetl wiadomość";
    private String errorHeader = "Błąd";
    private String errorCommunicate = "Określ co najmniej jednego adresata";

    DriverFactory df = new DriverFactory();


    @Test
    public void SendingMailTest() {
        driver.get(newMailUrl);
        NewMailPage newMailPage = new NewMailPage(driver);

        df.waitForElementToBeVisible(driver, newMailPage.getToField());

        newMailPage.provideAddressee(addressee);
        newMailPage.provideTopic(topic);
        newMailPage.provideContent(content);
        newMailPage.getSendButton().click();

        df.waitForElementToBeVisible(driver, newMailPage.getSentMessageToast());

        Assertions.assertEquals(newMailPage.getSentMessageToast().getText(), sentCommunicate);
    }

    @Test
    public void SendingEmptyMailTest() {
        driver.get(newMailUrl);
        NewMailPage newMailPage = new NewMailPage(driver);

        df.waitForElementToBeVisible(driver, newMailPage.getToField());

        newMailPage.provideAddressee(addressee);
        newMailPage.provideTopic(topic);
        newMailPage.getSendButton().click();

        df.waitForElementToBeVisible(driver, newMailPage.getSentMessageToast());

        Assertions.assertEquals(newMailPage.getSentMessageToast().getText(), sentCommunicate);
    }

    @Test
    public void SendingMailWithoutAddressee() {
        driver.get(newMailUrl);
        NewMailPage newMailPage = new NewMailPage(driver);

        df.waitForElementToBeVisible(driver, newMailPage.getToField());

        newMailPage.provideTopic(topic);
        newMailPage.provideContent(content);
        newMailPage.getSendButton().click();

        df.waitForElementToBeVisible(driver, newMailPage.getErrorHeader());

        Assertions.assertEquals(newMailPage.getErrorHeader().getText(), errorHeader);
        Assertions.assertEquals(newMailPage.getErrorCommunicate().getText(), errorCommunicate);
    }

    @BeforeAll
    public static void loginBefore() {

        driver = utilities.DriverFactory.open("chrome");
        driver.get(gmailLoginUrl);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginToTheSystem(name, password);

    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Its after our test");
        driver.close();
    }

}