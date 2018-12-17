package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.CheckoutSuccessPage;
import runTimeUtils.TestContext;

public class CheckoutPageSteps {
    private TestContext testContext;
    private CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context){
        testContext = context;
        checkoutPage = new CheckoutPage(testContext.getWebDriverManager().getDriver());
    }
    @When("^perform buy using the following details:\"([^\"]*)\",\"([^\"]*)\"$")
    public void performBuyUsingTheFollowingDetails(String email, String pass) {
        checkoutPage.performBuy(email,pass);

    }
}
