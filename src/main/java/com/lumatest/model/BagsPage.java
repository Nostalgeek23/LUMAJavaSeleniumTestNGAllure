package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BagsPage extends SideMenu{

    private final String productNameLocator = "img[alt*='";

    protected BagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click '{productName}' Img.")
    public ProductPage clickProductImg(String productName) {
        String imgLocator = productNameLocator + productName + "']";

        try {
            getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(imgLocator))).click();
        } catch (Exception e) {
            WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(imgLocator)));
            System.out.println("Element found using fallback method: " + element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        }

        return new ProductPage(getDriver());
    }
}
