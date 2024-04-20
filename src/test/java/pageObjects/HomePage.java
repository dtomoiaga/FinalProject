package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(id = "_desktop_cart")
    private WebElement cartButton;
    @FindBy(id = "_desktop_user_info")
    private WebElement signInButton;
    @Getter
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
    WebElement signOutButton;
    @FindBy(xpath = "/html/body/main/section/div/div/div/section/section/section[1]/a")
    WebElement allProductsButton;
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[5]/a")
    WebElement wishlistButton;
    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[3]/a")
    WebElement ordersButton;
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/div/div[1]/article/div/button/i")
    WebElement articleOneWishlistButton;
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/div/div[1]/article/div/div[2]/h3/a")
    WebElement hummingbirdTShirt;

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

    // Click on "Orders" button
    public void clickOrdersButton() {
        ordersButton.click();
    }

    // Click on "Add article 1 to wishlist" button
    public void clickArticleOneWishlistButton() {
        articleOneWishlistButton.click();
    }

    // Get the text from the Hummingbird T-shirt title
    public String getHummingbirdTShirtText() {
        return hummingbirdTShirt.getText();
    }
}
