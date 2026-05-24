package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="userName-value")
    public WebElement usernameString;

    @FindBy(id = "submit")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[@id='submit' and text()='Delete All Books']")
    public WebElement deleteAllBooksButton;

    @FindBy(id = "gotoStore")
    public WebElement goToBookStoreButton;


    //------------------------metode za testiranje-----------------

    public void clickDeleteAllBooksButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteAllBooksButton));
        deleteAllBooksButton.click();
    }

    public void clickGoToBookStoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(goToBookStoreButton));
        goToBookStoreButton.click();
    }


}
