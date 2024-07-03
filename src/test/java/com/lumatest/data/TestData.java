package com.lumatest.data;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static com.lumatest.utils.ProjectUtils.readFromFile;


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

  /*
  Subcategory Navigation
   */
  public static final By WOMAN_TOPS_MENU = By.cssSelector("#ui-id-9");
  public static final String WOMAN_TOPS_URL = BASE_URL + "/women/tops-women.html";
  public static final String WOMAN_TOPS_TITLE = "Tops - Women";

  public static final By WOMAN_BOTTOMS_MENU = By.cssSelector("#ui-id-10");
  public static final String WOMAN_BOTTOMS_URL = BASE_URL + "/women/bottoms-women.html";
  public static final String WOMAN_BOTTOMS_TITLE = "Bottoms - Women";

  public static final By MAN_TOPS_MENU = By.cssSelector("#ui-id-17");
  public static final String MAN_TOPS_URL = BASE_URL + "/men/tops-men.html";
  public static final String MAN_TOPS_TITLE = "Tops - Men";

  public static final By MAN_BOTTOMS_MENU = By.cssSelector("#ui-id-18");
  public static final String MAN_BOTTOMS_URL = BASE_URL + "/men/bottoms-men.html";
  public static final String MAN_BOTTOMS_TITLE = "Bottoms - Men";

  public static final By GEAR_BAGS_MENU = By.cssSelector("#ui-id-25");
  public static final String GEAR_BAGS_URL = BASE_URL + "/gear/bags.html";
  public static final String GEAR_BAGS_TITLE = "Bags - Gear";

  public static final By GEAR_FITNESS_MENU = By.cssSelector("#ui-id-26");
  public static final String GEAR_FITNESS_URL = BASE_URL + "/gear/fitness-equipment.html";
  public static final String GEAR_FITNESS_TITLE = "Fitness Equipment - Gear";

  public static final By GEAR_WATCHES_MENU = By.cssSelector("#ui-id-27");
  public static final String GEAR_WATCHES_URL = BASE_URL + "/gear/watches.html";
  public static final String GEAR_WATCHES_TITLE = "Watches - Gear";

  public static final By TRAINING_VIDEO_MENU = By.cssSelector("#ui-id-28");
  public static final String TRAINING_VIDEO_URL = BASE_URL + "/training/training-video.html";
  public static final String TRAINING_VIDEO_TITLE = "Video Download - Training";

  /*
  For Product Pages
  */
  public static final String DRIVEN_BACKPACK_PRODUCT_URL = BASE_URL + "/driven-backpack.html";
  public static final String DRIVEN_BACKPACK_PRODUCT_NAME = "Driven Backpack";
  public static final String DRIVEN_BACKPACK_LISTED_PRICE = "$36.00";
  public static final String DRIVEN_BACKPACK_DESCRIPTION;
  public static final String FUSION_BACKPACK_PRODUCT_NAME = "Fusion Backpack";

  /*
  For login
   */
  public static final String FIRST_NAME = "Harry";
  public static final String LAST_NAME = "Potter";
  public static final String EMAIL = "hp@gryffindor.hog";
  public static final String PASSWORD = "DeathlyHallows321";
  public static final String ACCOUNT_URL = BASE_URL + "/customer/account/";
  public static final String CREATE_ACCOUNT_URL = BASE_URL + "/customer/account/create/";
  public static final String EMAIL_ERROR_MESSAGE = "There is already an account with this email address.";
  public static final String CUSTOMER_LOGIN_URL = BASE_URL + "/customer/account/login/referer/";

  /*
  For Cart
   */
  public static final String SHOPPING_CART_URL = BASE_URL + "/checkout/cart/";
  public static final String CHECKOUT_URL = BASE_URL + "/checkout/";

  /*
  For Footer
   */
  public static final String SEARCH_TERMS_URL = BASE_URL + "/search/term/popular/";
  public static final By SEARCH_TERMS_LINK = By.cssSelector("a[href$='/search/term/popular/']");
  public static final String SEARCH_TERMS_TITLE = "Popular Search Terms";

  public static final String POLICY_URL = BASE_URL + "/privacy-policy-cookie-restriction-mode";
  public static final By POLICY_LINK = By.cssSelector("a[href$='/privacy-policy-cookie-restriction-mode/']");
  public static final String POLICY_TITLE = "Privacy Policy";

  public static final String ADVANCED_SEARCH_URL = BASE_URL + "/catalogsearch/advanced/";
  public static final By ADVANCED_SEARCH_LINK = By.cssSelector("footer a[href$='/catalogsearch/advanced/']");
  public static final String ADVANCED_SEARCH_TITLE = "Advanced Search";

  public static final String ORDERS_AND_RETURNS_URL = BASE_URL + "/sales/guest/form/";
  public static final By ORDERS_AND_RETURNS_LINK = By.cssSelector("a[href$='/sales/guest/form/']");
  public static final String ORDERS_AND_RETURNS_TITLE = "Orders and Returns";

  static {
    try {
      DRIVEN_BACKPACK_DESCRIPTION = readFromFile("src/test/java/com/lumatest/data/DrivenBackpackDescription.txt");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Step("Set up expected results")
  @DataProvider(name = "navigationData")
  public static Object[][] getNavMenuData() {
    return new Object[][]{
            {BASE_URL, WHATS_NEW_MENU, WHATS_NEW_URL, WHATS_NEW_TITLE},
            {BASE_URL, WOMAN_MENU, WOMAN_URL, WOMAN_TITLE},
            {BASE_URL, MAN_MENU, MAN_URL, MAN_TITLE},
            {BASE_URL, GEAR_MENU, GEAR_URL, GEAR_TITLE},
            {BASE_URL, TRAINING_MENU, TRAINING_URL, TRAINING_TITLE},
            {BASE_URL, SALE_MENU, SALE_URL, SALE_TITLE}
    };
  }

  @Step("Set up expected results")
  @DataProvider(name = "subNavigationData")
  public static Object[][] getSubNavMenuData() {
    return new Object[][]{
            {WOMAN_MENU, WOMAN_TOPS_MENU, WOMAN_TOPS_URL, WOMAN_TOPS_TITLE},
            {WOMAN_MENU, WOMAN_BOTTOMS_MENU, WOMAN_BOTTOMS_URL, WOMAN_BOTTOMS_TITLE},

            {MAN_MENU, MAN_TOPS_MENU, MAN_TOPS_URL, MAN_TOPS_TITLE},
            {MAN_MENU, MAN_BOTTOMS_MENU, MAN_BOTTOMS_URL, MAN_BOTTOMS_TITLE},

            {GEAR_MENU, GEAR_BAGS_MENU, GEAR_BAGS_URL, GEAR_BAGS_TITLE},
            {GEAR_MENU, GEAR_FITNESS_MENU, GEAR_FITNESS_URL, GEAR_FITNESS_TITLE},
            {GEAR_MENU, GEAR_WATCHES_MENU, GEAR_WATCHES_URL, GEAR_WATCHES_TITLE},

            {TRAINING_MENU, TRAINING_VIDEO_MENU, TRAINING_VIDEO_URL, TRAINING_VIDEO_TITLE}
    };
  }

  @Step("Set up expected results")
  @DataProvider(name = "searchNavigationData")
  public static Object[][] getSearchNavData() {
    return new Object[][]{
            {BASE_URL, DRIVEN_BACKPACK_PRODUCT_NAME, DRIVEN_BACKPACK_PRODUCT_URL}
    };
  }

  @Step("Set up expected results")
  @DataProvider(name = "loginData")
  public static Object[][] getLoginData() {
    return new Object[][]{
            {FIRST_NAME, LAST_NAME, EMAIL, PASSWORD}
    };
  }

  @Step("Set up expected results")
  @DataProvider(name = "footerNavigationData")
  public static Object[][] getFooterNavMenuData() {
    return new Object[][]{
            {SEARCH_TERMS_LINK, SEARCH_TERMS_URL, SEARCH_TERMS_TITLE},
            {POLICY_LINK, POLICY_URL, POLICY_TITLE},
            {ADVANCED_SEARCH_LINK, ADVANCED_SEARCH_URL, ADVANCED_SEARCH_TITLE},
            {ORDERS_AND_RETURNS_LINK, ORDERS_AND_RETURNS_URL, ORDERS_AND_RETURNS_TITLE}
    };
  }

}
