package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartPopUp extends BasePage{
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButton;


    // Constructor
    public AddToCartPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        continueShoppingButton = wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
    }

    // Click on the Continue Shopping button
    public void clickContinueShoppingButton() { continueShoppingButton.click(); }

    // Click on the Proceed to Checkout button
    public void clickProceedToCheckoutButton() { proceedToCheckoutButton.click(); }
}
