package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.WishListPage;
import runTimeUtils.TestContext;
import utils.WebDriverManager;

public class WishListPageSteps {
    private TestContext testContext;
    private WishListPage wishListPage;

    public WishListPageSteps(TestContext context){
        testContext = context;
        wishListPage = new WishListPage(context.getWebDriverManager().getDriver());
    }


    @Then("^the \"([^\"]*)\" product is added to Wish List$")
    public void theProductIsAddedToWishList(String productName) {
        try {
            Assert.assertTrue(wishListPage.productIsPresent(productName));
            wishListPage.removeProduct(productName);
        }catch (AssertionError e){
            throw new AssertionError("The product is not added to wish list");
        }
    }

}
