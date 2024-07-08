package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

  @Test(
          groups = {"cart"},
          description = "TC-01.07: Verify Navigation to Cart",
          testName = "Cart: Verify Navigation to Cart"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Cart")
  @Description("Ensure that clicking on the View Cart link redirects the user to the shopping cart page.")
  @Link(TestData.SHOPPING_CART_URL)
  public void testNavToCart() {

    String resultURL = new HomePage(getDriver())
            .clickProductImg(TestData.FUSION_BACKPACK_PRODUCT_NAME)
            .clickOnAddToCart()
            .clickOnCartIcon()
            .clickViewCartLink()
            .getUrl();

    Allure.step("Verify URL after click on View Cart");
    Assert.assertEquals(resultURL, TestData.SHOPPING_CART_URL);
  }

  @Test(
          groups = {"cart"},
          description = "TC-01.08: Verify Navigation to Checkout",
          testName = "Cart: Verify Navigation to Checkout"
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Cart")
  @Description("Ensure that clicking on the Checkout button from the cart page redirects the user to the checkout page.")
  @Link(TestData.SHOPPING_CART_URL)
  public void testNavToCheckout() {

    String resultURL = new HomePage(getDriver())
            .clickProductImg(TestData.FUSION_BACKPACK_PRODUCT_NAME)
            .clickOnAddToCart()
            .clickOnCartIcon()
            .clickCheckoutButton()
            .getUrl();

    Allure.step("Verify URL after click on Checkout");
    Assert.assertTrue(
            resultURL.equals(TestData.CHECKOUT_URL) || resultURL.equals(TestData.CHECKOUT_FIREFOX_URL));
  }
}
