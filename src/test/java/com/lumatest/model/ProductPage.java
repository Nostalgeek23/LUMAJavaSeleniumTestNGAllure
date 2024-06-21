package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CatalogPage {

    @FindBy(css="h1 > span")
    WebElement productName;
    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Collect actual product name text")
    public String getProductName() {
        return productName.getText();
    }
}
