import uiPages.LoginPage;

public class LoginPageStep extends LoginPage {

    /**
     *  Perfroms Login
     * @param userName - user name
     * @param pwd - password
     */
    public void login(final String userName,final String pwd){
        maximizeBrowser();
        enterEmail(userName);
        enterPassword(pwd);
        clickOnLoginButton();
    }
}
