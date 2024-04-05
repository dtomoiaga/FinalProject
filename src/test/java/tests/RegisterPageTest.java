package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

public class RegisterPageTest extends BaseTest {
    @DataProvider(name = "registerScenarios")
        public Object[][] dataProviderForRegisterScenarios() {
            return new Object[][]{
                    // firstName | lastName | email | password
                    {"Daniel", "Tomoiaga", "email@email.com", "Scoalainformala"},
            };
    }

    @Test(dataProvider = "registerScenarios")
    public void registerScenarios(String firstName, String lastName, String email, String password) {

        // Navigate to the Sign-In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Fill in the registration form
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickMrRadioButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.clickCheckboxes();
        registerPage.clickSaveButton();
    }
}


