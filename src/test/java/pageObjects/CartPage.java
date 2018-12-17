package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends Page {
    @FindBy(css = ".table-bordered > tbody > tr> td:nth-child(2).text-left")
    private List<WebElement> productsName;

    @FindBy(css = "input[size=\"1\"]")
    private List<WebElement> productsQuantity;

    @FindBy(css = "span .btn-danger")
    private List<WebElement> removeButtons;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantity(String productName) {
        if (productsName != null) {
            Map<String, String> storedCorespondence = new HashMap<>();
            for (WebElement value : productsName) {
            }
            for (int i = 0; i < productsName.size(); i++) {
                storedCorespondence.put(productsName.get(i).getText().split(" ")[0], productsQuantity.get(i).getAttribute("value"));
            }
            return storedCorespondence.get(productName.split(" ")[0]);

        }
        return "No products in the cart!";
    }

    public void removeProduct(String productName) {
        if (productsName.size() != 0) {
            Map<String, WebElement> storedCorespondence = new HashMap<>();
            for(WebElement value : productsName) {
            }
            for (int i = 0; i < productsName.size(); i++) {
                storedCorespondence.put(productsName.get(i).getText().split(" ")[0], removeButtons.get(i));
            }
            storedCorespondence.get(productName.split(" ")[0]).click();
        }
        else throw new AssertionError("No products in the cart!");
    }
}
