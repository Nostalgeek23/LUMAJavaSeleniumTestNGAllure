package com.lumatest.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;

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
        if (driver != null) {
            System.out.println("Driver quit");
            driver.quit();
        }
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand(
                "Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9"))
        );

        System.out.println("Chromedriver create");
        return chromeDriver ;
    }


}
