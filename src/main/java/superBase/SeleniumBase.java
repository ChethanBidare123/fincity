package superBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase extends TestBase {

    /**
     *  Maximizes the browser
     */
    public void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    /**
     * Enters text
     *
     * @param webElement - web element
     * @param text - text
     */
    public void enterText(WebElement webElement, final String text){
        webElement.sendKeys(text);
    }

    /**
     * Click Operation
     *
     * @param webElement - Web element
     */
    public void clickAndWait(WebElement webElement){
        webElement.click();
    }

    /**
     *  Selects value from dropdown
     *
     * @param webElement - web Element
     * @param value - value
     */
    public void select(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    /**
     *  gets Text
     *
     * @param webElement- web element
     * @return - String
     */
    public String getText(WebElement webElement){
        return webElement.getText();
    }
}
