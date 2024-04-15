package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import objectModels.RegistrationModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterPageTest extends BaseTest {

    @DataProvider(name = "jsonDP")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\Data\\testData.json");

        RegistrationModel[] rmList = objectMapper.readValue(file, RegistrationModel[].class);

        for (RegistrationModel rm : rmList)
            dp.add(new Object[]{rm});

        return dp.iterator();
    }


    @Test(dataProvider = "jsonDP")
    public void registerUsingStaticData(RegistrationModel registrationModel) {
        try {
            // Navigate to the Sign-In page
            HomePage homePage = new HomePage(driver);
            homePage.clickSignInButton();

            // Navigate to the Create Account page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickCreateAccountButton();

            // Fill in the registration form
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.clickMrRadioButton();

            registerPage.enterFirstName(registrationModel.getFirstName());
            registerPage.enterLastName(registrationModel.getLastName());
            registerPage.enterEmail(registrationModel.getEmail());
            registerPage.enterPassword(registrationModel.getPassword());
            registerPage.clickCheckboxes();
            registerPage.clickSaveButton();
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}


