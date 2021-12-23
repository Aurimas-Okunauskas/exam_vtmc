package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommonPage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "list-view")
    private WebElement buttonListView;

    @FindBy(id = "button-cart")
    private WebElement buttonAddToCart;

    public void clickAddToWishlist() {
        driver.findElement(By.xpath("//*[@data-original-title = 'Add to Wish List']")).click();
    }

    public void clickButtonAddToCart() {
        buttonAddToCart.click();
    }

    public boolean isWarningDisplayed(String product) {
        return driver.findElement(By.xpath("//div[contains(@class, 'alert')]//a[contains(text(), '" + product +"')]")).isDisplayed();
    }
}
