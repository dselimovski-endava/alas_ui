package controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ScreenshotUtils;

public class WebDriverFactory extends BrowserFactory {

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    String sPathDriverMicrosoftEdge = DRIVER_FOLDER_PATH + "msedgedriver.exe";
    String sEdgeDriver = "webdriver.edge.driver";

    @BeforeTest(alwaysRun = true)
    public void suiteSetup() {
        switch (sBrowser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
            case "firefox":
                WebDriverManager.firefoxdriver().arch64().setup();
                break;
            case "edge":
                System.setProperty(sEdgeDriver, sPathDriverMicrosoftEdge);
//                WebDriverManager.edgedriver().setup();
                break;
            default: log.debug("Browser Not Found. Please Provide a Valid Browser");
        }
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Browser: " + sBrowser);
        System.out.println("WebsiteURL: " + BASE_URL);
        new WebDriverFactory();
        WebDriver driver = WebDriverFactory.createDriver();
        setWebDriver(driver);
    }

    public void setWebDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static WebDriver getWebDriver() {
        return threadLocal.get();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        String sTestName = result.getMethod().getMethodName();
        if (bScreenshot) {
           if (result.getStatus() == ITestResult.FAILURE) {
               ScreenshotUtils.takeScreenshot(driver, sTestName);
           }
        }
        getWebDriver().quit();
    }
}
