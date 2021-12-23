package page;

import org.openqa.selenium.By;
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

    @FindBy(id = "button-cart")
    private WebElement buttonAddToCart;

    public WebElement findProduct(String product) {
        return driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='" + product +"']]"));
    }

    public void clickOnProduct(String product) {
        driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='" + product + "']]//h4/a")).click();
    }

    public void clickAddToWishlist() {
        driver.findElement(By.xpath("//*[@data-original-title = 'Add to Wish List']")).click();
    }

    public void clickButtonAddToCart() {
        buttonAddToCart.click();
    }

    public boolean isWarningDisplayed() {
        return driver.findElement(By.xpath("//div[contains(@class, 'alert')]//a[contains(text(), 'iPod Classic')]")).isDisplayed();
    }


}
