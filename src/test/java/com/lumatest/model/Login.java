package com.lumatest.model;

import com.lumatest.data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

  private boolean isOnMyAccountPage() {
    return getCurrentUrl().equals(TestData.ACCOUNT_URL);
  }

  @Step("Click on button to login or create account")
  public Login<?> clickAccountSubmitButton() {
    accountSubmitButton.click();

    if (isOnMyAccountPage()) {
      return new MyAccountPage(getDriver());
    } else {
      return new CreateAccountPage(getDriver());
    }
  }

  @Step("Check URL is '{accountURL}'")
  public boolean isAccountCreated() {
    return getCurrentUrl().equals(TestData.ACCOUNT_URL);
  }

  public void verifyAccountCreation() {
    if (this instanceof MyAccountPage) {
      Allure.step("Verify URL after create account");
      Assert.assertTrue(isAccountCreated());
    } else if (this instanceof CreateAccountPage createAccountPage) {
      String errorMessage = createAccountPage.getErrorMessageText();

      Allure.step("Verify email already registered");
      Assert.assertTrue(errorMessage.contains(TestData.EMAIL_ERROR_MESSAGE));
    } else {
      throw new IllegalStateException("Unexpected page type: " + this.getClass().getName());
    }
  }
}
