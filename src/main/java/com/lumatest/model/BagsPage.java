package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BagsPage extends SideMenu{

//    @FindBy(css="img[alt*='Driven']")
//    WebElement drivenBackpackImg;
    private final String productNameLocator = "img[alt*='";

    protected BagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click '{productName}' Img.")
    public ProductPage clickProductImg(String productName) {
        String imgLocator = productNameLocator + productName + "']";
        getWait().until(ExpectedConditions
                .elementToBeClickable(getDriver().findElement(By.cssSelector(imgLocator))))
                .click();

        return new ProductPage(getDriver());
    }
}
