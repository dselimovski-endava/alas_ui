package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class CheckoutFirstStepPage extends PageFactoryInitializer {

    @FindBy(id = "first-name")
    private WebElement firstnameFieldLocator;

    @FindBy(id = "last-name")
    private WebElement lastnameFieldLocator;

    @FindBy(id = "postal-code")
    private WebElement postalCodeFieldLocator;

    @FindBy(id = "continue")
    private WebElement continueButtonLocator;


    public boolean isFirstnameFieldDisplayed() {
        log.debug("isFirstnameFieldDisplayed()");
        return isElementPresent(firstnameFieldLocator);
    }

    public CheckoutFirstStepPage typeFirstname(String firstname) {
        assert isFirstnameFieldDisplayed() : "Firstname text field is NOT displayed!!!";
        log.debug("typeFirstname(" + firstname + ")");
        firstnameFieldLocator.clear();
        firstnameFieldLocator.sendKeys(firstname);
        return this;
    }

    public boolean isLastnameFieldDisplayed() {
        log.debug("isFirstnameFieldDisplayed()");
        return isElementPresent(lastnameFieldLocator);
    }

    public CheckoutFirstStepPage typeLastname(String lastname) {
        assert isLastnameFieldDisplayed() : "Lastname text field is NOT displayed!!!";
        log.debug("typeLastname(" + lastname + ")");
        lastnameFieldLocator.clear();
        lastnameFieldLocator.sendKeys(lastname);
        return this;
    }

    public boolean isPostalCodeFieldDisplayed() {
        log.debug("isPostalCodeFieldDisplayed()");
        return isElementPresent(postalCodeFieldLocator);
    }

    public CheckoutFirstStepPage typePostalCode(String postalCode) {
        assert isPostalCodeFieldDisplayed() : "Postal Code text field is NOT displayed!!!";
        log.debug("typePostalCode(" + postalCode + ")");
        postalCodeFieldLocator.clear();
        postalCodeFieldLocator.sendKeys(postalCode);
        return this;
    }

    public boolean isContinueButtonDisplayed() {
        log.debug("isContinueButtonDisplayed()");
        return isElementPresent(continueButtonLocator);
    }

    public CheckoutSecondStepPage clickOnContinueButton() {
        assert isContinueButtonDisplayed() : "'Continue' button is NOT displayed!!!";
        log.debug("clickOnContinueButton()");
        continueButtonLocator.click();
        return new CheckoutSecondStepPage();
    }
}
