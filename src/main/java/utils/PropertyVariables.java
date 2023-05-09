package utils;

public class PropertyVariables extends LoggerUtils {

    public static PropertiesUtils propertiesUtils = new PropertiesUtils();

    public static final String BASE_URL = propertiesUtils.getBaseUrl();
    public static String sBrowser = propertiesUtils.getBrowser();
    public static boolean bRemote = propertiesUtils.isRemote();
    public static boolean bScreenshot = propertiesUtils.isTakeScreenshot();
    public static final String HUB_URL = propertiesUtils.getHubUrl();
    public static final String DRIVER_FOLDER_PATH = propertiesUtils.getDriversFolder();
    public static final String SCREENSHOT_FOLDER_PATH = propertiesUtils.getScreenshotFolder();

    public static String sStandardUsername = propertiesUtils.getStandardUsername();
    public static String sLockedOutUsername = propertiesUtils.getLockedOutUsername();
    public static String sProblemUsername = propertiesUtils.getProblemUsername();
    public static String sPerformanceGlitchUsername = propertiesUtils.getPerformanceGlitchUsername();
    public static String sPassword = propertiesUtils.getDefaultPassword();
}
