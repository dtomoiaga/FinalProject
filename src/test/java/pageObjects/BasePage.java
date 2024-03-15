package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    By pageTitle = By.cssSelector("div.content > h1");
    WebElement pageTitleElement;

    By leftMenuItems = By.cssSelector("div.sidebar > a[href]");
    private List<WebElement> leftMenuButtons;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLeftMenuItem(String buttonName) {
        WebElement buttonElement = getButtonElement(buttonName);
        assert buttonElement != null;
        buttonElement.click();
    }

    private WebElement getButtonElement(String buttonName) {
        leftMenuButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(leftMenuItems));
        for (WebElement buttonElement : leftMenuButtons) {
            if (buttonElement.getText().equalsIgnoreCase(buttonName)) {
                return buttonElement;
            }
        }
        return null;
    }

    public abstract void waitForPageToLoad();

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void writeAlertText(String message) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
    }
}
