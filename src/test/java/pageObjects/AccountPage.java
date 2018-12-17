package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends Page {

    @FindBy(css = "a[href$=\"account/logout\"]")
    private List<WebElement> logoutButtons;

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getLogoutButtons(){
        return logoutButtons;
    }

    public void logOut(){
        myAccountDropDown.click();
        logoutButtons.get(0).click();
    }

}
