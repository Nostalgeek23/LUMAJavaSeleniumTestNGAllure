package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest {

  @Test(
          testName = "PRODUCT | Product Name",
          description = "TC-PROD-002 Verify Product Name on Product Page and Breadcrumbs",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("To verify that the product page displays the correct product name and breadcrumb menu text " +
          "for the 'Driven Backpack'.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProduct() {

    ProductPage productPage = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

    final String productName = productPage.getProductName();
    final List<String> breadcrumbsMenuText = productPage.getBreadcrumbsMenuText();

    Allure.step("Verify " + productName + " is on product page and in the breadcrumbs");
    Assert.assertEquals(productName, TestData.DRIVEN_BACKPACK_PRODUCT_NAME);
    Assert.assertTrue(breadcrumbsMenuText.contains(TestData.DRIVEN_BACKPACK_PRODUCT_NAME));
  }

  @Test(
          testName = "PRODUCT | Product Price",
          description = "TC-PROD-003 Verify Product Price on Product Page",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Ensure that the product price is displayed correctly and matches the listed price.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProductPrice() {

    String productPrice = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .getProductPrice();

    Allure.step("Verify current price matches the listed one");
    Assert.assertEquals(productPrice, TestData.DRIVEN_BACKPACK_LISTED_PRICE);
  }

  @Test(
          testName = "PRODUCT | Product Description",
          description = "TC-PROD-005 Verify Product Description on Product Page",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Ensure that the product description is displayed correctly and matches the listed one.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProductDescription() {

    String productDescription = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .getProductDescription();

    Allure.step("Verify current description matches the listed one");
    Assert.assertEquals(productDescription, TestData.DRIVEN_BACKPACK_DESCRIPTION);
  }

  @Test(
          testName = "PRODUCT | Product Stock Availability",
          description = "TC-PROD-006 Verify Stock Availability on Product Page",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Ensure that the stock availability is displayed correctly on the product page.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProductInStock() {

    String productAvailability = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .getProductAvailability();

    Allure.step("Verify Stock Availability status on Product Page");
    Assert.assertEquals(productAvailability, TestData.PRODUCT_IN_STOCK);
  }

  @Test(
          testName = "PRODUCT | Product SKU/ID",
          description = "TC-PROD-009 Verify SKU/ID Display",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Ensure that the product SKU or ID is displayed correctly.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProductSKU() {

    String productSKU = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .getProductSKU();

    Allure.step("Verify SKU or ID on Product Page");
    Assert.assertEquals(productSKU, TestData.DRIVEN_BACKPACK_SKU);
  }

  @Test(
          testName = "PRODUCT | Product breadcrumb path",
          description = "TC-PROD-010 Verify the opened product breadcrumb path",
          groups = {"functional"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Verify the opened product breadcrumb path")
  public void testProductPath() {

    List<String> actualProductPath = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME)
            .getBreadcrumbsMenuText();

    Allure.step("Verify the product breadcrumb path");
    Assert.assertEquals(actualProductPath, TestData.DRIVEN_BACKPACK_BREADCRUMB_PATH);
  }

  @Test(
          testName = "PRODUCT | Product add to compare list message",
          description = "TC-PROD-011 Verify add to compare message displays after click Add to Compare button",
          groups = {"functional"},
          dataProviderClass = TestData.class,
          dataProvider = "compareProductData"
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("Verify add to compare message displays after click Add to Compare button")
  public void testAddToCompareMessage(String productName) {

    String actualMessage = new HomePage(getDriver())
            .clickGearTopMenu()
            .clickBagsSideMenu()
            .clickProductImg(productName)
            .clickAddToCompare()
            .getAlertMessage();

    Allure.step("Verify add to compare message for " + productName);
    Assert.assertEquals(actualMessage, "You added product " + productName + " to the comparison list.");
  }
}
