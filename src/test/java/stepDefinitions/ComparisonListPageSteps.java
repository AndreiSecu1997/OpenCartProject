package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.ComparisonPage;
import runTimeUtils.TestContext;

public class ComparisonListPageSteps {
    private TestContext testContext;
    private ComparisonPage comparisonPage;

    public ComparisonListPageSteps(TestContext context){
        testContext = context;
        comparisonPage = new ComparisonPage(context.getWebDriverManager().getDriver());
    }
    @Then("^the \"([^\"]*)\" product is added to Comparison List$")
    public void theProductIsAddedToComparisonList(String productName) {
        try{
            Assert.assertTrue(comparisonPage.containsProduct(productName));
            comparisonPage.removeItem(productName);
        }catch (AssertionError e){
            throw new AssertionError("The product was not added to comparison list");
        }

    }
}
