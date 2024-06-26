package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import pageObjects.AllProductsPage;
import pageObjects.AddToCartPopUp;
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
    CheckoutPage checkoutPage;
    ProductPage productPage;
    AllProductsPage allProductsPage;
    AddToCartPopUp addToCartPopUp;

    protected void navigateToHomePage() {
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver based on browser name
        String browserName = System.getProperty("browser", "chrome"); // Default browser is Chrome
        driver = BrowserUtils.setUpBrowser(browserName);

        // Set up implicit wait and maximize window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to the base URL
        navigateToHomePage();

        // The page has an overlay and no elements can be found; a switch to the iframe under the overlay is needed
        WebElement iframe = driver.findElement(By.id("framelive"));
        driver.switchTo().frame(iframe);
    }

    @AfterMethod
    public void cleanupAfterMethod() {
        try {
            closeBrowserAtEnd();
        } catch (Exception e) {
            System.out.println("An exception occurred during WebDriver cleanup:");
            e.printStackTrace();
        }
    }

    private void closeBrowserAtEnd() {
        // Close WebDriver instance
        if (driver != null) {
            System.out.println("The browser was closed");
            driver.quit();
        }
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

    public void addProductToCart() {
        // Navigate to the "All products" page
        homePage.clickAllProductsButton();

        // Click on the HummingBird T-shirt
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickHummingBirdTshirt();

        // Click on the Add to cart button
        productPage = new ProductPage(driver);
        productPage.clickProductCartButton();

        // Click on the Proceed to Checkout button
        addToCartPopUp = new AddToCartPopUp(driver);
        addToCartPopUp.clickProceedToCheckoutButton();
    }

    public void completeOrder() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCountry("France");
        checkoutPage.enterAlias("Mr");
        checkoutPage.enterCompany("Scoala Informala");
        checkoutPage.enterVatNumber("1234");
        checkoutPage.enterAddress1("Libertatii 1");
        checkoutPage.enterAddress2("Republicii 2");
        checkoutPage.enterZipCode("12345");
        checkoutPage.enterCity("Cluj-Napoca");
        checkoutPage.enterPhone("9898989");
        checkoutPage.clickAddressContinueButton();
        checkoutPage.selectMyCarrier();
        checkoutPage.clickShippingMethodContinueButton();
        checkoutPage.selectCashOnDelivery();
        checkoutPage.setTermsCheckbox();
        checkoutPage.clickPlaceOrderButton();
    }
}
