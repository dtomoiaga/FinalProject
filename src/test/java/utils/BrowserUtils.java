package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserUtils {

    public static WebDriver setUpBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return setUpChrome();
            case "firefox":
                return setUpFirefox();
            case "edge":
                return setUpEdge();
            default:
                System.out.println("Unsupported browser: " + browserName + ". Defaulting to Chrome.");
                return setUpChrome(); // Default to Chrome
        }
    }

    private static WebDriver setUpChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--incognito");
        return new ChromeDriver(options);
    }

    private static WebDriver setUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private static WebDriver setUpEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        return new EdgeDriver(options);
    }
}
