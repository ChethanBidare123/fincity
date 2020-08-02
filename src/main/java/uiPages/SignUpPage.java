package uiPages;

import constants.CommonConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import superBase.SeleniumBase;
import utils.WaitUtils;

public class SignUpPage extends SeleniumBase {

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement surName;

    @FindBy(name = "reg_email__")
    WebElement emailAddress;

    @FindBy(id = "password_step_input")
    WebElement password;

    @FindBy(name = "reg_email_confirmation__")
    WebElement reEnterEmailAddress;

    @FindBy(name = "sex")
    WebElement genderMale;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(name = "websubmit")
    WebElement signUpButton;

    @FindBy(id = "reg_error_inner")
    WebElement errorMsg;

    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     *  Enters First Name
     *
     * @param firstName - String
     */
    public void enterFirstName(String firstName){
        enterText(this.firstName,firstName);
    }

    /**
     *  Enters Sur name
     * @param surName - String
     */
    public void enterSurName(String surName){
        enterText(this.surName,surName);
    }

    public void enterEmail(String email){
        enterText(emailAddress,email);
    }

    public void reEnterEmail(String email){
        enterText(reEnterEmailAddress,email);
    }

    public void enterPwd(String pwd){
        enterText(password,pwd);
    }

    public void selectGender(){
        clickAndWait(genderMale);
    }

    public void selectDob(String year){
        select(this.year,year);
    }

    public void clickOnSignUp(){
        clickAndWait(signUpButton);
    }

    public String getErrorMessage(){
        WaitUtils.waitForTextToAppear(errorMsg,CommonConstants.SIGNUP_ERROR_MESSAGE);
        return getText(errorMsg);
    }

}
