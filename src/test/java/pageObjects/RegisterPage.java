package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private final String pageURL = "http://172.16.41.26/index.php?route=account/register";
    private String urlSpecificText = "route=account/register";

    @FindBy(css = "input[name=\"firstname\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"lastname\"]")
    private WebElement lastNameField;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "input[name=\"telephone\"]")
    private WebElement telephoneField;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "input[name=\"confirm\"]")
    private WebElement confirmPasswordField;

    @FindBy(css = "input[name=\"agree\"]")
    private WebElement privacyPolicyCheckBox;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement continueButton;

    @FindBy(css = " div.alert.alert-danger.alert-dismissible")
    private WebElement alertErrorMessage;

    @FindBy(css = "div.form-group.required.has-error > div > div")
    private WebElement passwordDoesNotMatchError;



    private String generateEmail(String email) {
        if (email.equalsIgnoreCase("Random"))
            return Integer.toString(( int ) (Math.random() * 10000)) + "email@email.com";
        else return email;
    }

    public void registerAs(String firstName, String lastName, String email,
                           String telephone, String password, String policy) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(generateEmail(email));
        telephoneField.sendKeys(telephone);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        if (policy.equalsIgnoreCase("true")) privacyPolicyCheckBox.click();
        continueButton.click();
    }

    public void registerAs(String firstName, String lastName, String email,
                           String telephone, String password, String confirm, String policy) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(generateEmail(email));
        telephoneField.sendKeys(telephone);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirm);
        if (policy.equalsIgnoreCase("true")) privacyPolicyCheckBox.click();
        continueButton.click();
    }

    public String getPolicyErrorMessage(){
        return alertErrorMessage.getText();
    }

    public String getPasswordMatchingErrorMessage(){
        return passwordDoesNotMatchError.getText();
    }

}
