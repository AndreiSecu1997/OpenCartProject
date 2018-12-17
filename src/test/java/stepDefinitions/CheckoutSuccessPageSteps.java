package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.CheckoutSuccessPage;
import runTimeUtils.TestContext;

public class CheckoutSuccessPageSteps {
    private TestContext testContext;
    private CheckoutSuccessPage checkoutSuccessPage;

    public CheckoutSuccessPageSteps(TestContext context){
        testContext = context;
        checkoutSuccessPage = new CheckoutSuccessPage(testContext.getWebDriverManager().getDriver());
    }

    @Then("^checkout is done successfully$")
    public void checkoutIsDoneSuccessfully() {
       try {
           testContext.getWaitUtil().toBeVisible(checkoutSuccessPage.getContinueButton());
           Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains("e=checkout/success"));
       }catch (AssertionError e){
           throw new AssertionError("The user is not on the correct page");
       }

    }
}
