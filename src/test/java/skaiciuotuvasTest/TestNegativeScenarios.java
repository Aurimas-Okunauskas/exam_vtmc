package skaiciuotuvasTest;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreateUserPage;
import page.HomePage;
import page.SkaiciuotuvasPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestNegativeScenarios extends BaseTest {
    String username = randomAlphanumeric(15);
    String pwd = randomAlphanumeric(15);

    @Test
    public void testCreateUserIncorrectPwdConfirm() {
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);
        homePage.clickButtonSukurtiPaskyra();
        createUserPage.fillFormClickSubmit(username, pwd, "Incorrect");
        Assert.assertTrue(createUserPage.isPwdConfirmErrorDisplayed());
    }

    @Test
    public void testUserExists() {
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);
        SkaiciuotuvasPage skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
        String username = randomAlphanumeric(15);
        String pwd = randomAlphanumeric(15);

        homePage.clickButtonSukurtiPaskyra();
        createUserPage.fillFormClickSubmit(username, pwd, pwd);
        skaiciuotuvasPage.clickBtnLogout();
        homePage.clickButtonSukurtiPaskyra();
        createUserPage.fillFormClickSubmit(username, pwd, pwd);
        Assert.assertTrue(createUserPage.isUsernameErrorDisplayed());
        Assert.assertTrue(createUserPage.getUsernameErrorText().contains("jau egzistuoja"));
    }

    @Test
    public void testLoginIncorrectPassword() {
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);
        SkaiciuotuvasPage skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
        homePage.clickButtonSukurtiPaskyra();
        createUserPage.fillFormClickSubmit(username, pwd, pwd);
        skaiciuotuvasPage.clickBtnLogout();
        homePage.enterUsername(username);
        homePage.enterPassword("Incorrect");
        homePage.clickButtonPrisijungti();
        Assert.assertTrue(homePage.isIncorrectCredentialsErrorDisplayed());
    }

    @Test
    public void testCreateNewUserErrors() {
        HomePage homePage = new HomePage(driver);
        CreateUserPage createUserPage = new CreateUserPage(driver);
        homePage.clickButtonSukurtiPaskyra();
        createUserPage.enterUsername("as");
        createUserPage.clickSubmit();
        Assert.assertTrue(createUserPage.getUsernameErrorText().contains("nuo 3 iki 32"));
        createUserPage.enterPassword("as");
        createUserPage.clickSubmit();
        Assert.assertTrue(createUserPage.getPwdErrorText().contains("bent 3 simbolius"));
        createUserPage.clearFields();
        createUserPage.clickSubmit();
        Assert.assertTrue(createUserPage.isUsernameErrorDisplayed());
        Assert.assertTrue(createUserPage.getUsernameErrorText().contains("pildyti"));
        Assert.assertTrue(createUserPage.isPwdErrorDisplayed());
        Assert.assertTrue(createUserPage.getPwdErrorText().contains("pildyti"));
    }


}
