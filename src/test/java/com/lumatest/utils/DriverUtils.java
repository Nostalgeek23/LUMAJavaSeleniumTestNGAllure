package com.lumatest.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {
    private static ChromeOptions chromeOptions;

    static {
        chromeOptions = new ChromeOptions();

        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore-certificate-errors");
    }

    public static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            System.out.println("WebDriver session created");
            return new ChromeDriver(chromeOptions);
        } else {
            driver.quit();
            return new ChromeDriver(chromeOptions);
        }
    }
}
