package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import dataProviders.DBDataProviders;

public class LoginPageTest extends BaseTest {

    @BeforeTest
    public void registerAccount() {
        // Navigate to the registration page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Register an account
        register();

        // After registering an account, log out
        homePage.clickSignOutButton();
    }

    @Test(dataProvider = "login_errors_sql", dataProviderClass = DBDataProviders.class)
    public void loginUsingDataFromDB(String username, String password, String authenticationErrorMessage) {
        try {
            // Navigate to the Sign-In page
            HomePage homePage = new HomePage(driver);
            homePage.clickSignInButton();

            // Click the SignIn button and input login details
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);

            if (authenticationErrorMessage != null) {
                // Assert authentication error message
                Assert.assertTrue(loginPage.getAuthenticationErrorMessage().contains(authenticationErrorMessage));
            } else {
                // Assert successful login
                Assert.assertTrue(homePage.getSignOutButton().isDisplayed());

                // Log out after successful login
                homePage.clickSignOutButton();
            }
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}