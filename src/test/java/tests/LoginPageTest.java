package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "loginScenarios")
    public Object[][] dataProviderForLoginScenarios() {
        return new Object[][]{

                // Case 1 - valid username and password
                // username | password | authenticationErrorMessage
                {"email@email.com", "Scoalainformala", null},

                // Case 2 - valid username and invalid password
                // username | password | authenticationErrorMessage
                {"email@email.com", "wrongpassword", "Authentication failed."},

                // Case 3 - invalid username and valid password
                // username | password | authenticationErrorMessage
                {"wrongEmail@email.com", "Scoalainformala", "Authentication failed."},

                // Case 4 - invalid username and invalid password
                // username | password | authenticationErrorMessage
                {"wrongEmail@email.com", "wrongpassword", "Authentication failed."},

        };
    }
    @Test(dataProvider = "loginScenarios")
    public void loginScenarios(String username, String password, String authenticationErrorMessage){

        // Navigate to the Sign-In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Register an account
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Mr", "Daniel", "Tomoiaga", "email@email.com", "Scoalainformala");

        // After registering an account, the user is logged in already so a logout is necessary
        homePage.clickSignOutButton();

        // Click the SignIn button and input login details
        homePage.clickSignInButton();
        loginPage.login(username, password);

        if (authenticationErrorMessage != null) {
            Assert.assertTrue(loginPage.getAuthenticationErrorMessage().contains(authenticationErrorMessage));
        } else {
            Assert.assertTrue(homePage.getSignOutButton().isDisplayed());
        }
    }
}
