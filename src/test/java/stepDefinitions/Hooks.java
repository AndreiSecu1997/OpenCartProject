package stepDefinitions;

import org.junit.AfterClass;
import runTimeUtils.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.WebDriverManager;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext context){
        testContext = context;

    }

    @After
    public void finish(){
        testContext.getWebDriverManager().quiteDriver();
    }

}
