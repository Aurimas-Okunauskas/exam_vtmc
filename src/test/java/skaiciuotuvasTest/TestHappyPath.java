package skaiciuotuvasTest;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreateUserPage;
import page.HomePage;
import page.SkaiciuotuvasPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestHappyPath extends BaseTest {
    @Test
    public void testHappyPath() {
        // preconditions
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);
        SkaiciuotuvasPage skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
        String pwd = randomAlphanumeric(10);
        String username = randomAlphanumeric(10);

        // create user, login
        homePage.clickButtonSukurtiPaskyra();

        createUserPage.fillFormClickSubmit(username, pwd, pwd);
        Assert.assertTrue(skaiciuotuvasPage.getBtnLogoutText().contains(username));

        // logout
        skaiciuotuvasPage.clickBtnLogout();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "prisijungti?logout";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
