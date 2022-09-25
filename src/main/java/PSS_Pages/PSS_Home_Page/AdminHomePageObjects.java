package PSS_Pages.PSS_Home_Page;

import Utilities.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AdminHomePageObjects extends Utils {
    @FindBy(xpath = "/html/body/header/div[2]/div[2]/a/div\n")
    @CacheLookup
    WebElement userinfo;

    @FindBy(xpath = "//div[@class='tr u-name']")
    @CacheLookup
    WebElement loggedinuser;

    @FindBy(xpath = "//a[@id='btnChangePassword']")
    @CacheLookup
    WebElement changepassword;

    @FindBy(xpath = "//a[@class='logout']")
    @CacheLookup
    WebElement logoutbutton;

    public AdminHomePageObjects() throws IOException {
    }
}