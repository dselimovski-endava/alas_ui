package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

public class LoginPage extends PageFactoryInitializer {

    @FindBy(id="user-name")
    private WebElement usernameFieldLocator;

    @FindBy(id="password")
    private WebElement passwordFieldLocator;

    @FindBy(id="login-button")
    private WebElement loginButtonLocator;

    @FindBy(className = "error-message-container")
    private WebElement alertBox;


    public boolean isUsernameFieldDisplayed() {
        log.debug("isUsernameFieldDisplayed()");
        return isElementPresent(usernameFieldLocator);
    }

    public LoginPage typeUsername(String username) {
        assert isUsernameFieldDisplayed() : "Username text field is NOT displayed!!!";
        log.debug("typeUsername(" + username + ")");
        usernameFieldLocator.clear();
        usernameFieldLocator.sendKeys(username);
        return this;
    }

    public boolean isPasswordFieldDisplayed() {
        log.debug("isPasswordFieldDisplayed()");
        return isElementPresent(passwordFieldLocator);
    }

    public LoginPage typePassword(String password) {
        assert isPasswordFieldDisplayed() : "Password text field is NOT displayed!!!";
        log.debug("typePassword(" + password + ")");
        passwordFieldLocator.clear();
        passwordFieldLocator.sendKeys(password);
        return this;
    }

    public boolean isLoginButtonDisplayed() {
        log.debug("isLoginButtonDisplayed()");
        return isElementPresent(loginButtonLocator);
    }

    public InventoryPage clickOnLoginButton() {
        assert isLoginButtonDisplayed() : "'Login' button is NOT displayed!!!";
        log.debug("clickOnLoginButton()");
        loginButtonLocator.click();
        return new InventoryPage();
    }

    public boolean isAlertBoxDisplayed() {
        log.debug("isAlertBoxDisplayed()");
        return isElementPresent(alertBox);
    }

    public String getAlertBoxMessage() {
        assert isAlertBoxDisplayed() : "Alert Box is NOT displayed!!!";
        log.debug("getFullNameOfBikeLightItem()");
        return alertBox.getText();
    }
}
