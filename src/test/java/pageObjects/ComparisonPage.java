package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparisonPage extends Page {

    @FindBy(css = "a[href*=\"product/product&product\"]")
    private List<WebElement> productsName;

    @FindBy(css = "a[href*=\"product/compare&remove\"]")
    private List<WebElement> removeButtons;

    Map<String,WebElement> correspondenceMap = new HashMap<>();

    public ComparisonPage(WebDriver driver){
        super(driver);
    }

    public boolean containsProduct(String productName){
        if(productsName == null) return false;
        for (WebElement value : productsName){
            if(value.getText().equalsIgnoreCase(productName)){
                return true;
            }
        } return false;
    }

    public void removeItem(String productName){
        if(productsName != null){
            for (int i = 0 ; i < productsName.size() ; i++ ){
                correspondenceMap.put(productsName.get(i).getText(),removeButtons.get(i));
            }
            correspondenceMap.get(productName).click();
        }
    }
}
