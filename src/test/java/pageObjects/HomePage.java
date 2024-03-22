package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    @FindBy(id= "_desktop_cart")
    WebElement cartButton;
    @FindBy(id= "_desktop_user_info")
    WebElement signInButton;
    @FindBy(id= "_desktop_user_info")
    WebElement signOutButton;
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/a")
    WebElement allProductsButton;
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[5]/a")
    WebElement wishlistButton;
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[3]/a")
    WebElement ordersButton;

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        cartButton = wait.until(ExpectedConditions.visibilityOf(cartButton));
        signInButton = wait.until(ExpectedConditions.visibilityOf(signInButton));
    }

    // Click on "Sign in" button
    public void clickSignInButton() {
        signInButton.click();
    }

    // Click on "Sign out" button
    public void clickSignOutButton() {
        signOutButton.click();
    }

    // Click on "Wishlist" button
    public void clickWishlistButton() {
        wishlistButton.click();
    }

    // Click on "All products" button
    public void clickAllProductsButton() {
        allProductsButton.click();
    }

    // Click on "Cart" button
    public void clickCartButton() {
        cartButton.click();
    }

    // Click on "Orders" button
    public void clickOrdersButton() {
        ordersButton.click();
    }
}
