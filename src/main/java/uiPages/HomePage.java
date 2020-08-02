package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import superBase.SeleniumBase;
import utils.WaitUtils;

public class HomePage extends SeleniumBase {


    @FindBy(xpath = "//*[@class='j83agx80 fv0vnmcu fop5sh7t']/following-sibling::span")
    WebElement profile;



    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * Clicks on Profile
     */
    public void clickOnProfile(){
        clickAndWait(profile);
    }

    /**
     * Gets the Place
     *
     * @return - String
     */
    public String getLivesIn(){
        WaitUtils.waitForElement(driver.findElements(By.xpath("//*[@class='nc684nl6']/span")).get(1));
        return driver.findElements(By.xpath("//*[@class='nc684nl6']/span")).get(1).getText();
    }


}
