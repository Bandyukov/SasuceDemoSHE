package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkNegativeLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.loginNegative("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.loginNegative("standard_user", "");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkNegativeLoginWithBadCredentials() {
        loginPage.open();
        loginPage.loginNegative("user", "pass");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isPageOpen());
    }
}
