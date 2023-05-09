package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import pageObjects.InitializePageObjects.PageFactoryInitializer;
import pageObjects.pages.BasePage;
import utils.PropertiesUtils;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;

public class TestListener extends PageFactoryInitializer implements ITestListener, ISuiteListener, IInvokedMethodListener {

    /*
    This belongs to ISuiteListener and will execute before the Suite Starts
    */
    @Override
    public void onStart(ISuite suite) {
        log.debug("----- [SUITE STARTED] -----");
    }

    /*
    This belongs to ISuiteListener and will execute after the Suite Ends
    */
    @Override
    public void onFinish(ISuite suite) {
        log.debug("----- [SUITE FINISHED] -----");
    }

    /*
    This belongs to ITestListener, It will execute at the time of Test Execution
    */
    @Override
    public void onStart(ITestContext context) {
        log.debug("----- [TEST STARTED] -----");
    }

    /*
    This belongs to ITestListener, It will execute at the End of Test
    */
    @Override
    public void onFinish(ITestContext context) {
        log.debug("----- [TEST FINISHED] -----");
    }

    /*
    This belongs to ITestListener, It will Execute only when the Test is Passed
    */
    @Override
    public void onTestSuccess(ITestResult result) {
        log.debug("----- [TEST PASSED]: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + " -----" );
    }

    /*
    This belongs to ITestListener, It will execute only if any of the Main Test(@Test) Gets Skipped
    */
    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("----- [TEST SKIPPED]: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + " -----" );
    }

    /*
    This belongs to ITestListener, It will execute only if any of the Main Test(@Test) Gets Failed
    */
    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("----- [TEST FAILED]: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + " -----" );
    }
}
