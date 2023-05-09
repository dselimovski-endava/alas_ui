package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class CheckoutSecondStepPage extends PageFactoryInitializer {

    @FindBy(id = "finish")
    private WebElement finishButtonLocator;


    public boolean isFinishButtonDisplayed() {
        log.debug("isFinishButtonDisplayed()");
        return isElementPresent(finishButtonLocator);
    }

    public CheckoutCompletePage clickOnFinishButton() {
        assert isFinishButtonDisplayed() : "'Finish' button is NOT displayed!!!";
        log.debug("clickOnFinishButton()");
        finishButtonLocator.click();
        return new CheckoutCompletePage();
    }
}
