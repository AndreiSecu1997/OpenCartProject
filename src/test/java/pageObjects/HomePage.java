package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.picocontainer.lifecycle.LifecycleState;
import utils.WebDriverManager;

import java.util.List;

public class HomePage extends Page {
    @FindBy(css = ".caption h4 a")
    private List<WebElement> featureProducts;

    @FindBy(css = "#slideshow0 > div > div.swiper-slide> a > img")
    private List<WebElement> sliderProducts;

    private final String pageURL = "http://172.16.41.76";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void accessFeaturedProduct(String productName){
        for (WebElement value : featureProducts){
            if(value.getText().equalsIgnoreCase(productName)){
                value.click();
                break;
            }
        }
    }

    public void accessSliderProduct(String productName){
       boolean counter = false;
        for (WebElement value : sliderProducts){
            System.out.println(value.getAttribute("alt"));
            if(value.getAttribute("alt").equalsIgnoreCase(productName)){
                    value.click();
                    counter = true;
                    break;
            }
        }
        if(!counter) System.out.println("The product can not be accesed!");
        Assert.assertTrue(counter);
    }
}
