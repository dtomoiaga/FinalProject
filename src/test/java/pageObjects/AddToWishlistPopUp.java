package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToWishlistPopUp extends BasePage{
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[4]/div[1]/div/div/div[1]/h5")
    WebElement wishlistPopUpTitle;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[4]/div[1]/div/div/div[3]/a")
    WebElement createNewListButton;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li/p")
    WebElement myWishlistButton;


    // Constructor
    public AddToWishlistPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        wishlistPopUpTitle = wait.until(ExpectedConditions.visibilityOf(wishlistPopUpTitle));
        createNewListButton = wait.until(ExpectedConditions.visibilityOf(createNewListButton));
    }

    // Click on "My wishlist" button
    public void clickMyWishlistButton() { myWishlistButton.click(); }
}
