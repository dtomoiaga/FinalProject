package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends BasePage{

    // Locators
   @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/a")
    WebElement createNewListButton;
   @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li/a/p")
   WebElement defaultWishlist;

    // Constructor
    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
    }

    // Click on "Create new list" button
    public void clickCreateNewListButton() {
        createNewListButton.click();
    }

    // Click on the default list "My wishlist"
    public void clickDefaultList(){
        defaultWishlist.click();
    }
}
