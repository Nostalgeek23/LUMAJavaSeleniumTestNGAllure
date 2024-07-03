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
          testName = "PRODUCT | Product Description ",
          description = "TC-PROD-005 Verify Product Price on Product Page",
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

    Allure.step("Verify current price matches the listed one");
    Assert.assertEquals(productDescription, TestData.DRIVEN_BACKPACK_DESCRIPTION);
  }
}
