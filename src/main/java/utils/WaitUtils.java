package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import superBase.SeleniumBase;

public class WaitUtils extends SeleniumBase {

    /**
     * Waits until the text Appears
     * @param webElement - web element
     * @param text - text
     */
    public static void waitForTextToAppear(WebElement webElement,String text){
        wait.until(ExpectedConditions.textToBePresentInElement(webElement,text));
    }

    /**
     * Waits until the Element Appears
     * @param webElement - web element
     */
    public static void waitForElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
