package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.ProfilePage;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    String profileURL = "https://demoqa.com/profile";
    String validUsername = "Aleksandra.Prlincevic1";
    String validPassword = "Qwerty123!@#";

    public void validLogin(String validUsername, String validPassword) {
        driver.navigate().to("https://demoqa.com/login/");
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
    }
}
