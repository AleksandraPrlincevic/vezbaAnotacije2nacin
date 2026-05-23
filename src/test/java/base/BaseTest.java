package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v145.profiler.model.Profile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BooksPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HomePage homePage;
    public BooksPage booksPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

   /* @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
