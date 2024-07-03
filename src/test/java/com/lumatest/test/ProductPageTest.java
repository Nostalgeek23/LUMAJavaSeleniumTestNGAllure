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
          testName = "PRODUCT | Product Details",
          description = "TC-03 Verify Product Details on Product Page",
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
}
