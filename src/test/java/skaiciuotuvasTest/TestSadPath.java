package skaiciuotuvasTest;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreateUserPage;
import page.HomePage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestSadPath extends BaseTest {
    @Test
    public void testSadPath() {
        //
        String username = randomAlphanumeric(10);
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);

        homePage.clickButtonSukurtiPaskyra();
        createUserPage.fillFormClickSubmit(username, "abc", "123");
        Assert.assertTrue(createUserPage.isErrorDisplayed());
    }
}
