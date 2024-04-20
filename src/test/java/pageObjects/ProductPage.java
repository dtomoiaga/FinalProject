package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement productCartButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/h1")
    private WebElement productTitle;

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        productTitle = wait.until(ExpectedConditions.visibilityOf(productTitle));
        productCartButton = wait.until(ExpectedConditions.visibilityOf(productTitle));
    }

    // Click on the Add to cart button from the HummingBird T-shirt product page
    public void clickProductCartButton() {
        productCartButton.click();
    }

    // Get the text from the Hummingbird T-shirt
    public String getProductTitleText() {
        return productTitle.getText();
    }
}
