package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPage extends Page {
    @FindBy(css = "input[name=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "input[name=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"address_1\"]")
    private WebElement address_1Field;

    @FindBy(css = "input[name=\"city\"]")
    private WebElement cityField;

    @FindBy(css = "input[name=\"postcode\"]")
    private WebElement postcodeField;

    @FindBy(css = "#input-payment-country > option")
    private List<WebElement> countriesDropDownList;

    @FindBy(css = "#input-payment-zone option")
    private List<WebElement> zonesDropDownList;

    @FindBy(css = "input[name=\"lastname\"]")
    private WebElement lastNameField;


    @FindBy(id = "button-payment-address")
    private WebElement continueButton;

    @FindBy(id = "button-shipping-address")
    private WebElement shippingAddressButton;

    @FindBy(id = "button-shipping-method")
    private WebElement shippingMethodButton;

    @FindBy(id = "button-payment-method")
    private WebElement paymentMethodButton;

    @FindBy(css = "input[value=\"Login\"]")
    private WebElement loginButton;

    @FindBy(css = "input[value=\"Confirm Order\"]")
    private WebElement confirmButton;

    @FindBy(css = "input[type=\"checkbox\"]")
    private WebElement checkBoxButton;

    private Wait wait;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,30,3000);
    }
    public void performBuy(String email, String password) {
        super.wait.toBeVisible(emailField);
        loginAs(email,password);
//        completeBillingDetails(firstName,lastName,address,city,postCode,country,region);

        super.wait.toBeVisible(continueButton);
        continueButton.click();
        super.wait.toBeVisible(shippingAddressButton);
        shippingAddressButton.click();
        super.wait.toBeVisible(shippingMethodButton);
        shippingMethodButton.click();
        super.wait.toBeVisible(paymentMethodButton);
        checkBoxButton.click();
        paymentMethodButton.click();
        super.wait.toBeVisible(confirmButton);
        confirmButton.click();

    }

    public void loginAs(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void completeBillingDetails(String firstName, String lastName, String address, String city, String postCode,
                                       String country, String region) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);

        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        address_1Field.clear();
        address_1Field.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        postcodeField.clear();
        postcodeField.sendKeys(postCode);

        for (int i = 0; i < countriesDropDownList.size(); i++) {
            if(countriesDropDownList.get(i).getText().equalsIgnoreCase(country)){
                countriesDropDownList.get(i).click();
            }

        }

        for (int i = 0; i < zonesDropDownList.size(); i++) {
            if(zonesDropDownList.get(i).getText().equalsIgnoreCase(region)){
                zonesDropDownList.get(i).click();
            }

        }

        continueButton.click();
    }


}
