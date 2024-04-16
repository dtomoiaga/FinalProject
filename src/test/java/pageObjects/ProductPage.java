package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    WebElement hummingBirdTshirtCartButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/h1")
    WebElement hummingBirdTshirtTitle;

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
    }

    // Click on the Add to cart button from the HummingBird T-shirt product page
    public void clickHummingBirdTshirtCartButton() { hummingBirdTshirtCartButton.click(); }

    // Get the text from the Hummingbird T-shirt
    public String getHummingBirdTshirtTitleText(){ return hummingBirdTshirtTitle.getText();}
}
