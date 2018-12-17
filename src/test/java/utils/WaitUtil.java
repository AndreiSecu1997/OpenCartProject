package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        wait = new WebDriverWait(driver, 30, 2000);
    }

    public WebDriverWait getWait(){
        return wait;
    }

    public void toBeClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void  toBeVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
