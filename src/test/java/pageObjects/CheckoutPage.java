package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    // Locators for the Addresses section of the checkout
    @FindBy(id = "field-alias")
    public WebElement aliasField;
    @FindBy(id = "field-company")
    public WebElement companyField;
    @FindBy(xpath = "//*[@id=\"field-vat_number\"]")
    public WebElement vatNumberField;
    @FindBy(xpath = "//*[@id=\"field-address1\"]")
    public WebElement address1Field;
    @FindBy(xpath = "//*[@id=\"field-address2\"]")
    public WebElement address2Field;
    @FindBy(xpath = "//*[@id=\"field-postcode\"]")
    public WebElement zipCodeField;
    @FindBy(xpath = "/html/body/main/section/div/div/div/section/div/div[1]/section[2]/div/div/form/section/div[9]/div[1]/input")
    public WebElement cityField;
    @FindBy(xpath = "//*[@id=\"field-id_country\"]")
    WebElement countryDropdownMenu;
    @FindBy(xpath = "//*[@id=\"field-phone\"]")
    public WebElement phoneField;
    @FindBy(xpath = "/html/body/main/section/div/div/div/section/div/div[1]/section[2]/div/div/form/footer/button")
    WebElement addressContinueButton;
    @FindBy(xpath = "/html/body/main/section/div/div/div/section/div/div[1]/section[2]/div/div/form/div[2]/button")
    WebElement editAddressContinueButton;
    @FindBy(xpath = "/html/body/main/section/div/div/div/section/div/div[1]/section[3]/div/div[2]/form/button")
    WebElement shippingMethodContinueButton;

    // Locators for Shipping Method section of the checkout
    @FindBy(xpath = "//*[@id=\"delivery_option_2\"]")
    public WebElement myCarrierRadioButton;

    // Locators for the Payment section of the checkout
    @FindBy(id = "payment-option-1")
    WebElement bankWire;
    @FindBy(id = "payment-option-2")
    public WebElement cashOnDelivery;
    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    WebElement termsCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    WebElement placeOrderButton;
    @FindBy(xpath = "//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3")
    WebElement orderConfirmedTitle;


    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        aliasField = wait.until(ExpectedConditions.visibilityOf(aliasField));
        companyField = wait.until(ExpectedConditions.visibilityOf(companyField));
    }

    // Methods for the Addresses section of the checkout
    public void enterAlias(String alias) {
        aliasField.sendKeys(alias);
    }

    public void enterCompany(String company) {
        companyField.sendKeys(company);
    }

    public void enterVatNumber(String vatNumber) {
        vatNumberField.sendKeys(vatNumber);
    }

    public void enterAddress1(String address1) {
        address1Field.sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        address2Field.sendKeys(address2);
    }

    public void enterZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }

    public void selectCountry(String countryName) {
        countryDropdownMenu.click();

        WebElement countryOption = countryDropdownMenu.findElement(By.xpath("//option[text()='" + countryName + "']"));
        countryOption.click();
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void clickAddressContinueButton() {
        addressContinueButton.click();
    }

    public void clickEditAddressContinueButton() {
        editAddressContinueButton.click();
    }

    // Methods for the Shipping Method section of the checkout
    public void selectMyCarrier() {
        myCarrierRadioButton.click();
    }

    // Methods for the Payment section of the checkout
    public void selectBankWire() {
        bankWire.click();
    }

    public void selectCashOnDelivery() {
        cashOnDelivery.click();
    }

    public void setTermsCheckbox() {
        termsCheckbox.click();
    }

    public void clickShippingMethodContinueButton() {
        shippingMethodContinueButton.click();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public String getOrderConfirmedText() {
        return orderConfirmedTitle.getText();
    }

}
