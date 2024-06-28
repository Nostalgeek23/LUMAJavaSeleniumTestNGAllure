package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class TopMenu extends BasePage {
  @FindBy(css = "a.logo")
  private WebElement logo;

  @FindBy(id = "ui-id-6")
  private WebElement gearTopMenu;

  @FindBy(id = "search")
  private WebElement searchInput;

  protected TopMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Click on logo")
  public HomePage clickOnLogo() {
    getWait().until(ExpectedConditions.elementToBeClickable(logo)).click();

    return new HomePage(getDriver());
  }

  @Step("Click on Gear in the top menu")
  public GearPage clickGearTopMenu() {
    getWait().until(ExpectedConditions.elementToBeClickable(gearTopMenu)).click();

    return new GearPage(getDriver());
  }

  @Step("Click '{productName}' Img.")
  public ProductPage clickProductImg(String productName) {
    final String productNameLocator = "img[alt*='";
    String imgLocator = productNameLocator + productName + "']";
    getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(imgLocator))))
            .click();

    return new ProductPage(getDriver());
  }

  @Step("Click on subcategory menu")
  public CatalogPage clickSubcategory(By navBarMenu, By subNavMenu) {
    getWait().until(ExpectedConditions.elementToBeClickable(navBarMenu));
    WebElement element = getDriver().findElement(navBarMenu);
    hoverOverElement(element);

    getWait().until(ExpectedConditions.elementToBeClickable(subNavMenu)).click();

    return new CatalogPage(getDriver());
  }

  @Step("Search product '{productName}'")
  public SearchResultsPage searchProduct(String productName) {
    getWait().until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(productName + Keys.ENTER);

    return new SearchResultsPage(getDriver());
  }
}
