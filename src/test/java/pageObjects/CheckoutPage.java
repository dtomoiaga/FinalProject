package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{

    // Locators for the Addresses section of the checkout
    @FindBy(id= "field-alias")
    public WebElement aliasField;
    @FindBy(id= "field-firstname")
    WebElement firstNameField;
    @FindBy(id= "field-lastname")
    WebElement lastNameField;
    @FindBy(id= "field-company")
    public WebElement companyField;
    @FindBy(id= "field-vat_number")
    public WebElement vatNumberField;
    @FindBy(xpath = "//*[@id=\"field-address1\"]")
    public WebElement address1Field;
    @FindBy(xpath = "//*[@id=\"field-address2\"]")
    public WebElement address2Field;
    @FindBy(xpath = "//*[@id=\"field-postcode\"]")
    public WebElement zipCodeField;
    @FindBy(xpath = "//*[@id=\"field-city\"]")
    public WebElement cityField;
    @FindBy(xpath = "//*[@id=\"field-phone\"]")
    public WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"delivery-address\"]/div/footer/button")
    WebElement continueButton1;
    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    WebElement continueButton2;

    // Locators for Shipping Method section of the checkout
    @FindBy(xpath = "//*[@id=\"delivery_option_1\"]")
    WebElement clickAndCollectRadioButton;
    @FindBy(xpath = "//*[@id=\"delivery_option_2\"]")
    public WebElement myCarrierRadioButton;
    @FindBy(id= "delivery-message")
    WebElement deliveryDetailsField;

    // Locators for the Payment section of the checkout
    @FindBy(id= "payment-option-1")
    WebElement bankWire;
    @FindBy(id= "payment-option-2")
    public WebElement cashOnDelivery;
    @FindBy(id= "payment-option-3")
    WebElement checkPayment;
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
    }

    // Methods for the Addresses section of the checkout
    public void enterAlias(String alias) {
        aliasField.sendKeys(alias);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
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

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void clickContinue1() {
        continueButton1.click();
    }

    // Methods for the Shipping Method section of the checkout
    public void selectClickAndCollect() {
        clickAndCollectRadioButton.click();
    }

    public void selectMyCarrier() {
        myCarrierRadioButton.click();
    }

    public void enterDeliveryDetails(String details) {
        deliveryDetailsField.sendKeys(details);
    }

    // Methods for the Payment section of the checkout
    public void selectBankWire() {
        bankWire.click();
    }

    public void selectCashOnDelivery() {
        cashOnDelivery.click();
    }

    public void selectCheckPayment() {
        checkPayment.click();
    }

    public void setTermsCheckbox(){ termsCheckbox.click(); }

    public void clickContinue2(){ continueButton2.click(); }

    public void clickPlaceOrderButton(){ placeOrderButton.click(); }

    public String getOrderConfirmedText(){ return orderConfirmedTitle.getText(); }

}
