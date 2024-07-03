package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.Login;
import com.lumatest.model.ProductPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

  @Test(
          groups = {"regression"},
          description = "TC-01.00 Open base URL",
          testName = "Navigation: open base URL"
  )
  @Severity(SeverityLevel.BLOCKER)
  @Story("Navigation")
  @Description("Verify user can open base url (home page)")
  @Link(TestData.BASE_URL)
  public void testOpenBaseURL() {
    Allure.step("Set up expected results");
    final String expectedURL = TestData.BASE_URL + "/";
    final String expectedTitle = TestData.BASE_URL_TITLE;

    Allure.step("Collect actual results");
    final String actualURL = getDriver().getCurrentUrl();
    final String actualTitle = getDriver().getTitle();

    Allure.step("Verify actual results as expected");
    Assert.assertEquals(actualURL, expectedURL);
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.01 Open Home page by logo click",
          testName = "Navigation: open home page by clicking logo"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on the website logo navigates the user to the homepage.")
  @Link(TestData.BASE_URL)
  public void testNavToHomePage() {

    boolean isRedirectToHomePage = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickOnLogo()
            .isOnHomePage();

    Allure.step("Verify URL after click on logo");
    Assert.assertTrue(isRedirectToHomePage);
  }

  @Test(
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "navigationData",
          description = "TC-01.02 Check Nav menu URLs",
          testName = "Navigation: Verify Category Navigation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on a category link in the navigation menu redirects the user to the " +
          "corresponding category page.")
  @Link(TestData.WHATS_NEW_URL)
  public void testNavigationMenu(String baseURL, By navBarMenu, String expectedURL, String expectedTitle) {
    Allure.step("Click on " + navBarMenu.toString());
    try {
      getWait10().until(ExpectedConditions.elementToBeClickable(navBarMenu)).click();
    } catch (Exception e) {
      WebElement element = getWait10().until(ExpectedConditions.elementToBeClickable(navBarMenu));
      System.out.println("Element found using fallback method: " + element);
      ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
      ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    getWait10().until(ExpectedConditions.urlToBe(expectedURL));

    Allure.step("Collect actual results");
    final String actualURL = getDriver().getCurrentUrl();
    final String actualTitle = getDriver().getTitle();

    Allure.step("Verify actual results as expected");
    Assert.assertEquals(actualURL, expectedURL);
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @Test(
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "subNavigationData",
          description = "TC-01.03 Open Home page by logo click",
          testName = "Navigation: Verify Subcategory Navigation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on a subcategory link in the navigation menu redirects the user to the " +
          "corresponding subcategory page.")
  @Link(TestData.BASE_URL)
  public void testSubCategoryNavigation(By navBarMenu, By subNavMenu, String pageURL, String expectedTitle) {

    String actualTitle = new HomePage(getDriver())
            .clickSubcategory(navBarMenu, subNavMenu)
            .getPageTitleWithURL(pageURL);

    Allure.step("Verify actual results as expected");
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.04.01 Verify Breadcrumb Navigation to category page",
          testName = "Navigation: Verify Breadcrumb Navigation to category page"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that the breadcrumb link are functional and navigate the user to the to category page.")
  @Link(TestData.BASE_URL)
  public void testBreadcrumbsNavigationToCategory() {

    ProductPage productPage = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

    final String categoryName = productPage.getBreadcrumbsCategoryName();
    System.out.println("categoryName " + categoryName);

    final String categoryPageTitle = productPage.clickBreadcrumbsCategory().getPageTitle();
    System.out.println("categoryPageTitle " + categoryPageTitle);

    Allure.step("Verify that the user is redirected to the category page.");
    Assert.assertEquals(categoryPageTitle, categoryName);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.04.02 Verify Breadcrumb Navigation to subcategory page",
          testName = "Navigation: Verify Breadcrumb Navigation to subcategory page"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that the breadcrumb link are functional and navigate the user to the to subcategory page.")
  @Link(TestData.BASE_URL)
  public void testBreadcrumbsNavigationToSubCategory() {

    ProductPage productPage = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

    final String subCategoryName = productPage.getBreadcrumbsSubCategoryName();
    final String categoryName = productPage.getBreadcrumbsCategoryName();
    final String expectedTitle = subCategoryName + " - " + categoryName;
    System.out.println("subCategoryName " + subCategoryName);

    final String subCategoryPageTitle = productPage.clickBreadcrumbsSubCategory().getPageTitle();

    Allure.step("Verify that the user is redirected to the subcategory page.");
    Assert.assertEquals(subCategoryPageTitle, expectedTitle);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.04.03 Verify Breadcrumb Navigation to home page",
          testName = "Navigation: Verify Breadcrumb Navigation to home page"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that the breadcrumb link are functional and navigate the user to the to home page.")
  @Link(TestData.BASE_URL)
  public void testBreadcrumbsNavigationToHomePage() {

    String actualResult = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .clickBreadcrumbsHome()
            .getPageTitle();

    Allure.step("Verify that the user is redirected to the home page.");
    Assert.assertEquals(TestData.BASE_URL_TITLE, actualResult);
  }

  @Test(
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "searchNavigationData",
          description = "TC-01.05: Verify Search Result Navigation",
          testName = "Navigation: Verify Search Result Navigation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on a product in the search results redirects the user to the correct product page.")
  @Link(TestData.BASE_URL)
  public void testSearchResultNavigation(String baseURL, String productName, String expectedURL) {

    ProductPage productPage = new HomePage(getDriver())
            .searchProduct(productName)
            .clickProductImg(productName);

    final String actualProductName = productPage.getProductName();
    final String actualURL = productPage.getCurrentUrl();
    System.out.println(actualProductName);
    System.out.println(actualURL);

    Allure.step("Verify that the user is redirected to the " + productName + " page.");
    Assert.assertEquals(actualProductName, productName);
    Assert.assertEquals(actualURL, expectedURL);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.06.01: Verify Navigation to Create Account page after click on create account link",
          testName = "Verify Navigation to Create Account page after click on create account link"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that Create Account page opens after clicking on the Create an Account button on top of the page.")
  @Link(TestData.CREATE_ACCOUNT_URL)
  public void testNavToCreateAccountPage() {

    String createAccountURL = new HomePage(getDriver())
            .clickCreateAccountLink()
            .getCurrentUrl();

    Allure.step("Verify URL after click on create account");
    Assert.assertEquals(createAccountURL, TestData.CREATE_ACCOUNT_URL);
  }

  @Test(
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "loginData",
          description = "TC-01.06.02: Verify Navigation to Account page after account creation",
          testName = "Navigation: Verify Navigation to Account page after account creation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
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
          groups = {"regression"},
          description = "TC-01.06.03: Verify Navigation to Customer Login page after click on Sign In link",
          testName = "Verify Navigation to Customer Login page after click on Sign In link"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that Login page opens after clicking on the Sign In button on top of the page.")
  @Link(TestData.CUSTOMER_LOGIN_URL)
  public void testNavToLoginPage() {

    String loginURL = new HomePage(getDriver())
            .clickSignInLink()
            .getCurrentUrl();

    Allure.step("Verify URL after click on Sign In");
    Assert.assertTrue(loginURL.contains(TestData.CUSTOMER_LOGIN_URL));
  }

  @Test(
          dependsOnMethods = "testNavToAccPageByCreateAcc",
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "loginData",
          description = "TC-01.06.04: Verify Navigation to Account page after login",
          testName = "Navigation: Verify Navigation to Account page after login"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
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

  @Test(
          groups = {"regression"},
          description = "TC-01.07: Verify Navigation to Cart",
          testName = "Verify Navigation to Cart"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on the View Cart link redirects the user to the shopping cart page.")
  @Link(TestData.SHOPPING_CART_URL)
  public void testNavToCart() {

    String resultURL = new HomePage(getDriver())
            .clickProductImg(TestData.FUSION_BACKPACK_PRODUCT_NAME)
            .clickOnAddToCart()
            .clickOnCartIcon()
            .clickViewCartLink()
            .getCurrentUrl();

    Allure.step("Verify URL after click on View Cart");
    Assert.assertEquals(resultURL, TestData.SHOPPING_CART_URL);
  }

  @Test(
          groups = {"regression"},
          description = "TC-01.08: Verify Navigation to Checkout",
          testName = "Verify Navigation to Checkout"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on the Checkout button from the cart page redirects the user to the checkout page.")
  @Link(TestData.SHOPPING_CART_URL)
  public void testNavToCheckout() {

    String resultURL = new HomePage(getDriver())
            .clickProductImg(TestData.FUSION_BACKPACK_PRODUCT_NAME)
            .clickOnAddToCart()
            .clickOnCartIcon()
            .clickCheckoutButton()
            .getCurrentUrl();

    Allure.step("Verify URL after click on Checkout");
    Assert.assertEquals(resultURL, TestData.CHECKOUT_URL);
  }

  @Test(
          groups = {"regression"},
          dataProviderClass = TestData.class,
          dataProvider = "footerNavigationData",
          description = "TC-01.09: Verify Footer Links Navigation",
          testName = "Navigation: Verify Footer Links Navigation"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Navigation")
  @Description("Ensure that clicking on the links in the footer redirects the user to the correct pages.")
  @Link(TestData.BASE_URL)
  public void testFooterNavigation(By footerLink, String pageURL, String expectedTitle) {

    String actualTitle = new HomePage(getDriver())
            .clickFooterLink(footerLink)
            .getPageTitleWithURL(pageURL);

    Allure.step("Verify actual results as expected");
    Assert.assertEquals(actualTitle, expectedTitle);
  }
}