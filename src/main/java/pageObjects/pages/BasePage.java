package pageObjects.pages;

import controllers.WebDriverFactory;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public abstract class BasePage extends WebDriverFactory {

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement webElement, int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        boolean result = isElementPresent(webElement);
        return result;
    }
}
