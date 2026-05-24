package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingleBookPage extends BasePage {
    public SingleBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id = 'addNewRecordButton' and contains(. ,'Add To Your Collection')]")
    public WebElement addToYourCollectionButton;

    //WebElement titleDiv = driver.findElement(By.id("title-wrapper"));
    //WebElement bookTitle = titleDiv.findElement(By.id("userName-value"));
    @FindBy(xpath = "//div[@id='title-wrapper']//label[@id='userName-value']")
    WebElement bookTitle;

    //-------------------metode za testiranje--------------------

    public void clickAddToYourCollectionButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToYourCollectionButton));
        addToYourCollectionButton.click();
    }
    public String getBookTitle(){  // ovo sam napravila jer test nije mogao da vidi zeljeni WebElement. Ispostavilo se zato sto nije bio pablic ali sam saznala da je
        // pozivanje elemenata direktno u testu lose i da oni ne treba da budu public vec se za njih rade geteri kao ovaj npr.DA LI TAKO TREBA U PRINCIPU?
        //Da ne bih komplikovala jer vec mi je komplikovano ispravila sam ostale elemente u public. sledeci put cu probati da svi budu private.
        return bookTitle.getText();
    }

}
