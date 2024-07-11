package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import com.lumatest.utils.RetryAnalyzer;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

  @Test(
          groups = {"search"},
          dataProviderClass = TestData.class,
          dataProvider = "searchNavigationData",
          description = "TC-04.01: Verify Search Result Navigation",
          testName = "Search: Verify Search Result Navigation",
          retryAnalyzer = RetryAnalyzer.class
  )
  @Severity(SeverityLevel.CRITICAL)
  @Story("Search")
  @Description("Ensure that clicking on a product in the search results redirects the user to the correct product page.")
  @Link(TestData.BASE_URL)
  public void testSearchResultNavigation(String baseURL, String productName, String expectedURL) {

    ProductPage productPage = new HomePage(getDriver())
            .searchProduct(productName)
            .clickProductImg(productName);

    final String actualProductName = productPage.getProductName();
    final String actualURL = productPage.getUrl();
    System.out.println(actualProductName);
    System.out.println(actualURL);

    Allure.step("Verify that the user is redirected to the " + productName + " page.");
    Assert.assertEquals(actualProductName, productName);
    Assert.assertEquals(actualURL, expectedURL);
  }
}
