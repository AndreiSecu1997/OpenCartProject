package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.RegisterPage;
import runTimeUtils.TestContext;

public class RegisterPageSteps {
    private TestContext testContext;
    private RegisterPage registerPage;

    public RegisterPageSteps(TestContext context) {
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());
    }



    @When("^perform register process using valid details:\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void performRegisterProcessUsingValidDetails(String firstName, String lastName, String email,
                                                        String telephone, String password, String policy ){
        registerPage.registerAs(firstName,lastName,email,telephone,password,policy);

    }

    @When("^perform register process using valid details:\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void performRegisterProcessUsingValidDetails2(String firstName, String lastName, String email,
                                                        String telephone, String password,String confirm, String policy ){
        registerPage.registerAs(firstName,lastName,email,telephone,password,confirm,policy);
    }



    @Then("^an error message regarding Privacy Policy is displayed on the screen$")
    public void anErrorMessageRegardingPrivacyPolicyIsDisplayedOnTheScreen() {
        Assert.assertEquals(registerPage.getPolicyErrorMessage(),"Warning: You must agree to the Privacy Policy!");
    }

    @Then("^an error message regarding Password does not match is displayed on the screen$")
    public void anErrorMessageRegardingPasswordDoesNotMatchIsDisplayedOnTheScreen() {
       Assert.assertEquals(registerPage.getPasswordMatchingErrorMessage(),"Password confirmation does not match password!");
    }
}
