package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllProductsPage extends BasePage {

    // Locators
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[1]/ul/li[1]/label/a")
    WebElement filterByAccessories;
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[1]/ul/li[2]/label/a")
    WebElement filterByArt;
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[1]/ul/li[3]/label/a")
    WebElement filterByClothes;
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[2]/ul/li[2]/label/a")
    WebElement filterBySizeM;
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[4]/ul/li[1]/label/a")
    WebElement filterByLongSleeves;
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[2]/h2/a")
    WebElement hummingBirdTshirt;
    @FindBy(xpath = "//*[@id=\"js-active-search-filters\"]/ul/li[1]")
    WebElement accessoriesFilterEnabled;
    @FindBy(xpath = "/html/body/main/section/div/div/div[2]/section/section/div[2]/section/ul/li")
    WebElement artFilterEnabled;

    @FindBy(xpath = "/html/body/main/section/div/div/div[2]/section/section/div[2]/section/ul/li")
    WebElement clothesFilterEnabled;

    // Constructor
    public AllProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForPageToLoad() {
        filterByAccessories = wait.until(ExpectedConditions.visibilityOf(filterByAccessories));
        filterByArt = wait.until(ExpectedConditions.visibilityOf(filterByArt));
    }

    // Click on filter checkboxes
    public void clickAccessories() {
        filterByAccessories.click();
    }

    public void clickArt() {
        filterByArt.click();
    }

    public void clickClothes() {
        filterByClothes.click();
    }

    public void clickSizeM() {
        filterBySizeM.click();
    }

    public void clickLongSleeves() {
        filterByLongSleeves.click();
    }

    // Click on the HummingBird T-shirt product
    public void clickHummingBirdTshirt() {
        hummingBirdTshirt.click();
    }

    // Check if the Accessories filter is enabled
    public boolean checkAccessoriesFilter() {
        return accessoriesFilterEnabled.isDisplayed();
    }

    // Check if the Art filter is enabled
    public boolean checkArtFilter() {
        return artFilterEnabled.isDisplayed();
    }

    // Check if the Clothes filter is enabled
    public boolean checkClothesFilter() {
        return clothesFilterEnabled.isDisplayed();
    }
}
