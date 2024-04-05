package pageObjects;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Locators
    @FindBy(className = "no-account")
    WebElement createAccountButton;
    @FindBy(id = "submit-login")
    WebElement signInButton;
    @FindBy(id= "field-email")
    WebElement emailField;
    @FindBy(id= "field-password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/ul/li")
    WebElement authenticationErrorMessage;

    public void login(String username, String password) {
        System.out.println("Enter username:" + username);
        enterEmail(username);
        System.out.println("Enter password:" + password);
        enterPassword(password);
        clickSignInButton();
    }

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void waitForPageToLoad() {
    }

    // Click on "Create Account" button
    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    // Click on "Sign in" button
    public void clickSignInButton() {
        signInButton.click();
    }

    // Enter email
    public void enterEmail(String email){
    emailField.sendKeys(email);
    }

    // Enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    //create method de get error string ca sa iau error message
    public String getAuthenticationErrorMessage(){ return authenticationErrorMessage.getText(); }

}
