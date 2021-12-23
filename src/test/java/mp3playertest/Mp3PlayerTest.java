package mp3playertest;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CommonPage;
import page.Mp3PlayersPage;
import page.ProductPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static util.WaitForJS.waitForJS;

public class Mp3PlayerTest extends BaseTest {

    @Test (dataProvider = "parameters")
    public void mp3PlayerTest(String product) {
        CommonPage commonPage = new CommonPage(driver);
        Mp3PlayersPage mp3PlayersPage = new Mp3PlayersPage(driver);
        ProductPage productPage = new ProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        commonPage.clickMp3Players();
        commonPage.clickShowAllMp3Players();
        assertTrue(mp3PlayersPage.findProduct(product).isDisplayed());
        mp3PlayersPage.clickOnProduct(product);
        productPage.clickAddToWishlist();
        waitForJS(driver);
        assertTrue(productPage.isWarningDisplayed(product));
        driver.navigate().refresh();
        productPage.clickButtonAddToCart();
        waitForJS(driver);
        assertTrue(productPage.isWarningDisplayed(product));

        Assert.assertTrue(mp3PlayersPage.printNumberOfItemsInCart().contains("1 item"));


    }

    @DataProvider
    public Object[][] parameters() {
        return new Object[][]{
                {"iPod Classic"},
                {"iPod Nano"},
                {"iPod Touch"},
                {"My player"},

        };

    }


}
