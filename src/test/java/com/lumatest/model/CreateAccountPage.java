package com.lumatest.model;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends Login<CreateAccountPage>{

  @FindBy(id = "firstname")
  private WebElement firstNameInputField;

  @FindBy(id = "lastname")
  private WebElement lastNameInputField;

  @FindBy(id = "password-confirmation")
  private WebElement confirmPasswordField;

  @FindBy(css = "[data-ui-id='message-error']>div")
  private WebElement errorMessage;
  protected CreateAccountPage(WebDriver driver) {
    super(driver);
  }

  @Step("Type first name in First Name field")
  public CreateAccountPage typeFirstName(String firstName) {
    getWait().until(ExpectedConditions.visibilityOf(firstNameInputField));
    firstNameInputField.sendKeys(firstName);

    return this;
  }

  @Step("Type last name in Last Name field")
  public CreateAccountPage typeLastName(String lastName) {
    lastNameInputField.sendKeys(lastName);

    return this;
  }

  @Step("Type password in Confirm Password field")
  public CreateAccountPage typeConfirmPassword(String password) {
    confirmPasswordField.sendKeys(password);

    return this;
  }

  @Step("Get text from error message if account cannot be created")
  public String getErrorMessageText() {
    getWait().until(ExpectedConditions.visibilityOf(errorMessage));
    return errorMessage.getText();
  }

}
