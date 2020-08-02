package superBase;

import constants.CommonConstants;
import excelManager.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public Properties properties;
    public static String testName ;
    public static HashMap<Integer,ArrayList<Object>> resultMap = new HashMap<Integer,ArrayList<Object>>();
    public static WebDriverWait wait;

    private void selectBrowser(final String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",CommonConstants.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,60);
        } else if (browserType.equalsIgnoreCase("firfox")) {
            System.setProperty("webdriver.gecko.driver",CommonConstants.FIREFOX_PATH);
            driver = new FirefoxDriver();
        }

    }

    /**
     * Loads property File
     *
     * @param filePath - path
     */
    public void loadPropertyFile(String filePath){
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets Base url
     *
     * @param url - url
     */
    public void getBaseUrl(final String url){
        driver.get(url);
    }

    /**
     *  initialization
     */
    public void init(){
        loadPropertyFile( CommonConstants.TEST_SELENIUM_PROPERTY_FILE_PATH);
        selectBrowser(properties.getProperty("browserType"));
        getBaseUrl(properties.getProperty("baseUrl"));
    }

    /**
     *  Reads Excel Sheet data
     *  @param excelName - Excel Name
     *  @param sheetName - Sheet Name
     *
     * @return - String[][]
     */
    public String[][] readExcel(String excelName,String sheetName) throws Exception {
        ExcelReader reader = new ExcelReader(CommonConstants.INPUT_EXCEL_FILE_PATH);
        return reader.getDataFromSheet(excelName, sheetName);
    }


    /**
     *  Gets the result of the Test Case
     *
     * @param Result - ItestResult
     * @return - String
     *
     */
    public String getResult(ITestResult Result) throws IOException{
        if(Result.getStatus()==ITestResult.SUCCESS){
            return "PASSED";
        }
        else if(Result.getStatus()==ITestResult.FAILURE){
            return "FAILED";

        }
        else if(Result.getStatus()==ITestResult.SKIP){
            return "SKIPPED";
        }
        else if(Result.getStatus()==ITestResult.STARTED){
            return "STARTED";
        }
        return "NO RESULT";
    }



    @BeforeMethod
    public void beforeMethod(Method result){
        testName = result.getName();
        init();
    }

    @AfterMethod
    public void afterMethod(ITestResult Result) throws IOException {
        ArrayList<Object> testResult = new ArrayList<Object>();
        testResult.add(resultMap.size()+1);
        testResult.add(Result.getName());
        testResult.add(getResult(Result));
        testResult.add(CommonUtils.getDateFullPatternAsString());
        testResult.add((Result.getEndMillis()-Result.getStartMillis())/ 1000);
        testResult.add("Dummy comment. Need to set Pre requisite or return data");
        resultMap.put(resultMap.size()+1,testResult);
        driver.quit();
    }

}
