package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class SideMenu extends BreadcrumbsMenu {

    @FindBy(css = "dd a[href*='bags']")
    private WebElement bagsSideMenu;

    protected SideMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Bags in side menu")
    public BagsPage clickBagsSideMenu() {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(bagsSideMenu)).click();
        } catch (Exception e) {
            getWait().until(ExpectedConditions.elementToBeClickable(bagsSideMenu));
            System.out.println("Element found using fallback method: " + bagsSideMenu);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", bagsSideMenu);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", bagsSideMenu);
        }

        return new BagsPage(getDriver());
    }
}
