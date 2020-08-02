import constants.CommonConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import superBase.TestBase;
import utils.WaitUtils;

public class TC001_VerifySignUpProcess extends TestBase {
    public SignUpPageStep signUpPageStep;

    @Test(dataProvider = "inputData")
    private void verifySignUpProcess(String firstName, String surName,String emailAddress,String pwd, String dob){
        signUpPageStep = new SignUpPageStep();
        signUpPageStep.doRegistration(firstName,surName,emailAddress,pwd,dob);
        Assert.assertEquals(signUpPageStep.getErrorMessage(),CommonConstants.SIGNUP_ERROR_MESSAGE);
    }

    @DataProvider(name = "inputData")
    public Object[][] data() throws Exception {
        String[][] getData = readExcel(CommonConstants.INPUT_EXCEL_NAME,CommonConstants.SHEET_NAME_FB_SIGN_UP);
        return getData;
    }
}
