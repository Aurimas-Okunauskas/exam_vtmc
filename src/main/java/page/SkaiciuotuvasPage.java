package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkaiciuotuvasPage extends AbstractPage {
    public SkaiciuotuvasPage(WebDriver driver) {
        super(driver);
    }

    // elements
    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    private WebElement btnLogout;

    // actions
    public void clickBtnLogout() {
        btnLogout.click();
    }

    public String getBtnLogoutText() {
        return btnLogout.getText();
    }
}
