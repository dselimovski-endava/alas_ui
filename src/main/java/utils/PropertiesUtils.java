package utils;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("common.properties")
public class PropertiesUtils {

    public PropertiesUtils() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "baseUrl")
    private String baseUrl;

    @Property(value="browser")
    private String browser;

    @Property(value="remote")
    private boolean remote;

    @Property(value="takeScreenshot")
    private boolean takeScreenshot;

    @Property(value="hubUrl")
    private String hubUrl;

    @Property(value="driversFolder")
    private String driversFolder;

    @Property(value="screenshotFolder")
    private String screenshotFolder;

    @Property(value="standardUsername")
    private String standardUsername;

    @Property(value="lockedOutUsername")
    private String lockedOutUsername;

    @Property(value="problemUsername")
    private String problemUsername;

    @Property(value="performanceGlitchUsername")
    private String performanceGlitchUsername;

    @Property(value="defaultPassword")
    private String defaultPassword;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean isRemote() {
        return remote;
    }

    public boolean isTakeScreenshot() {
        return takeScreenshot;
    }

    public String getHubUrl() {
        return hubUrl;
    }

    public String getDriversFolder() {
        return driversFolder;
    }

    public String getScreenshotFolder() {
        return screenshotFolder;
    }

    public String getStandardUsername() {
        return standardUsername;
    }

    public String getLockedOutUsername() {
        return lockedOutUsername;
    }

    public String getProblemUsername() {
        return problemUsername;
    }

    public String getPerformanceGlitchUsername() {
        return performanceGlitchUsername;
    }

    public String getDefaultPassword() {
        return defaultPassword;
    }
}
