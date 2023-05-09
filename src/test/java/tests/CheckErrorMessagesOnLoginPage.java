package tests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.InitializePageObjects.PageFactoryInitializer;

@Listeners(TestListener.class)
public class CheckErrorMessagesOnLoginPage extends PageFactoryInitializer {

    private String sExpectedUsernameAlertMessage = "Epic sadface: Username is required";
    private String sExpectedPasswordAlertMessage = "Epic sadface: Password is required";
    private String sExpectedUsernameAndPasswordAlertMessage = "Epic sadface: Username and password do not match any user in this service";
    private String sWrongPassword = "wrongWrong";

    @Test
    public void testCheckErrorMessagesOnLoginPage() {
        log.debug("[TEST STEP] Click Login button and Verify alert message");
        loginPage().clickOnLoginButton();
        String sActualUsernameAlertMessage = loginPage().getAlertBoxMessage();
        assert sActualUsernameAlertMessage.equals(sExpectedUsernameAlertMessage)
                : "Wrong Username alert message!!! Expected: " + sExpectedUsernameAlertMessage + ", Actual: " + sActualUsernameAlertMessage;

        log.debug("[TEST STEP] Type username, click Login button and Verify alert message");
        loginPage().typeUsername(sStandardUsername)
                .clickOnLoginButton();
        String sActualPasswordAlertMessage = loginPage().getAlertBoxMessage();
        assert sActualPasswordAlertMessage.equals(sExpectedPasswordAlertMessage)
                : "Wrong Password alert message!!! Expected: " + sExpectedPasswordAlertMessage + ", Actual: " + sActualPasswordAlertMessage;

        log.debug("[TEST STEP] Type wrong password, click Login button and Verify alert message");
        loginPage().typePassword(sWrongPassword)
                .clickOnLoginButton();
        String sActualUsernameAndPasswordAlertMessage = loginPage().getAlertBoxMessage();
        assert sActualUsernameAndPasswordAlertMessage.equals(sExpectedUsernameAndPasswordAlertMessage)
                : "Wrong Username and Password alert message!!! Expected: " + sExpectedUsernameAndPasswordAlertMessage + ", Actual: " + sActualUsernameAndPasswordAlertMessage;
    }
}
