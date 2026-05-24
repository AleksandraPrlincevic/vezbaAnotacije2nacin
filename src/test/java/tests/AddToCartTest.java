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
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    String profileURL = "https://demoqa.com/profile";
    String validUsername = "Aleksandra.Prlincevic1";
    String validPassword = "Qwerty123!@#";

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/login/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        profilePage = new ProfilePage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.validLogin(validUsername, validPassword);
        profilePage.clickGoToBookStoreButton();

    }
    @Test
    public void addToCartTest(){
        booksPage.clickOnSelectedItem();
    }


}
