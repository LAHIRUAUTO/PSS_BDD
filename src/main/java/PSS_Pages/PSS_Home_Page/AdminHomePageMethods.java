package PSS_Pages.PSS_Home_Page;

import org.openqa.selenium.By;

import java.io.IOException;

public class AdminHomePageMethods extends AdminHomePageObjects{

    public AdminHomePageMethods() throws IOException {
    }

    public void gotologgedInUserinfor() {
        explicitWaitElementVisible (userinfo);
        mouseHover(userinfo);
        //System.out.println(userinfo.getText());
    }

    public void clickToogleMenu () throws InterruptedException {
        explicitWaitElementVisible(tooglemenu);
        explicitWaitElementClickable(tooglemenu);
        threadSleep();
        click(tooglemenu);
    }

    public void mouseHoweMaintenance () {
        fluentWaitElementVisible(maintenancetab);
        mouseHover(maintenancetab);
    }

    public void mouseHoweDashBooard () {
        fluentWaitElementVisible(dashboard);
        mouseHover(dashboard);
    }

    public void mouseHoweSecurity () {

        mouseHover(security);
    }

    public void clickrole () {
        explicitWaitElementVisible(role);
        click(role);
    }

    public void swithToIframe () {
        driver.switchTo().frame(1);

    }

    public void swithToDefault () {
        driver.switchTo().defaultContent();

    }





    public void clickFunctionUsage () {
        explicitWaitElementVisible(functionalUsage);
        click(functionalUsage);
    }

    public void mouseHoweGeography () {
        mouseHover(geography);
    }

    public void clickAirport () {
        airport.click();
    }


    public void clickLogoutButton () {

        logoutbutton.click();
    }



}
