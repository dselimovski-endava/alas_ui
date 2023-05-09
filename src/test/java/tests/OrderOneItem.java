package tests;

import controllers.WebDriverFactory;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.InitializePageObjects.PageFactoryInitializer;
import utils.Paths;

@Listeners(TestListener.class)
public class OrderOneItem extends PageFactoryInitializer {

    private int iExpectedCartBadgeValue = 1;
    private String sBackpack = "Backpack";
    private String sFirstName = "Dennis";
    private String sLastName = "Rodman";
    private String sPostalCode = "99999";
    private String sSuccessMessage = "Thank you for your order!";

    @Test
    public void testOrderOneItem() {
        log.debug("[TEST STEP] Login as Standard user");
        loginPage().typeUsername(sStandardUsername)
                .typePassword(sPassword)
                .clickOnLoginButton();

        log.debug("[TEST STEP] Verify that user is on Inventory page");
        String actualUrl = WebDriverFactory.getWebDriver().getCurrentUrl();
        assert actualUrl.contains(Paths.INVENTORY_PATH) : "User is NOT on Inventory page!!!";

        log.debug("[TEST STEP] Add an item (Backpack) to the Cart");
        inventoryPage().clickOnAddToChartBackpackButton();

        log.debug("[TEST STEP] Verify that the cart badge is updated correctly");
        int iCartBadgeValue = inventoryPage().getValueOfCartBadge();
        assert iCartBadgeValue == iExpectedCartBadgeValue : "Wrong Cart badge value!!! Expected: " + iExpectedCartBadgeValue + ", Actual: " + iCartBadgeValue;

        log.debug("[TEST STEP] Open the Cart and Verify that the correct items is added");
        inventoryPage().clickOnCartButton();
        String actualUrl4 = WebDriverFactory.getWebDriver().getCurrentUrl();
        assert actualUrl4.contains(Paths.CART_PATH) : "User is NOT on Cart page!!!";
        assert cartPage().getFullNameOfBackpackItem().contains(sBackpack) : "Item 'Backpack' is NOT in the Cart!!!";

        log.debug("[TEST STEP] Continue to the Checkout page");
        cartPage().clickOnCheckoutButton();
        String actualUrl5 = WebDriverFactory.getWebDriver().getCurrentUrl();
        assert actualUrl5.contains(Paths.CHECKOUT_STEP_ONE_PATH) : "User is NOT on Checkout First Step page!!!";

        log.debug("[TEST STEP] Complete the checkout form");
        checkoutFirstStepPage().typeFirstname(sFirstName)
                .typeLastname(sLastName)
                .typePostalCode(sPostalCode)
                .clickOnContinueButton();
        String actualUrl6 = WebDriverFactory.getWebDriver().getCurrentUrl();
        assert actualUrl6.contains(Paths.CHECKOUT_STEP_TWO_PATH) : "User is NOT on Checkout Second Step page!!!";

        log.debug("[TEST STEP] Complete the order and Verify successful message");
        checkoutSecondStepPage().clickOnFinishButton();
        String actualUrl7 = WebDriverFactory.getWebDriver().getCurrentUrl();
        assert actualUrl7.contains(Paths.CHECKOUT_COMPLETE_PATH) : "User is NOT on Checkout Complete page!!!";
        assert checkoutCompletePage().getSuccessfulMessage().equals(sSuccessMessage) : "Wrong successful message!!!";
    }
}
