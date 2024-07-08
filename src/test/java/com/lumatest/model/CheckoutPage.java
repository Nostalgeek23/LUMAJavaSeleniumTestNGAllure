package com.lumatest.model;

import com.lumatest.data.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends ShoppingCartPage{
  protected CheckoutPage(WebDriver driver) {
    super(driver);
  }

  @Step("Wait for open Checkout page and get URL")
  @Override
  public String getUrl() {

      getWait().until(ExpectedConditions.or(
              ExpectedConditions.urlToBe(TestData.CHECKOUT_URL),
              ExpectedConditions.urlToBe(TestData.CHECKOUT_FIREFOX_URL)));

    return getDriver().getCurrentUrl();
  }
}
