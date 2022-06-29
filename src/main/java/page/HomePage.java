package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // elements
    @FindBy(linkText = "Sukurti naują paskyrą")
    private WebElement buttonSukurtiPaskyra;

    @FindBy(linkText = "Prisijungti")
    private WebElement buttonPrisijungti;

    @FindBy(xpath = "//*[@name='username']")
    private WebElement fieldUsername;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement fieldPassword;

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

    public void enterPasswoerd(String pwd) {
        fieldUsername.sendKeys(pwd);
    }

}
