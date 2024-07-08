package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.Login;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test(
          groups = {"login"},
          description = "TC-01.06.01: Verify Navigation to Create Account page after click on create account link",
          testName = "Login: Verify Navigation to Create Account page after click on create account link"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Description("Ensure that Create Account page opens after clicking on the Create an Account button on top of the page.")
  @Link(TestData.CREATE_ACCOUNT_URL)
  public void testNavToCreateAccountPage() {

    String createAccountURL = new HomePage(getDriver())
            .clickCreateAccountLink()
            .getUrl();

    Allure.step("Verify URL after click on create account");
    Assert.assertEquals(createAccountURL, TestData.CREATE_ACCOUNT_URL);
  }

  @Test(
          groups = {"login"},
          dataProviderClass = TestData.class,
          dataProvider = "loginData",
          description = "TC-01.06.02: Verify Navigation to Account page after account creation",
          testName = "Login: Verify Navigation to Account page after account creation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Description("Ensure that Account page opens after clicking on the Create an Account button on Create Account page.")
  @Link(TestData.ACCOUNT_URL)
  public void testNavToAccPageByCreateAcc(String firstName, String lastName, String email, String password) {

    Login<?> resultPage = new HomePage(getDriver())
            .clickCreateAccountLink()
            .typeFirstName(firstName)
            .typeLastName(lastName)
            .typeEmail(email)
            .typePassword(password)
            .typeConfirmPassword(password)
            .clickAccountSubmitButton();

    resultPage.verifyAccountCreation();
  }

  @Test(
          groups = {"login"},
          description = "TC-01.06.03: Verify Navigation to Customer Login page after click on Sign In link",
          testName = "Login: Verify Navigation to Customer Login page after click on Sign In link"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Description("Ensure that Login page opens after clicking on the Sign In button on top of the page.")
  @Link(TestData.CUSTOMER_LOGIN_URL)
  public void testNavToLoginPage() {

    String loginURL = new HomePage(getDriver())
            .clickSignInLink()
            .getUrl();

    Allure.step("Verify URL after click on Sign In");
    Assert.assertTrue(loginURL.contains(TestData.CUSTOMER_LOGIN_URL));
  }

  @Test(
          dependsOnMethods = "testNavToAccPageByCreateAcc",
          groups = {"login"},
          dataProviderClass = TestData.class,
          dataProvider = "loginData",
          description = "TC-01.06.04: Verify Navigation to Account page after login",
          testName = "Login: Verify Navigation to Account page after login"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Description("Ensure that Account page opens after clicking on the Create an Account button on Create Account page.")
  @Link(TestData.ACCOUNT_URL)
  public void testRedirectToHomeAfterLogin(String firstName, String lastName, String email, String password) {

    String headerMessage = new HomePage(getDriver())
            .clickSignInLink()
            .typeEmail(email)
            .typePassword(password)
            .clickSignInButton()
            .getHeaderLoggedInMessage();

    System.out.println(headerMessage);

    Allure.step("Verify header message after logged in");
    Assert.assertTrue(headerMessage.contains("Welcome,"));
  }
}
