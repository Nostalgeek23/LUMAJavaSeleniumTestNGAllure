package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

abstract class BreadcrumbsMenu extends TopMenu {

  @FindBy(css = "ul[class='items']")
  private WebElement breadcrumbsMenu;

  @FindBy(css = "ul[class='items'] > li")
  private List<WebElement> breadcrumbsList;

  @FindBy(css = "ul[class='items'] li:nth-child(1) a")
  private WebElement breadcrumbsHome;

  @FindBy(css = "ul[class='items'] li:nth-child(2) a")
  private WebElement breadcrumbsCategory;

  @FindBy(css = "ul[class='items'] li:nth-child(3) a")
  private WebElement breadcrumbsSubCategory;

  protected BreadcrumbsMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Collect List of breadcrumbs items")
  public List<String> getBreadcrumbsMenuText() {
    getWait().until(ExpectedConditions.visibilityOf(breadcrumbsMenu));

    return breadcrumbsList
            .stream()
            .map(WebElement::getText)
            .toList();
  }

  @Step("Click on category in breadcrumbs")
  public HomePage clickBreadcrumbsHome() {
    getWait().until(ExpectedConditions.elementToBeClickable(breadcrumbsHome)).click();

    return new HomePage(getDriver());
  }

  @Step("Click on category in breadcrumbs")
  public CategoryPage clickBreadcrumbsCategory() {
    getWait().until(ExpectedConditions.elementToBeClickable(breadcrumbsCategory)).click();

    return new CategoryPage(getDriver());
  }

  @Step("Click on category in breadcrumbs")
  public CatalogPage clickBreadcrumbsSubCategory() {
    getWait().until(ExpectedConditions.elementToBeClickable(breadcrumbsSubCategory)).click();

    return new CatalogPage(getDriver());
  }

  @Step("Get category name from breadcrumbs")
  public String getBreadcrumbsCategoryName() {
    getWait().until(ExpectedConditions.elementToBeClickable(breadcrumbsCategory));

    return breadcrumbsCategory.getText();
  }

  @Step("Get subcategory name from breadcrumbs")
  public String getBreadcrumbsSubCategoryName() {
    getWait().until(ExpectedConditions.elementToBeClickable(breadcrumbsSubCategory));

    return breadcrumbsSubCategory.getText();
  }
}
