package com.lumatest.model;

import com.lumatest.data.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TopMenu {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check redirect to home page")
    public boolean isOnHomePage() {
        return getWait().until(ExpectedConditions.urlToBe(TestData.BASE_URL + "/"));
    }
}
