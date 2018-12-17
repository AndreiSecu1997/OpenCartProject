package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.TestDataFileReaders;
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;
import pageObjects.Page;
import runTimeUtils.TestContext;

public class GeneralSteps {
    private TestContext testContext;
    private Page page;


    public GeneralSteps(TestContext context){
        testContext = context;
        page = new Page(testContext.getWebDriverManager().getDriver());
    }

    @Given("^user is on \"([^\"]*)\" page$")
    public void userIsOnPage(String pageName)  {
        testContext.getWebDriverManager().getDriver().get(Page.getUrlPage(pageName,testContext.getWebDriverManager().getDriver()));
    }

    @When("^user access the \"([^\"]*)\" Page$")
    public void userAccessThePage(String pageName){
        Page.accessPage(pageName,testContext.getWebDriverManager().getDriver());

    }

    @Then("^user is on the \"([^\"]*)\" page$")
    public void userRemainsOnThePage(String pageName) {
        try{
            Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains("/" + pageName.toLowerCase()));
        }catch (AssertionError e){
            throw new RuntimeException("The user is not on " + pageName + " page!!! ");
        }

    }

    @When("^user clicks on \"([^\"]*)\" category$")
    public void userClicksOnCategory(String categoryName) throws InterruptedException {
        page.accessCategory(categoryName);

    }
}
