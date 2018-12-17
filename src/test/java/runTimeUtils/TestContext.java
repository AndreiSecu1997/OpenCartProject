package runTimeUtils;

import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;
import utils.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private WaitUtil waitUtil;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        waitUtil = new WaitUtil(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public WaitUtil getWaitUtil() {
        return waitUtil;
    }
}
