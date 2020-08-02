package constants;

public class CommonConstants {

    public static final String TEST_SELENIUM_PROPERTY_FILE_PATH = System.getProperty("user.dir") + "//src//main//resources//test-selenium.properties";
    public static final String CHROME_DRIVER_PATH =  System.getProperty("user.dir") + "//Drivers//chromedriver.exe";
    public static final String FIREFOX_PATH =  System.getProperty("user.dir") + "//Drivers//geckodriver.exe";
    public static final String INPUT_EXCEL_FILE_PATH = System.getProperty("user.dir")+"//src//main//resources//InputData.xlsx" ;
    public static final String INPUT_EXCEL_NAME = "InputData.xlsx";
    public static final String OUTPUT_FOLDER_PATH = System.getProperty("user.dir")+"//Output//";
    public static final String SIGNUP_ERROR_MESSAGE = "You have entered an invalid email address. Please check your email address and try again.";
    public static final String SHEET_NAME_FB_SIGN_UP = "VerifyFbSignUp";
}
