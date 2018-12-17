package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.Page;
import pageObjects.ProductPage;
import runTimeUtils.TestContext;

public class ProductPageSteps {
    private TestContext testContext;
    private ProductPage productPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productPage = new ProductPage(testContext.getWebDriverManager().getDriver());

    }

    @Then("^\"([^\"]*)\" product page is displayed$")
    public void productPageIsDisplayed(String productName) {
        Assert.assertEquals(productName, productPage.getProductName());

    }

    @When("^user adds \"([^\"]*)\" units to cart$")
    public void userAddsUnitsToCart(String quantity) {
        productPage.addToCart(quantity);


    }

    @Then("^an success message appears on the screen$")
    public void anSuccessMessageAppearsOnTheScreen() {
        try {
            testContext.getWaitUtil().toBeVisible(productPage.getSuccessMessage());
            Assert.assertTrue(productPage.contains());
        } catch (AssertionError e) {
            throw new AssertionError("The success meesage is not correct or it does not appear on the screen");
        }
    }

    @When("^user clicks on AddToWishList button$")
    public void userClicksOnAddToWishListButton() {
        productPage.addToWishList();

    }

    @Then("^on the page is displayed a success message$")
    public void onThePageIsDisplayedASuccessMessage() {
        try{
            testContext.getWaitUtil().toBeVisible(productPage.getSuccessMessage());

            Assert.assertTrue(productPage.getSuccessMessage().getText().contains("You must login or create an account"));
        }catch (AssertionError e){
            throw new AssertionError("The success message is not displayed");
        }
    }

    @When("^user clicks on Compare button$")
    public void userClicksOnCompareButton() {
        productPage.addToCompareList();
        testContext.getWaitUtil().toBeVisible(productPage.getSuccessMessage());
        productPage.goToComparisonList();
    }
}
