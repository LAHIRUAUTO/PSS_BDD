package PSS_Pages.PSS_Security_Page;

public class AdminSecurityPageMethods extends AdminSecurityPageObjects {

    public void clickRoleName () {
        explicitWaitElementVisible(roleNameLocator);
        doubleClick(roleNameLocator);
    }

    public void enterRoleName (String rolename) {
        explicitWaitElementVisible(roleNameFieldLocator);
        roleNameFieldLocator.sendKeys(rolename);
    }

    public void clickRoleSearchButton() {
        explicitWaitElementVisible(roleSearchButtonLocator);
        roleSearchButtonLocator.click();
    }

    public void clickUnAssignedFunctionRadioButton () {
        unAssignedFunctionRadioButton.isSelected();
        unAssignedFunctionRadioButton.click();
    }

    public void clickFunctionalSearchButton () {
        explicitWaitElementClickable(functionSearchButtonLocator);
        functionSearchButtonLocator.click();
    }


}
