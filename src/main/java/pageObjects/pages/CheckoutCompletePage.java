package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class CheckoutCompletePage extends PageFactoryInitializer {

    @FindBy(className = "complete-header")
    private WebElement successfulMessageLocator;


    public boolean isSuccessfulMessageDisplayed() {
        log.debug("isSuccessfulMessageDisplayed()");
        return isElementPresent(successfulMessageLocator);
    }

    public String getSuccessfulMessage() {
        assert isSuccessfulMessageDisplayed() : "Successful message is NOT displayed!!!";
        log.debug("getSuccessfulMessage()");
        return successfulMessageLocator.getText();
    }
}
