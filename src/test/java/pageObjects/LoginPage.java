package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class LoginPage extends Page {
    private final String pageURL = "http://172.16.41.76/index.php?route=account/login";

    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = "#account-login > div.alert")
    private WebElement alertErrorMessage;


    public LoginPage(WebDriver driver){
        super(driver);
    }


    public void loginAs(String email, String password){
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public String getAlertErrorMessage() {
        return alertErrorMessage.getText();
    }

}

