package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    // Locators
    @FindBy(id= "field-firstname")
    WebElement firstNameField;
    @FindBy(id= "field-lastname")
    WebElement lastNameField;
    @FindBy(id= "field-id_gender-1")
    WebElement mrRadioButton;
    @FindBy(id= "field-id_gender-2")
    WebElement mrsRadioButton;
    @FindBy(css = "#customer-form > footer > button")
    WebElement saveButton;
    @FindBy(id= "field-email")
    WebElement emailField;
    @FindBy(id= "field-password")
    WebElement passwordField;
    private By checkboxesLocator = By.xpath("//input[@type='checkbox']");

    // Register method
    public void register(String title, String firstName, String lastName, String email, String password){
        if(title == "Mr"){
            clickMrRadioButton();
        } else if (title == "Mrs") {
            clickMrsRadioButton();
        }
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        clickCheckboxes();
        clickSaveButton();
    }

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
    }

    // Click on "Mr." radio button
    public void clickMrRadioButton() {
        mrRadioButton.click();
    }

    // Click on "Mrs." radio button
    public void clickMrsRadioButton(){
        mrsRadioButton.click();
    }

    // Enter text into First name field
    public void enterFirstName(String firstNameText){
        firstNameField.clear();
        firstNameField.sendKeys(firstNameText);
    }

    // Enter text into Last name field
    public void enterLastName(String lastNameText){
        lastNameField.clear();
        lastNameField.sendKeys(lastNameText);
    }

    // Click on all checkboxes
    public void clickCheckboxes() {
        for (int i = 0; i < driver.findElements(checkboxesLocator).size(); i++) {
            driver.findElements(checkboxesLocator).get(i).click();
        }
    }

    // Click on "SAVE" button
    public void clickSaveButton() {
        saveButton.click();
    }

    // Enter email
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    // Enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
}
