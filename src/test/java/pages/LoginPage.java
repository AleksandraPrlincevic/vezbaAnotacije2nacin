package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login")
    public WebElement loginButton;

    String username = "Aleksandra.Prlincevic1";
    String password = "Qwerty123!@#";


    //--------------------Metode za testiranje----------------

    public void inputUsername(){
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);
    }
    public void inputPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
