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


    List<WebElement> rows = driver.findElements(By.xpath("//table/tr"));

    WebElement selectedBookRow;
    WebElement selectedBookLink;
    //String bookName =selectedBookLink.getText();


    //--------------------Metode za testiranje----------------

    public void clickOnLoginBox(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBox));
        loginBox.click();
    }

    public void clickOnSelectedItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tr")));
        List<WebElement> rows = driver.findElements(By.xpath("//table/tr"));
        selectedBookRow = rows.get(1);
        selectedBookLink = selectedBookRow.findElement(By.tagName("a"));
        wait.until(ExpectedConditions.elementToBeClickable(selectedBookLink));
        selectedBookLink.click();
    }
}
