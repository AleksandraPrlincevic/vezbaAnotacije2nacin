package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href='/login']")
    public WebElement loginBox;

    //--------------------Metode za testiranje----------------

    public void clickOnLoginBox(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBox));
        loginBox.click();
    }
}
