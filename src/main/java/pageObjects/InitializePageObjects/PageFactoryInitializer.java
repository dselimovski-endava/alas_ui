package pageObjects.InitializePageObjects;

import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.*;

public class PageFactoryInitializer extends BasePage {

    public LoginPage loginPage() {
        return PageFactory.initElements(getWebDriver(), LoginPage.class);
    }

    public InventoryPage inventoryPage() {
        return PageFactory.initElements(getWebDriver(), InventoryPage.class);
    }

    public InventoryItemPage inventoryItemPage() {
        return PageFactory.initElements(getWebDriver(), InventoryItemPage.class);
    }

    public CartPage cartPage() {
        return PageFactory.initElements(getWebDriver(), CartPage.class);
    }

    public CheckoutFirstStepPage checkoutFirstStepPage() {
        return PageFactory.initElements(getWebDriver(), CheckoutFirstStepPage.class);
    }

    public CheckoutSecondStepPage checkoutSecondStepPage() {
        return PageFactory.initElements(getWebDriver(), CheckoutSecondStepPage.class);
    }

    public CheckoutCompletePage checkoutCompletePage() {
        return PageFactory.initElements(getWebDriver(), CheckoutCompletePage.class);
    }
}
