package PSS_Pages.PSS_Login_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import javax.xml.xpath.XPath;

public class AdminLoginPageObjects {


    @FindBy(xpath="//input[@id='j_username']")
    @CacheLookup
    WebElement usernamelocator;

    @FindBy(xpath="//input[@id='j_password']")
    @CacheLookup
    WebElement passwordlocator;

    @FindBy(xpath="//input[@id='btnLogin']")
    @CacheLookup
    WebElement loginButtonlocator;
}
