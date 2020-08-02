import uiPages.SignUpPage;

public class SignUpPageStep extends SignUpPage {

    /**
     * Registration Process
     *
     * @param firstName - String
     * @param surName - String
     * @param emailId - String
     * @param pwd - String
     * @param dob - String
     */
    public void doRegistration(String firstName, String surName, String emailId,String pwd, String dob){
        enterFirstName(firstName);
        enterSurName(surName);
        enterEmail(emailId);
        enterPwd(pwd);
        selectDob(dob);
        selectGender();
        reEnterEmail(emailId);
        clickOnSignUp();
    }


}
