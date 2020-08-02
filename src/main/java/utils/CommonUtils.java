package utils;

import constants.CommonConstants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import superBase.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtils extends TestBase {

    /**
     * get today's date
     *
     * @return - String - requested date as string
     */
    public static String getDateFullPatternAsString() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(cal.getTime());
    }

    public static String getTimeAsString() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(cal.getTime());
    }

    /**
     *  Takes Screenshot
     *  @param methodName - Method Name
     *  @param packageFolder - Package Folder
     */
    public static String getScreenshot(String methodName, String packageFolder){

        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File file = new File(CommonConstants.OUTPUT_FOLDER_PATH + packageFolder);
            file.mkdirs();
            String ReportDirectory = CommonConstants.OUTPUT_FOLDER_PATH + packageFolder + "//";
            String destination = ReportDirectory + methodName+"_"+ getDateFullPatternAsString() + "_"+ getTimeAsString() +".png";
            File destFile = new File(destination);
            FileHandler.copy(srcFile, destFile);

            return destination ;
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
