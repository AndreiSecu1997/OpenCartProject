package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.CartPage;
import runTimeUtils.TestContext;

public class CartPageSteps {
    private String pageURL = "http://172.16.41.26/index.php?route=checkout/cart";
    private CartPage cartPage;
    private TestContext testContext;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = new CartPage(testContext.getWebDriverManager().getDriver());
    }

    @Then("^\"([^\"]*)\" units of \"([^\"]*)\" were added to cart$")
    public void unitsOfWereAddedToCart(String quantity, String productName) {
        Assert.assertEquals(quantity, cartPage.getQuantity(productName));
        cartPage.removeProduct(productName);
    }

    @Then("^\"([^\"]*)\" product is not found on Category page$")
    public void productIsNotFoundOnCategoryPage(String productName) {
        try {
            Assert.assertNull(cartPage.getQuantity(productName));
        } catch (AssertionError e) {
            cartPage.removeProduct(productName);
            throw new AssertionError("The product was added to cart");
        }

    }
}
