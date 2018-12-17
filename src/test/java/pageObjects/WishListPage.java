package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WishListPage extends Page {

    @FindBy(css = "tbody > tr > td:nth-child(2)")
    private List<WebElement> productsName;

    @FindBy(css = "a.btn.btn-danger")
    private List<WebElement> removeButtons;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    Map<String, WebElement> corespondenceList = new HashMap<>();

    private void createCorrespondence() {
    if (productsName.size()==0)return;
        for (int i = 0; i < productsName.size() ; i++){
            corespondenceList.put(productsName.get(i).getText(),removeButtons.get(i));
        }
    }

    public boolean productIsPresent(String productName){
        super.wait.toBeVisible(productsName.get(0));
        for (WebElement value : productsName){
            if(value.getText().equalsIgnoreCase(productName)){
                return true;
            }
            return false;
        }
        throw new AssertionError("The current object list doesn't contain any elements");
    }

    public void removeProduct(String productName){
        createCorrespondence();
        corespondenceList.get(productName).click();
    }


}
