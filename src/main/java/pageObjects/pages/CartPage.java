package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class CartPage extends PageFactoryInitializer {

    @FindBy(id = "item_4_title_link")
    private WebElement backpackCartItemLocator;

    @FindBy(id = "item_0_title_link")
    private WebElement bikeLightCartItemLocator;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButtonLocator;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButtonLocator;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBikeLightButtonLocator;

    @FindBy(id = "checkout")
    private WebElement checkoutButtonLocator;


    public boolean isBackpackCartItemDisplayed() {
        log.debug("isBackpackCartItemDisplayed()");
        return isElementPresent(backpackCartItemLocator);
    }

    public String getFullNameOfBackpackItem() {
        assert isBackpackCartItemDisplayed() : "Item 'Backpack' is NOT displayed!!!";
        log.debug("getFullNameOfBackpackItem()");
        return backpackCartItemLocator.getText();

    }

    public boolean isBikeLightCartItemDisplayed() {
        log.debug("isBikeLightCartItemDisplayed()");
        return isElementPresent(bikeLightCartItemLocator);
    }

    public String getFullNameOfBikeLightItem() {
        assert isBikeLightCartItemDisplayed() : "Item 'Bike Light' is NOT displayed!!!";
        log.debug("getFullNameOfBikeLightItem()");
        return bikeLightCartItemLocator.getText();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        log.debug("isContinueShoppingButtonDisplayed()");
        return isElementPresent(continueShoppingButtonLocator);
    }

    public InventoryPage clickOnContinueShoppingButton() {
        assert isContinueShoppingButtonDisplayed() : "'Continue Shopping' button is NOT displayed!!!";
        log.debug("clickOnContinueShoppingButton()");
        continueShoppingButtonLocator.click();
        return new InventoryPage();
    }

    public boolean isRemoveBackpackButtonDisplayed() {
        log.debug("isRemoveBackpackButtonDisplayed()");
        return isElementPresent(removeBackpackButtonLocator);
    }

    public CartPage clickOnRemoveBackpackButton() {
        assert isRemoveBackpackButtonDisplayed() : "'Remove' button for Backpack is NOT displayed!!!";
        log.debug("clickOnRemoveBackpackButton()");
        removeBackpackButtonLocator.click();
        return this;
    }

    public boolean isRemoveBikeLightButtonDisplayed() {
        log.debug("isRemoveBikeLightButtonDisplayed()");
        return isElementPresent(removeBikeLightButtonLocator);
    }

    public CartPage clickOnRemoveBikeLightButton() {
        assert isRemoveBikeLightButtonDisplayed() : "'Remove' button for Bike Light is NOT displayed!!!";
        log.debug("clickOnRemoveBikeLightButton()");
        removeBikeLightButtonLocator.click();
        return this;
    }

    public boolean isCheckoutButtonDisplayed() {
        log.debug("isCheckoutButtonDisplayed()");
        return isElementPresent(checkoutButtonLocator);
    }

    public CheckoutFirstStepPage clickOnCheckoutButton() {
        assert isCheckoutButtonDisplayed() : "'Checkout' button is NOT displayed!!!";
        log.debug("clickOnCheckoutButton()");
        checkoutButtonLocator.click();
        return new CheckoutFirstStepPage();
    }
}
