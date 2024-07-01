package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerLoginPage extends Login<CustomerLoginPage>{

  @FindBy(css = "button[class*=primary]")
  private WebElement signInButton;
  protected CustomerLoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("Click on Sign In button")
  public HomePage clickSignInButton() {
    getWait().until(ExpectedConditions.elementToBeClickable(signInButton)).click();

    return new HomePage(getDriver());
  }
}
