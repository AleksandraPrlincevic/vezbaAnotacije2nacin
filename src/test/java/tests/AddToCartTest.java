package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import pages.ProfilePage;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    String profileURL = "https://demoqa.com/profile";

      @BeforeMethod
    public void testSetUp(){

          driver = new ChromeDriver();
          driver.manage().window().maximize();
          wait = new WebDriverWait(driver, Duration.ofSeconds(15));

          profilePage = new ProfilePage(driver);
      }



}
