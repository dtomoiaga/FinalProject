package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage extends BasePage{

    // Locators
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[6]/a[1]")
    WebElement orderDetailsButton;
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[6]/a[2]")
    WebElement reorderButton;

    // Constructor
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
    }

    // Click on "Details" button
    public void clickDetailsButton() {
        orderDetailsButton.click();
    }

    // Click on "Reorder" button
    public void clickReorderButton() {
        reorderButton.click();
    }
}
