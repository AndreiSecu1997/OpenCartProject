package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends Page {

    @FindBy(css = "#content h2")
    private WebElement categoryTitle;

    @FindBy(css = ".caption h4 a")
    private List<WebElement> products;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToProduct(String productName) {
        for (WebElement value : products) {
            if (value.getText().equalsIgnoreCase(productName)) {
                value.click();
                break;
            }
        }
    }

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }
}
