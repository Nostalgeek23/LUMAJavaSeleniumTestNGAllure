package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(
            description = "TC-01.00 Open base URL",
            groups = {"Smoke", "Regression"},
            testName = "Navigation: open base URL"
    )
    @Severity(SeverityLevel.BLOCKER)
    @Story("Navigation")
    @Description("TC-01.00 Open base URL")
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
            groups = {"Smoke", "Regression"},
            dataProvider = "navigationData",
            dataProviderClass = TestData.class,
            description = "TC-01.01 Check Nav menu URLs",
            testName = "Navigation: open URLs on nav panel"
    )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Navigation")
    @Description("TC-01.01 Check Nav menu URLsmvn")
    @Link(TestData.WHATS_NEW_URL)
    public void navigationMenuTest(String baseURL, By navBarMenu, String expectedURL, String expectedTitle) {

        Allure.step("Open Base URL");
        getDriver().get(baseURL);

        Allure.step("Click on " + navBarMenu.toString());
        try {
            getWait5().until(ExpectedConditions.elementToBeClickable(navBarMenu)).click();
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

    @Test
    public void testGoogle() {
        final String expectedURL = "https://www.google.com/";

        getDriver().get(expectedURL);

        final String actualURL = getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }
}
