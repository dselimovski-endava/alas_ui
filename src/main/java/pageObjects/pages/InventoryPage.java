package pageObjects.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class InventoryPage extends PageFactoryInitializer {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToChartButtonBackpackLocator;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToChartButtonBikeLightLocator;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButtonLocator;

    @FindBy(id = "item_0_title_link")
    private WebElement bikeLightItemLocator;

    @FindBy(css = "span.shopping_cart_badge")
    private WebElement cartBadge;


    public boolean isAddToChartButtonBackpackDisplayed() {
        log.debug("isAddToChartButtonBackpackDisplayed()");
        return isElementPresent(addToChartButtonBackpackLocator);
    }

    public InventoryPage clickOnAddToChartBackpackButton() {
        assert isAddToChartButtonBackpackDisplayed() : "'Add To Cart' button for Backpack is NOT displayed!!!";
        log.debug("clickOnAddToChartBackpackButton()");
        addToChartButtonBackpackLocator.click();
        return this;
    }

    public boolean isAddToChartButtonBikeLightDisplayed() {
        log.debug("isAddToChartButtonBikeLightDisplayed()");
        return isElementPresent(addToChartButtonBikeLightLocator);
    }

    public InventoryPage clickOnAddToChartBikeLightButton() {
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

    public boolean isBikeLightItemDisplayed() {
        log.debug("isBikeLightItemDisplayed()");
        return isElementPresent(bikeLightItemLocator);
    }

    public InventoryItemPage clickBikeLightItem() {
        assert isBikeLightItemDisplayed() : "'Bike Light' item is NOT displayed!!!";
        log.debug("clickBikeLightItem()");
        try {
            bikeLightItemLocator.click();
        } catch (ElementNotInteractableException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", bikeLightItemLocator);
        }
        return new InventoryItemPage();
    }

    public int getValueOfCartBadge() {
        log.debug("getValueOfCartBadge()");
        return Integer.parseInt(cartBadge.getText());
    }
}
