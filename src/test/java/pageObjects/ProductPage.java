package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page {

    @FindBy(css = "#content div .col-sm-4 h1")
    private WebElement productName;

    @FindBy(css = "button#button-cart")
    private WebElement addToCartButton;

    @FindBy(css = "input[name=\"quantity\"]")
    private WebElement quantityField;

    @FindBy(css = "div.alert.alert-success")
    private WebElement successMessage;

    @FindBy(css = "button[data-original-title=\"Add to Wish List\"]")
    private WebElement addToWishListButton;

    @FindBy(css = "button[data-original-title=\"Compare this Product\"]")
    private WebElement addToCompareListButton;

    @FindBy(css = "a[href$=\"product/compare\"]")
    private WebElement comparisonListButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return productName.getText();
    }

    public void addToCart(String quantity){
        quantityField.clear();
        quantityField.sendKeys(quantity);
        addToCartButton.click();

    }

    public boolean contains(){
        super.wait.toBeVisible(cartButton);
        return (successMessage.getText().contains(productName.getText())&&
        successMessage.getText().contains("Success"));
    }

    public WebElement getSuccessMessage(){
        return successMessage;
    }

    public void addToWishList(){
        addToWishListButton.click();
    }

    public void addToCompareList(){
        addToCompareListButton.click();
    }

    public void goToComparisonList(){
        comparisonListButton.click();
    }
}
