package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public abstract class TopMenu extends FooterMenu {
  @FindBy(css = "a.logo")
  private WebElement logo;

  @FindBy(id = "ui-id-6")
  private WebElement gearTopMenu;

  @FindBy(id = "search")
  private WebElement searchInput;

  @FindBy(css = "a[href*='/create/']")
  private WebElement createAccountLink;

  @FindBy(css = "div[class='panel header'] a[href*='login']")
  private WebElement signInLink;

//  @FindBy(css = "div[class*='header'] span[class='logged-in']")
//  private WebElement headerLoggedInMessage;
  @FindBy(xpath = "//header//span[contains(text(),'Welcome')]")
  private WebElement headerLoggedInMessage;

  @FindBy(css = "div[data-ui-id*='message-success']")
  WebElement addToCartSuccessMessage;

  @FindBy(css = "a[class='action showcart']")
  private WebElement cartIcon;

  @FindBy(css = "span[class='counter-number']")
  private WebElement cartCounterNumber;

  @FindBy(css = "a[class='action viewcart']")
  private WebElement viewCartLink;

  @FindBy(id = "top-cart-btn-checkout")
  private WebElement checkoutButton;

  protected TopMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Click on logo")
  public HomePage clickOnLogo() {
    getWait().until(ExpectedConditions.elementToBeClickable(logo)).click();

    return new HomePage(getDriver());
  }

  @Step("Click on Gear in the top menu")
  public GearPage clickGearTopMenu() {
    getWait().until(ExpectedConditions.elementToBeClickable(gearTopMenu)).click();

    return new GearPage(getDriver());
  }

  @Step("Click '{productName}' Img.")
  public ProductPage clickProductImg(String productName) {
    final String productNameLocator = "img[alt*='";
    String imgLocator = productNameLocator + productName + "']";
    try {
      getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(imgLocator))))
              .click();
    } catch (Exception e) {
      WebElement productImg = getDriver().findElement(By.cssSelector(imgLocator));
      clickWithJS(productImg);
    }

    return new ProductPage(getDriver());
  }

  @Step("Click on subcategory menu")
  public CatalogPage clickSubcategory(By navBarMenu, By subNavMenu) {
    getWait().until(ExpectedConditions.elementToBeClickable(navBarMenu));
    WebElement element = getDriver().findElement(navBarMenu);
    hoverOverElement(element);

    getWait().until(ExpectedConditions.elementToBeClickable(subNavMenu)).click();

    return new CatalogPage(getDriver());
  }

  @Step("Search product '{productName}'")
  public SearchResultsPage searchProduct(String productName) {
    getWait().until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(productName + Keys.ENTER);

    return new SearchResultsPage(getDriver());
  }

  @Step("Click on Create an Account")
  public CreateAccountPage clickCreateAccountLink() {
    getWait().until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();

    return new CreateAccountPage(getDriver());
  }

  @Step("Click on Sign In")
  public CustomerLoginPage clickSignInLink() {
    getWait().until(ExpectedConditions.elementToBeClickable(signInLink)).click();

    return new CustomerLoginPage(getDriver());
  }

  @Step("Check the header message after login")
  public String getHeaderLoggedInMessage() {
    getWait().until(ExpectedConditions.visibilityOf(headerLoggedInMessage));

    return headerLoggedInMessage.getText();
  }

  @Step("Click on the Cart icon")
  public TopMenu clickOnCartIcon() {
    try {
      getWait().until(ExpectedConditions.elementToBeClickable(cartCounterNumber));
      cartIcon.click();
    } catch (Exception e) {
      clickWithJS(cartIcon);
    }

    return this;
  }

  @Step("Click on View and Edit Cart link")
  public ShoppingCartPage clickViewCartLink() {
    String currentURL = getDriver().getCurrentUrl();

    getWait().until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    waitForUrlToChange(currentURL);

    return new ShoppingCartPage(getDriver());
  }

  @Step("Click on Proceed to Checkout button")
  public CheckoutPage clickCheckoutButton() {
    String currentURL = getDriver().getCurrentUrl();
    int retries = 3;
    while (retries > 0) {
      Reporter.log("Remaining retries: " + retries, true);
      try {
        getWait().until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        waitForUrlToChange(currentURL);

        return new CheckoutPage(getDriver());
      } catch (Exception e1) {
        Reporter.log("Standard click failed: " + e1.getMessage(), true);
          try {
            clickWithJS(checkoutButton);
            waitForUrlToChange(currentURL);
            return new CheckoutPage(getDriver());
          } catch (Exception e2) {
            Reporter.log("JS click failed: " + e2.getMessage(), true);
          }
      } finally {
        retries--;
      }
    }

    throw new RuntimeException("Failed to click checkout button after 3 retries");
  }
}
