package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    // Locators
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[1]/h1")
    private WebElement shoppingCartTitle;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a")
    WebElement productInCart;

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        shoppingCartTitle = wait.until(ExpectedConditions.visibilityOf(shoppingCartTitle));

    }

    // Click on the Proceed to checkout button
    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    // Get the text from the newly created wishlist
    public String getShoppingCartTitleText() {
        return shoppingCartTitle.getText();
    }

    // Get the text from the HummingBird T-shirt product
    public String getProductInCartText() {
        return productInCart.getText();
    }
}
