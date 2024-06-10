package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.lumatest.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait2;

    private WebDriverWait wait5;

    private WebDriverWait wait10;

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        System.out.println("Setup Webdriver manager");
    }

    @BeforeMethod
    protected void setupDriver() {
        this.driver = DriverUtils.createChromeDriver(getDriver());
        System.out.println("Setup driver");
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            this.driver = null;

            wait2 = null;
            wait5 = null;
            wait10 = null;

            System.out.println("Webdriver quit");
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
