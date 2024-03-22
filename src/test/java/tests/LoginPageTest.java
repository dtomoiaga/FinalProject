package tests;

import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginScenario(){
        // Navigate to the Sign In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Mr", "Daniel", "Tom", "a@a.com", "Scoalainformala");
        homePage.clickSignOutButton();
        homePage.clickSignInButton();
        loginPage.enterEmail("a@b.com");
        loginPage.enterPassword("Scoalainformala");
    }
}
