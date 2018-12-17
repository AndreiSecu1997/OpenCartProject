package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReaders;
import org.junit.Assert;
import pageObjects.LoginPage;
import runTimeUtils.TestContext;

public class LoginPageSteps {

    private TestContext testContext;
    private LoginPage loginPage;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = new LoginPage(testContext.getWebDriverManager().getDriver());
    }

    @And("^perform login process using valid credentials$")
    public void performLoginProcessUsingValidCredentials() {
        loginPage.loginAs(TestDataFileReaders.getEmail("FirstUserEmail"), TestDataFileReaders.getPassword("FirstUserPassword"));
    }

    @And("^perform login process using invalid \"([^\"]*)\"$")
    public void performLoginProcessUsingInvalid(String key) {
        loginPage.loginAs(TestDataFileReaders.getEmail(key), TestDataFileReaders.getPassword("FirstUserPassword"));
    }

    @Then("^on the screen appears an error message$")
    public void onTheScreenAppearsAnErrorMessage() {
        try {
            Assert.assertNotNull(loginPage.getAlertErrorMessage());
        } catch (AssertionError e) {
            throw new RuntimeException("No such error message on the screen");
        }

    }
}
