package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {



    public static WebDriver open(String browser){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            return new ChromeDriver();
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
}
