package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends AbstractPage {
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "MP3 Players")
    private WebElement buttonMP3Players;

    @FindBy(linkText = "Show All MP3 Players")
    private WebElement buttonShowAllMp3Players;

    @FindBy (id = "cart-total")
    private WebElement buttonCartTotal;

    public void clickMp3Players() {
        buttonMP3Players.click();
    }

    public void clickShowAllMp3Players() {
        buttonShowAllMp3Players.click();
    }

    public String printNumberOfItemsInCart() {
        return buttonCartTotal.getText();
    }
}
