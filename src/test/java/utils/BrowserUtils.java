package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {

    public static WebDriver setUpBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case ("chrome"): {
                return new ChromeDriver(getChromeOptions());
            }
            case ("firefox"): {
                return new FirefoxDriver();
            }
            case ("edge"): {
                return new EdgeDriver(getEdgeOptions());
            }
            default: {
                System.out.println("Unsupported browser. We will switch default to chrome");
                return new ChromeDriver();
            }
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--incognito");
        return options;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        return options;
    }

}