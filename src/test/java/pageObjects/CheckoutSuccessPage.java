package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccessPage extends Page {

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;

    public CheckoutSuccessPage(WebDriver driver){
        super(driver);
    }

    public WebElement getContinueButton() {
        return continueButton;
    }



}
