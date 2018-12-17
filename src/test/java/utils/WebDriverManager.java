package utils;

import dataProviders.TestDataFileReaders;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private EventFiringWebDriver eventDriver;

    public WebDriverManager() {
        new TestDataFileReaders();
        driverType = TestDataFileReaders.getBrowser();
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public void quiteDriver() {
        driver.quit();
        driver = null;
    }

    public void switchWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

}
