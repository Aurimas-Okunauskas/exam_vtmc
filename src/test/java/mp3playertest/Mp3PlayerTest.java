package mp3playertest;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CommonPage;
import page.Mp3PlayersPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static util.WaitForJS.waitForJS;

public class Mp3PlayerTest extends BaseTest {

    @Test
    public void mp3PlayerTest() {
        CommonPage commonPage = new CommonPage(driver);
        Mp3PlayersPage mp3PlayersPage = new Mp3PlayersPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        commonPage.clickMp3Players();
        commonPage.clickShowAllMp3Players();
        waitForJS(driver);
        assertTrue(driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='iPod Classic']]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() ='iPod Classic']]//h4/a")).click();
        driver.findElement(By.xpath("//*[@data-original-title = 'Add to Wish List']")).click();
        waitForJS(driver);
        assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert')]//a[contains(text(), 'iPod Classic')]")).isDisplayed());
        driver.navigate().refresh();
        mp3PlayersPage.clickButtonAddToCart();
        waitForJS(driver);
        assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert')]//a[contains(text(), 'iPod Classic')]")).isDisplayed());
        Assert.assertTrue(mp3PlayersPage.printNumberOfItemsInCart().contains("1 item"));


    }

}
