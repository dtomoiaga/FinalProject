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
}
