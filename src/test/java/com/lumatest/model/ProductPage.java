package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends CatalogPage {

  @FindBy(css = "h1 > span")
  WebElement productName;

  @FindBy(id = "product-addtocart-button")
  WebElement addToCartButton;

  protected ProductPage(WebDriver driver) {
    super(driver);
  }

  @Step("Collect actual product name text")
  public String getProductName() {
    return productName.getText();
  }

  @Step("Add product to cart")
  public ProductPage clickOnAddToCart() {
    getWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    getWait().until(ExpectedConditions.elementToBeClickable(addToCartSuccessMessage));

    return this;
  }
}
