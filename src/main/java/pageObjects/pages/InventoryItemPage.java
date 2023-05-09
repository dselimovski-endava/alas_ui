package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class InventoryItemPage extends PageFactoryInitializer {

    @FindBy(className = "inventory_details_name")
    private WebElement bikeLightItemNameLocator;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToChartButtonBikeLightLocator;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButtonLocator;


    public String getBikeLightItemName() {
        log.debug("getBikeLightItemName()");
        return bikeLightItemNameLocator.getText();
    }

    public boolean isAddToChartButtonBikeLightDisplayed() {
        log.debug("isAddToChartButtonBikeLightDisplayed()");
        return isElementPresent(addToChartButtonBikeLightLocator);
    }

    public InventoryItemPage clickOnAddToChartBikeLightButton() {
        assert isAddToChartButtonBikeLightDisplayed() : "'Add To Cart' button for Bike Light is NOT displayed!!!";
        log.debug("clickOnAddToChartBikeLightButton()");
        addToChartButtonBikeLightLocator.click();
        return this;
    }

    public boolean isCartButtonDisplayed() {
        log.debug("isCartButtonDisplayed()");
        return isElementPresent(cartButtonLocator);
    }

    public CartPage clickOnCartButton() {
        assert isCartButtonDisplayed() : "'Cart' button is NOT displayed!!!";
        log.debug("clickOnCartButton()");
        cartButtonLocator.click();
        return new CartPage();
    }
}
