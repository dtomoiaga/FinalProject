package pageObjects;
import lombok.Getter;
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
   @FindBy(xpath = "/html/body/main/footer/div[2]/div/div[1]/div[6]/div[1]/div/div/div[2]/div/input")
   WebElement wishlistNameTextBox;

   @Getter
   @FindBy(className = "wishlist-list-item-title")
   WebElement wishListItemContainer;
   @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[6]/div[1]/div/div/div[3]/button[2]")
   WebElement createWishlistButton;
   @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/a/p")
   WebElement newWishlistText;
   @FindBy(xpath = "//*[@id=\"content\"]/ul/li/div/a/div[2]/p[1]")
   WebElement hummingbirdTshirtText;

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

    // Click on the Add name field from the Create wishlist dialog
    public void addWishlistName(){ wishlistNameTextBox.sendKeys("TestWishlist");}

    // Click on the Create wishlist button from the Create wishlist popup
    public void clickCreateWishlistButton() { createWishlistButton.click();}

    // Get the text from the newly created wishlist
    public String getWishlistText() { return newWishlistText.getText(); }

    // Get the text from the Hummingbird T-shirt item
    public String getHummingbirdTShirtText(){ return hummingbirdTshirtText.getText(); }
}
