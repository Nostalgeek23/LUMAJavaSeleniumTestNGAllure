package com.lumatest.model;

import org.openqa.selenium.WebDriver;

abstract class CatalogFilter extends BreadcrumbsMenu{
    protected CatalogFilter(WebDriver driver) {
        super(driver);
    }
}
