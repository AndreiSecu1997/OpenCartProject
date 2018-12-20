package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class Page {
    @FindBy(css = "a > span.caret")
    WebElement myAccountDropDown;

    @FindBy(css = "a[href$=\"account/login\"]")
    private WebElement loginButton;

    @FindBy(css = "a[href$=\"account/register\"]")
    private WebElement registerPage;

    @FindBy(css = "a[title=\"Shopping Cart\"]")
    public WebElement cartButton;

    @FindBy(css = ".navbar-nav li a")
    private List<WebElement> categories;

    @FindBy(css = "a[title=\"Checkout\"]")
    private WebElement checkoutButton;

    @FindBy(css = "#wishlist-total")
    private WebElement wishListButton;

    private final WebDriver driver;
    public WaitUtil wait;
    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }


    public static String getUrlPage(String pageName, WebDriver driver) {
        try {
            Class clazz = Class.forName("pageObjects." + pageName + "Page");
            Field urlObject = clazz.getDeclaredField("pageURL");
            urlObject.setAccessible(true);
            return ( String ) urlObject.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            throw new RuntimeException("The page class or pageURL was not found");
        }
    }

    public static void accessPage(String pageName, WebDriver driver) {
        try {
            Class clazz = Class.forName("pageObjects.Page");
            Method clickOn = clazz.getDeclaredMethod("access" + pageName + "Page");
            clickOn.setAccessible(true);
            clickOn.invoke(clazz.getConstructor(WebDriver.class).newInstance(driver));
        }
        catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void accessRegisterPage() {
        myAccountDropDown.click();
        registerPage.click();
    }

    private void accessLoginPage() {
        myAccountDropDown.click();
        loginButton.click();
    }

    private void accessCartPage() {
        wait.toBeVisible(cartButton);
        cartButton.click();
    }

    private void accessCheckoutPage(){
        checkoutButton.click();
    }

    private void accessWishListPage(){
        wishListButton.click();
    }

    public void accessCategory(String categoryName) {
        for (WebElement value : categories) {
            if (value.getText().equalsIgnoreCase(categoryName)){
                value.click();
                break;
            }
        }
    }


}
