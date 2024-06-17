package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest {

    @Test
    public void testProduct() {
        Allure.step("Open base URL");
        getDriver().get(TestData.BASE_URL);

        ProductPage productPage = new HomePage(getDriver())
                .clickGearTopMenu()
                .clickBagsSideMenu()
                .clickProductImg(TestData.DRIVENBACKPACK_PRODUCT_NAME);

        final String productName = productPage.getProductName();
        final List<String> breadcrumbsMenuText = productPage.getBreadcrumbsMenuText();
        System.out.println(breadcrumbsMenuText);

        Allure.step("Verify " + productName + " is on product page and in the breadcrumbs");
        Assert.assertEquals(productName, TestData.DRIVENBACKPACK_PRODUCT_NAME);
        Assert.assertTrue(breadcrumbsMenuText.contains(TestData.DRIVENBACKPACK_PRODUCT_NAME));
    }
}
