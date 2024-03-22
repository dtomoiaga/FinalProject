package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://demo.prestashop.com";

    protected void navigateToHomePage() {
        driver.get(baseUrl);
    }
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver based on browser name
        String browserName = "chrome"; // Default browser
        driver = BrowserUtils.setUpBrowser(browserName);

        // Set up implicit wait and maximize window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to the base URL
        navigateToHomePage();

        WebElement iframe = driver.findElement(By.id("framelive"));
        driver.switchTo().frame(iframe);
    }

    @AfterMethod
    public void tearDown() {
        // Close WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}

