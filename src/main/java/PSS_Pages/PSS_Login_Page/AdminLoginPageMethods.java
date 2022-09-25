package PSS_Pages.PSS_Login_Page;

public class AdminLoginPageMethods extends AdminLoginPageObjects {

    public void enterUsername (String username) {
        usernamelocator.sendKeys(username);
    }

    public void enterPassword (String password) {
        passwordlocator.sendKeys(password);
    }

    public void clickLoginbutton (){
        loginButtonlocator.click();
    }
}
