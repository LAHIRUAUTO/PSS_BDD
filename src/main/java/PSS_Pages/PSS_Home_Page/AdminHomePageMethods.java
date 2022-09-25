package PSS_Pages.PSS_Home_Page;

import java.io.IOException;

public class AdminHomePageMethods extends AdminHomePageObjects{

    public AdminHomePageMethods() throws IOException {
    }

    public void gotologgedInUserinfor() {
        explicitWaitElementVisible ("/html/body/header/div[2]/div[2]/a/div\n");
        mouseHover(userinfo);
        //System.out.println(userinfo.getText());
    }

    public void clickLogoutButton () {
        logoutbutton.click();
    }



}
