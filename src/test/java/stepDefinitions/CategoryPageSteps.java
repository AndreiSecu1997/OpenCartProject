package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.CategoryPage;
import runTimeUtils.TestContext;

public class CategoryPageSteps {
    private TestContext testContext;
    private CategoryPage categoryPage;

    public CategoryPageSteps(TestContext context){
        testContext = context;
        categoryPage = new CategoryPage(testContext.getWebDriverManager().getDriver());

    }
    @Then("^\"([^\"]*)\" category page is displayed$")
    public void categoryPageIsDisplayed(String categoryName) {
        Assert.assertEquals(categoryName,categoryPage.getCategoryTitle());
    }

    @When("^user cliks on \"([^\"]*)\" product$")
    public void userCliksOnProduct(String productName) {
        categoryPage.navigateToProduct(productName);
    }
}
