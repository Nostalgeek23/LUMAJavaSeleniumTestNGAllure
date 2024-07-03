package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class ProductPage extends CatalogPage {

  @FindBy(css = "h1 > span")
  WebElement productName;

  @FindBy(id = "product-addtocart-button")
  WebElement addToCartButton;

  @FindBy(css = "div[class*='info-price'] span[class='price']")
  private WebElement productPrice;

  @FindBy(css = "div[class*='description']")
  private WebElement productDescription;

  @FindBy(css = "div[title='Availability']")
  private WebElement productAvailability;

  @FindBy(css = "div[itemprop='sku']")
  private WebElement productSKU;

  @FindBy(css = "div[class='page messages'] div[data-bind*='html']")
  private WebElement productAlertMessage;

  @FindBy(css = "a[class='action tocompare']")
  private WebElement addToCompareButton;

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

  @Step("Get price from Product Page")
  public String getProductPrice() {
    getWait().until(ExpectedConditions.elementToBeClickable(productPrice));

    return productPrice.getText();
  }

  @Step("Get description of product")
  public String getProductDescription() {
    getWait().until(ExpectedConditions.elementToBeClickable(productDescription));

    return productDescription.getText();
  }

  @Step("Get availability of product")
  public String getProductAvailability() {
    getWait().until(ExpectedConditions.elementToBeClickable(productAvailability));

    if (productAvailability.getText().equals("IN STOCK")) {
      Reporter.log("Product is in stock", true);
      return productAvailability.getText();
    } else if (productAvailability.getText().equals("OUT OF STOCK")) {
      Reporter.log("Product is out of stock", true);
      return productAvailability.getText();
    } else {
      return "Unknown product stock";
    }
  }

  @Step("Get product SKU or ID")
  public String getProductSKU() {
    getWait().until(ExpectedConditions.elementToBeClickable(productSKU));

    return productSKU.getText();
  }

  @Step("Get text from alert message on product page")
  public String getAlertMessage() {
    getWait().until(ExpectedConditions.visibilityOf(productAlertMessage));

    return productAlertMessage.getText();
  }

  @Step("Click on Add to Compare button")
  public ProductPage clickAddToCompare() {
    try {
      getWait().until(ExpectedConditions.elementToBeClickable(addToCompareButton)).click();
    } catch (Exception e) {
      Reporter.log("Click Element using fallback method: " + addToCompareButton, true);
      clickWithJS(addToCompareButton);
    }

    return this;
  }
}
