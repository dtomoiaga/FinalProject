package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{

    // Locators
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    WebElement proceedToCheckoutButton;
    @FindBy(className = "cart-line-product-actions")
    WebElement deleteFromCart;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[1]/h1")
    WebElement shoppingCartTitle;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a")
    WebElement hummingBirdTshirt;

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
    }

    // Click on the Proceed to checkout button
    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }

    // Click on the delete from cart button
    public void clickDeleteFromCart(){
        deleteFromCart.click();
    }

    // Get the text from the newly created wishlist
    public String getShoppingCartTitleText() { return shoppingCartTitle.getText(); }

    // Get the text from the HummingBird T-shirt product
    public String getHummingBirdText() { return hummingBirdTshirt.getText(); }
}
