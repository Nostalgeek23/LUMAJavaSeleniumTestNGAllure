package com.lumatest.base;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait2;

    private WebDriverWait wait5;

    private WebDriverWait wait10;

    @BeforeMethod
    protected void setup() {
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        createChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            this.driver = null;
            System.out.println("Webdriver quit");
        }
    }

   private void createChromeDriver() {
        if (this.driver == null) {
            this.driver = new ChromeDriver();
            System.out.println("WebDriver session created");
        }
    }

//   private synchronized void createChromeDriver() {
//       if (this.driver == null) {
//           ChromeOptions options = new ChromeOptions();
//           options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//           this.driver = new ChromeDriver(options);
//           System.out.println("WebDriver session created");
//       }
//   }

    public WebDriver getDriver() {
        return driver;
    }

//   public synchronized WebDriver getDriver() {
//       if (this.driver == null) {
//           throw new IllegalStateException("WebDriver has been quit and cannot be used anymore.");
//       }
//       return driver;
//   }

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
