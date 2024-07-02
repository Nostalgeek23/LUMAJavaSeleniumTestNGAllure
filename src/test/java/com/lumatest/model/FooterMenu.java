package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterMenu extends BasePage {
  protected FooterMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Click link in footer")
  public FooterMenu clickFooterLink(By footerLink) {
    getWait().until(ExpectedConditions.visibilityOfElementLocated(footerLink)).click();

    return new FooterMenu(getDriver());
  }
}
