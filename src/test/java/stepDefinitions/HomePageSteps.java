package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import runTimeUtils.TestContext;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }

    @When("^user cliks on \"([^\"]*)\" product from Featured$")
    public void userCliksOnProductFromFeatured(String productName) {
        homePage.accessFeaturedProduct(productName);


    }

    @When("^user cliks on \"([^\"]*)\" product from Slider$")
    public void userCliksOnProductFromSlider(String productName) {
        homePage.accessSliderProduct(productName);
    }
}
