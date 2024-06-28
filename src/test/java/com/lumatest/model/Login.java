package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public  class Login<T extends Login<T>> extends TopMenu{

  @FindBy(css = "[title = Email]")
  private WebElement emailInputField;

  @FindBy(css = "input[title*='Pass']")
  private WebElement passwordInputField;

  @FindBy(css = "button[class*=primary]")
  private WebElement accountSubmitButton;



  protected Login(WebDriver driver) {
    super(driver);
  }

  @Step("Type email in Email field")
  public T typeEmail(String email) {
    getWait().until(ExpectedConditions.visibilityOf(emailInputField));
    emailInputField.sendKeys(email);

    return (T) this;
  }

  @Step("Type password in Password field")

  public T typePassword(String password) {
    passwordInputField.sendKeys(password);

    return (T) this;
  }

  @Step("Click on button to login or create account")
  public T clickAccountSubmitButton() {
    accountSubmitButton.click();

    return (T) this;
  }

  @Step("Check URL is '{accountURL}'")
  public boolean isAccountCreated(String accountURL) {
    return getCurrentUrl().equals(accountURL);
  }
}
