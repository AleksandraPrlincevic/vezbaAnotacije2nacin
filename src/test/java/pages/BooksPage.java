package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement loginBox;

    List<WebElement> rows;
    public WebElement selectedBookRow;
    public WebElement selectedBookLink;


    //--------------------Metode za testiranje----------------

    public void clickOnLoginBox(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBox));
        loginBox.click();
    }
    public String getExpectedBookTitle(){
        return selectedBookLink.getText();
    }

    public void clickOnSelectedItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));
        rows = driver.findElements(By.xpath("//tbody/tr"));
        selectedBookRow = rows.get(0);
        selectedBookLink = selectedBookRow.findElement(By.tagName("a"));
        wait.until(ExpectedConditions.elementToBeClickable(selectedBookLink));
        selectedBookLink.click();
    }
}
