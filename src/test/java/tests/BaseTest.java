package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utils.BrowserUtils;
import utils.ConstantUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private int screenshotIndex = 0;
    protected String baseUrl = "https://demo.prestashop.com";
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AllProductsPage allProductsPage;

    protected void navigateToHomePage() {
        driver.get(baseUrl);
    }



    @BeforeTest
    public void setUp() {
        // Initialize WebDriver based on browser name
        String browserName = System.getProperty("browser", "chrome"); // Default browser is Chrome
        driver = BrowserUtils.setUpBrowser(browserName);

        // Set up implicit wait and maximize window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to the base URL
        navigateToHomePage();

        WebElement iframe = driver.findElement(By.id("framelive"));
        driver.switchTo().frame(iframe);
    }


    public void closeBrowserAtEnd() {
        // Close WebDriver instance
        if (driver != null) {
            System.out.println("The browser was closed");
            driver.quit();
        }
    }

    @AfterTest
    public void cleanupAfterTest() {
        closeBrowserAtEnd();
    }

    protected void takeScreenshot() {
        File screenshotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        final String fileName = ConstantUtils.SCREENSHOT_FILE +
                screenshotIndex + ".png";
        File finalFile =
                new File(fileName);
        try {
            FileUtils.copyFile(screenshotFile, finalFile);
            Reporter.log("<img src='screenshot" +
                    screenshotIndex + ".png' width='400' height='400'>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        screenshotIndex++;
    }

    public void register() {
        // Navigate to the Sign-In page
        homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Register an account
        registerPage = new RegisterPage(driver);
        registerPage.register();
    }

    public void filterAccessories(){
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickAccessories();
        allProductsPage.clickWhite();
    }

    public void filterArt(){
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickArt();
        allProductsPage.clickMattPaper();
        allProductsPage.clickAvailable();
        allProductsPage.click40x60();
    }

    public void filterClothes(){
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickClothes();
        allProductsPage.clickSizeM();
        allProductsPage.clickLongSleeves();
    }
}

