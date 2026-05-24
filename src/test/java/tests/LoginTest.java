package tests;

import base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    String validUsername = "Aleksandra.Prlincevic1";
    String validPassword = "Qwerty123!@#";
    String invalidUsername ="sbrkndy2";
    String invalidPassword = "0987kr)(";
    String loginURL = "https://demoqa.com/login";
    String profileURL = "https://demoqa.com/profile";

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.navigate().to("https://demoqa.com/");
        homePage.clickBookStoreAppButton();
        booksPage.clickOnLoginBox();
    }

    @Test (priority = 10)
        public void validLogin() throws InterruptedException {

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();

        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, profileURL);

        Assert.assertEquals(profilePage.usernameString.getText(), validUsername);

        Assert.assertTrue(profilePage.logoutButton.isDisplayed());
    }
    @Test (priority = 1)
    public void invalidCredentials() throws InterruptedException {

        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, loginURL);

         wait.until(ExpectedConditions.visibilityOf(loginPage.loginForm)); // ali ovo je zapravo vec neka vrsta asertacije ?
        Assert.assertTrue(loginPage.loginForm.isDisplayed());              // i ovde sad proveravam isto ali koristim assert

        String expectedMessage = "Invalid username or password!";
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedMessage);
    }

    @Test (priority = 2)
    public void missingUsername() throws InterruptedException {

        loginPage.inputUsername("");
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, loginURL);

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginForm));
        Assert.assertTrue(loginPage.loginForm.isDisplayed());

        Assert.assertTrue(loginPage.usernameFieldInvalid.isDisplayed());
    }

    @Test (priority = 3)
    public void missingPassword() throws InterruptedException {

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword("");
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, loginURL);

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginForm));
        Assert.assertTrue(loginPage.loginForm.isDisplayed());

        Assert.assertTrue(loginPage.passwordFieldInvalid.isDisplayed());
    }

    @Test (priority = 4)
    public void missingUsernameAndPassword() throws InterruptedException {

        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, loginURL);
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loginForm.isDisplayed());

        Assert.assertTrue(loginPage.passwordFieldInvalid.isDisplayed());
        Assert.assertTrue(loginPage.passwordFieldInvalid.isDisplayed());
    }
}
