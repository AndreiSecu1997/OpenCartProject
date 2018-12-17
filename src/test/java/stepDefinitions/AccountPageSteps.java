package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.TestDataFileReaders;
import org.junit.Assert;
import pageObjects.AccountPage;
import runTimeUtils.TestContext;

public class AccountPageSteps {
    private TestContext testContext;
    private AccountPage accountPage;

    public AccountPageSteps(TestContext context) {
        testContext = context;
        accountPage = new AccountPage(testContext.getWebDriverManager().getDriver());
    }


    @Then("^user is on user's account page$")
    public void userIsOnUserSAccountPage() {
        try {
            Assert.assertNotNull(accountPage.getLogoutButtons().get(0));
        } catch (AssertionError e) {
            throw new AssertionError("The user is not logged in, no logout options are displayed");
        }
    }

    @When("^user logs out from the system$")
    public void userLogsOutFromTheSystem() {
        accountPage.logOut();
    }
}
