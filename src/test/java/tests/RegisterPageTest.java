package tests;

import org.testng.annotations.Test;
import pageObjects.*;

public class RegisterPageTest extends BaseTest {

    @Test(description = "Register Scenario")
    public void registerScenario() {

        // Navigate to the Sign In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();


        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Fill in the registration form
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickMrRadioButton();
        //insert methods for First name and Last name created in CreateAccountPage
        registerPage.enterEmail("a@a.com");
        registerPage.enterPassword("Scoalainformala");
        registerPage.clickCheckboxes();
        registerPage.clickSaveButton();
    }
}


