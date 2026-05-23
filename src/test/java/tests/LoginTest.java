package tests;

import base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    public void TestSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        booksPage = new BooksPage(driver);
        loginPage = new LoginPage(driver);


        driver.navigate().to("https://demoqa.com/");
        homePage.clickBookStoreAppButton();
        booksPage.clickOnLoginBox();
    }
        @Test
        public void validLoginTest(){

        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickLoginButton();
    }
    
}
