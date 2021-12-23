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


    public WebElement findProduct(String product) {
        return driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='" + product +"']]//h4/a"));
    }

    public void clickOnProduct(String product) {
        driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='" + product + "']]//h4/a")).click();
    }




}
