package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage extends AbstractPage {
    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    // elements
    @FindBy(id = "username")
    private WebElement fieldUsername;

    @FindBy(id = "password")
    private WebElement fieldPassword;

    @FindBy(id = "passwordConfirm")
    private WebElement fieldPasswordConfirm;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(id = "passwordConfirm.errors")
    private WebElement msgPwdConfirmError;

    @FindBy(id = "password.errors")
    private WebElement msgPwdError;

    @FindBy(id = "username.errors")
    private WebElement msgUsernameError;


    // actions
    public void enterUsername(String username) {
        fieldUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        fieldPasswordConfirm.sendKeys(password);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public boolean isPwdConfirmErrorDisplayed() {
        return msgPwdConfirmError.isDisplayed();
    }

    public boolean isPwdErrorDisplayed() {
        return msgPwdError.isDisplayed();
    }

    public String getPwdErrorText() {
        return msgPwdError.getText();
    }

    public boolean isUsernameErrorDisplayed() {
        return msgUsernameError.isDisplayed();
    }

    public String getUsernameErrorText() {
        return msgUsernameError.getText();
    }

    public void fillFormClickSubmit(String username, String pwd, String repeatPwd) {
        enterUsername(username);
        enterPassword(pwd);
        enterConfirmPassword(repeatPwd);
        clickSubmit();
    }

    public void clearFields() {
        fieldUsername.clear();
        fieldPassword.clear();
        fieldPasswordConfirm.clear();
    }
}
