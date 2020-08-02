import org.testng.Assert;
import org.testng.annotations.Test;
import superBase.TestBase;

public class TC002_LoginProfileverification extends TestBase {
    private LoginPageStep loginPageStep;
    private HomePageStep homePageStep;

    @Test
    private void verifyLoginAndProfile(){
        loginPageStep = new LoginPageStep();
        homePageStep = new HomePageStep();
        loginPageStep.login(properties.getProperty("userName"),properties.getProperty("password"));
        String placeName = homePageStep.getLivesIn();
        Assert.assertTrue(placeName.contains("Bangalore"));
    }
}
