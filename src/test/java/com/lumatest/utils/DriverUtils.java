package com.lumatest.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;

public class DriverUtils {
  private static final ChromeOptions chromeOptions;
  private static final FirefoxOptions firefoxOptions;
  private static final EdgeOptions edgeOptions;

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

    firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--incognito");
    firefoxOptions.addArguments("--headless");
    firefoxOptions.addArguments("--window-size=1920,1080");
    firefoxOptions.addArguments("--disable-gpu");
    firefoxOptions.addArguments("--no-sandbox");
    firefoxOptions.addArguments("--disable-dev-shm-usage");
//        firefoxOptions.addArguments("--disable-web-security");
//        firefoxOptions.addArguments("--allow-running-insecure-content");
//        firefoxOptions.addArguments("--ignore-certificate-errors");

    edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--incognito");
    edgeOptions.addArguments("--headless");
    edgeOptions.addArguments("--window-size=1920,1080");
    edgeOptions.addArguments("--disable-gpu");
    edgeOptions.addArguments("--no-sandbox");
    edgeOptions.addArguments("--disable-dev-shm-usage");
    edgeOptions.addArguments("--disable-web-security");
    edgeOptions.addArguments("--allow-running-insecure-content");
    edgeOptions.addArguments("--ignore-certificate-errors");

  }

  public static WebDriver createDriver(String browser) {
    return switch (browser.toLowerCase()) {
      case "chrome" -> new ChromeDriver(chromeOptions);
      case "firefox" -> new FirefoxDriver(firefoxOptions);
      case "safari" -> new SafariDriver();
      case "edge" -> new EdgeDriver(edgeOptions);
      default -> throw new IllegalArgumentException("Unknown browser: " + browser);
    };
  }
}
