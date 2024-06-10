package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.lumatest.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriverWait wait10;
    private String browser = "firefox";

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.chromiumdriver().setup();
//        WebDriverManager.iedriver().setup();
        Reporter.log("INFO: Setup Webdriver manager", true);
    }

//    @Parameters("browser")
//String browser
    @BeforeMethod
    protected void setupDriver() {
        Reporter.log("_________________________________________________________", true);

        this.driver = DriverUtils.createDriver(this.browser, this.driver);

        if (getDriver() == null) {
            Reporter.log("ERROR: unknown browser parameter" + browser, true);

            System.exit(1);
        }

        Reporter.log("INFO: " + this.browser.toUpperCase() + " driver created", true);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            Reporter.log("INFO: " + this.browser.toUpperCase() + " driver closed", true);

            this.driver = null;

            wait2 = null;
            wait5 = null;
            wait10 = null;

        } else {
            Reporter.log("INFO: Driver is null", true);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait2() {
        if (wait2 == null) {
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        }

        return wait2;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }
}
