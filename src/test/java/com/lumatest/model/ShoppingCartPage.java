package com.lumatest.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends TopMenu {

  @FindBy(css = "td strong > a")
  private WebElement itemInCartName;

  protected ShoppingCartPage(WebDriver driver) {
    super(driver);
  }

  public String getItemInCartName() {
    getWait().until(ExpectedConditions.elementToBeClickable(itemInCartName));

    return itemInCartName.getText();
  }
}
