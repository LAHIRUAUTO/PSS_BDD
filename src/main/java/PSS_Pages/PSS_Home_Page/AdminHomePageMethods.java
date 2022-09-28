package PSS_Pages.PSS_Home_Page;

import java.io.IOException;

public class AdminHomePageMethods extends AdminHomePageObjects{

    public AdminHomePageMethods() throws IOException {
    }

    public void gotologgedInUserinfor() {
        explicitWaitElementVisible (userinfo);
        mouseHover(userinfo);
        //System.out.println(userinfo.getText());
    }

    public void clickToogleMenu () {
        explicitWaitElementClickable(tooglemenu);
        click(tooglemenu);
    }

    public void mouseHoweMaintenance () {

        mouseHover(maintenancetab);
    }

    public void mouseHoweSecurity () {

        mouseHover(security);
    }

    public void clickrole () {
        explicitWaitElementVisible(role);
        click(role);
    }

    public void clickLogoutButton () {

        logoutbutton.click();
    }



}
