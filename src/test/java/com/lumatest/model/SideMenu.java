package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class SideMenu extends BreadcrumbsMenu {

  @FindBy(css = "ol[class='items'] a[href*='bags']")
  private WebElement bagsSideMenu;

  protected SideMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Click on Bags in side menu")
  public CatalogPage clickBagsSideMenu() {
    getWait().until(ExpectedConditions.elementToBeClickable(bagsSideMenu)).click();

    return new CatalogPage(getDriver());
  }
}
