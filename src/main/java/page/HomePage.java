package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // elements
    @FindBy(partialLinkText = "Sukurti")
    private WebElement buttonSukurtiPaskyra;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonPrisijungti;
    @FindBy(xpath = "//*[@name='username']")
    private WebElement fieldUsername;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//span[contains(text(), 'prisijungimo vardas ir/ arba')]")
    private WebElement msgIncorrectCredentialsError;

    // actions
    public void clickButtonSukurtiPaskyra() {
        buttonSukurtiPaskyra.click();
    }

    public void clickButtonPrisijungti() {
        buttonPrisijungti.click();
    }

    public void enterUsername(String username) {
        fieldUsername.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        fieldPassword.sendKeys(pwd);
    }

    public boolean isIncorrectCredentialsErrorDisplayed() {
        return msgIncorrectCredentialsError.isDisplayed();
    }
}
