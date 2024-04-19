package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistoryPage extends BasePage{

    // Locators
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[6]/a[1]")
    WebElement orderDetailsButton;
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[6]/a[2]")
    WebElement reorderButton;
    @FindBy(xpath = "//*[@id=\"content\"]/table")
    public WebElement orderList;

    // Constructor
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
        orderDetailsButton = wait.until(ExpectedConditions.visibilityOf(orderDetailsButton));
        reorderButton = wait.until(ExpectedConditions.visibilityOf(reorderButton));
    }

    // Click on "Reorder" button
    public void clickReorderButton() {
        reorderButton.click();
    }
}
