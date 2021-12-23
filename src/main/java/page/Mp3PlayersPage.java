package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mp3PlayersPage extends CommonPage {
    public Mp3PlayersPage(WebDriver driver) {
        super(driver);
    }

    // buttons
    @FindBy(id = "list-view")
    private WebElement buttonListView;



}
