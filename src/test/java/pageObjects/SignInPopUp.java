package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPopUp extends BasePage{
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[7]/div[1]/div/div/div[1]/h5")
    WebElement signInPopUp;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div[1]/div[7]/div[1]/div/div/div[3]/button")
    WebElement signInPopUpCancelButton;


    public SignInPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        signInPopUp = wait.until(ExpectedConditions.visibilityOf(signInPopUp));
        signInPopUpCancelButton = wait.until(ExpectedConditions.visibilityOf(signInPopUpCancelButton));
    }

    // Click on "Cancel Sign In pop-up" button
    public void clickCancelSignInPopUp() { signInPopUpCancelButton.click(); }

    // Check if the Sign In pop-up is displayed
    public boolean isSignInPopUpDisplayed() { return signInPopUp.isDisplayed(); }
}
