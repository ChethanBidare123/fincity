import uiPages.HomePage;

public class HomePageStep extends HomePage {

    /**
     *  Fetches Place
     * @return - String
     */
    public String getPlaceLivesIn(){
        clickOnProfile();
        return getLivesIn();
    }
}
