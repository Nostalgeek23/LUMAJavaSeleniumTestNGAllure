package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.CatalogPage;
import com.lumatest.model.CategoryPage;
import com.lumatest.model.HomePage;
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

    Allure.step("Open base URL");
    getDriver().get(TestData.BASE_URL);

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
    Allure.step("Open Base URL");
    getDriver().get(TestData.BASE_URL);

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

    Allure.step("Open Base URL");
    getDriver().get(baseURL);

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

    Allure.step("Open Base URL");
    getDriver().get(TestData.BASE_URL);

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
    Allure.step("Open Base URL");
    getDriver().get(TestData.BASE_URL);

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
    Allure.step("Open Base URL");
    getDriver().get(TestData.BASE_URL);

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
    Allure.step("Open Base URL");
    getDriver().get(TestData.BASE_URL);

    String actualResult = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .clickBreadcrumbsHome()
            .getPageTitle();

    Allure.step("Verify that the user is redirected to the home page.");
    Assert.assertEquals(TestData.BASE_URL_TITLE, actualResult);
  }
}