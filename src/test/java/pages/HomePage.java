package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css =  "a[href = '/books']")
     public WebElement bookStoreAppButton;

    //--------------------Metode za testiranje----------------

    public void clickBookStoreAppButton(){
        wait.until(ExpectedConditions.elementToBeClickable(bookStoreAppButton));
        bookStoreAppButton.click();
    }

}
