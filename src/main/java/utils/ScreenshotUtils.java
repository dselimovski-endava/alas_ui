package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils extends LoggerUtils {

    private static String createScreenshotPath(String sTestName) {
        return PropertyVariables.SCREENSHOT_FOLDER_PATH + sTestName + ".png";
    }

    public static String takeScreenshot(WebDriver driver, String sTestName) {
        log.debug("takeScreenshot(" + sTestName + ")");
        if (driver == null) {
            log.warn("Screenshot for test '" + sTestName + "' could NOT be taken!!! Driver instance has quit!!!");
            return null;
        }
        String sPathToFile = createScreenshotPath(sTestName);
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(sPathToFile);
        try {
            FileUtils.copyFile(sourceFile,destinationFile);
            log.info("Screenshot for test '" + sTestName + "' is saved in file: " + sPathToFile);
        } catch (IOException e) {
            log.warn("Screenshot for test '" + sTestName + "' could NOT be saved in file '" + sPathToFile + "'. Message: " + e.getMessage());
            return null;
        }
        return sPathToFile;
    }
}
