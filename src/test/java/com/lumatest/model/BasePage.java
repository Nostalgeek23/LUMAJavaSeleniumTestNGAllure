package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
  private final WebDriver driver;
  private WebDriverWait wait;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  public WebDriverWait getWait() {
    if (wait == null) {
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    return wait;
  }

  @Step("Hover on element")
//    public void hoverOverElementBy(By selector) {
//        WebElement element = getDriver().findElement(selector);
//
//        new Actions(getDriver())
//                .moveToElement(element)
//                .perform();
//    }
  public void hoverOverElement(WebElement element) {
    new Actions(getDriver())
            .moveToElement(element)
            .perform();
  }

  @Step("Get page title with URL provided")
  public String getPageTitleWithURL(String url) {
    getWait().until(ExpectedConditions.urlToBe(url));

    return getDriver().getTitle();
  }

  @Step("Get page title")
  public String getPageTitle() {
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

    return getDriver().getTitle();
  }

  public String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }
}
