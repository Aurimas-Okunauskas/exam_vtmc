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
        assertTrue(mp3PlayersPage.findProduct("iPod Classic").isDisplayed());
        mp3PlayersPage.clickOnProduct("iPod Classic");
        mp3PlayersPage.clickAddToWishlist();
        waitForJS(driver);
        assertTrue(mp3PlayersPage.isWarningDisplayed());
        driver.navigate().refresh();
        mp3PlayersPage.clickButtonAddToCart();
        waitForJS(driver);
        assertTrue(mp3PlayersPage.isWarningDisplayed());

        Assert.assertTrue(mp3PlayersPage.printNumberOfItemsInCart().contains("1 item"));




    }

    @DataProvider
    public Object[][] parameters() {
        return new Object[][]{
                {"iPod Classic"}

        }

    }


}
