package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import dataProviders.DBDataProviders;

public class LoginPageTest extends BaseTest {
    @Test(dataProvider = "login_errors_sql", dataProviderClass = DBDataProviders.class,
            description = "Login using data from DB", groups = {"Smoke tests", "Regression tests"})
    public void loginUsingDataFromDB(String username, String password, String authenticationErrorMessage) {
        // Register an account and sign out
        register();
        homePage.clickSignOutButton();

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
    }
}
