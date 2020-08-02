package uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import superBase.SeleniumBase;

public class LoginPage extends SeleniumBase {


    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(id = "loginbutton")
    WebElement loginbutton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * Enters email
     *
     * @param emailId - email id
     */
    public void enterEmail(final String emailId){
        enterText(email,emailId);
    }

    /**
     * Enters pwwd
     *
     * @param pwd - pwd
     */
    public void enterPassword(final String pwd){
        enterText(password,pwd);
    }

    /**
     * Clicsk On Login Button
     */
    public void clickOnLoginButton(){
        clickAndWait(loginbutton);
    }


}
