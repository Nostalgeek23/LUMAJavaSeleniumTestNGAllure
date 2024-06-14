package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class TopMenu extends BasePage {
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
}
