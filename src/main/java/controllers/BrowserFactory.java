package controllers;

import data.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertyVariables;

import java.util.concurrent.TimeUnit;

public class BrowserFactory extends PropertyVariables {
    protected static WebDriver driver;

    static WebDriver createDriver() {
        switch(sBrowser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default: log.debug("Browser Not Found. Please Provide a Valid Browser!!!");
        }
        implicitlyWait(Time.SHORTER);
        setMaxPageLoadTime(Time.SHORT);
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        return driver;
    }

    public static void implicitlyWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    public static void setMaxPageLoadTime(int timeInSeconds){
        driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
    }
}
