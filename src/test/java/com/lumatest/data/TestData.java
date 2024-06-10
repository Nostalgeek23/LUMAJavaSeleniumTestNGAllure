package com.lumatest.data;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
    public static final String BASE_URL = "https://magento.softwaretestingboard.com";
    public static final String BASE_URL_TITLE = "Home Page";

    /* Navigation bar */
    public static final By WHATS_NEW_MENU = By.cssSelector("#ui-id-3");
    public static final String WHATS_NEW_URL = BASE_URL + "/what-is-new.html";
    public static final String WHATS_NEW_TITLE = "What's New";

    public static final By WOMAN_MENU = By.cssSelector("#ui-id-4");
    public static final String WOMAN_URL = BASE_URL + "/women.html";
    public static final String WOMAN_TITLE = "Women";

    public static final By MAN_MENU = By.cssSelector("#ui-id-5");
    public static final String MAN_URL = BASE_URL + "/men.html";
    public static final String MAN_TITLE = "Men";

    public static final By GEAR_MENU = By.cssSelector("#ui-id-6");
    public static final String GEAR_URL = BASE_URL + "/gear.html";
    public static final String GEAR_TITLE = "Gear";

    public static final By TRAINING_MENU = By.cssSelector("#ui-id-7");
    public static final String TRAINING_URL = BASE_URL + "/training.html";
    public static final String TRAINING_TITLE = "Training";

    public static final By SALE_MENU = By.cssSelector("#ui-id-8");
    public static final String SALE_URL = BASE_URL + "/sale.html";
    public static final String SALE_TITLE = "Sale";

//            Allure.step("Set up expected results");
    @DataProvider(name = "navigationData")
    public static Object[][] getNavMenuData() {
        return new Object[][] {
                {BASE_URL, WHATS_NEW_MENU, WHATS_NEW_URL, WHATS_NEW_TITLE},
                {BASE_URL, WOMAN_MENU, WOMAN_URL, WOMAN_TITLE},
                {BASE_URL, MAN_MENU, MAN_URL, MAN_TITLE},
                {BASE_URL, GEAR_MENU, GEAR_URL, GEAR_TITLE},
                {BASE_URL, TRAINING_MENU, TRAINING_URL, TRAINING_TITLE},
                {BASE_URL, SALE_MENU, SALE_URL, SALE_TITLE}
        };
    }

}
