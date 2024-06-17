package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

abstract class BreadcrumbsMenu extends TopMenu{

    @FindBy(css="ul[class='items']")
    private WebElement breadcrumbsMenu;

    @FindBy(css="ul[class='items'] > li")
    private List<WebElement> breadcrumbsList;

    protected BreadcrumbsMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Collect List of breadcrumbs items")
    public List<String> getBreadcrumbsMenuText() {
        getWait().until(ExpectedConditions.visibilityOf(breadcrumbsMenu));

        return breadcrumbsList
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
