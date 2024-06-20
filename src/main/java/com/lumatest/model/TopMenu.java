package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class TopMenu extends BasePage {
    private final String productNameLocator = "img[alt*='";
    @FindBy(id = "ui-id-6")
    private WebElement gearTopMenu;
    protected TopMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Gear in the top menu")
    public GearPage clickGearTopMenu() {
        getWait().until(ExpectedConditions.elementToBeClickable(gearTopMenu)).click();

        return new GearPage(getDriver());
    }

    @Step("Click '{productName}' Img.")
    public ProductPage clickProductImg(String productName) {
        String imgLocator = productNameLocator + productName + "']";
        getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(imgLocator))))
                .click();

        return new ProductPage(getDriver());
    }
}
