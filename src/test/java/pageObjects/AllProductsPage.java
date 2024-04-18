package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[2]/ul/li[1]/label/a")
    WebElement filterByWhite;
    @FindBy(xpath = "//*[@id=\"facet_58981\"]/li[2]/label")
    WebElement filterByBlack;
    @FindBy(xpath = "//*[@id=\"facet_63287\"]/li[1]/label")
    WebElement filterByCeramic;
    @FindBy(xpath = "//*[@id=\"facet_63287\"]/li[2]/label")
    WebElement filterByCotton;
    @FindBy(xpath = "//*[@id=\"facet_63287\"]/li[3]/label")
    WebElement filterByMattPaper;
    @FindBy(xpath = "//*[@id=\"facet_63287\"]/li[4]/label")
    WebElement filterByPolyester;
    @FindBy(xpath = "//*[@id=\"facet_63287\"]/li[5]/label")
    WebElement filterByRecycledCardboard;
    @FindBy(xpath = "//*[@id=\"facet_64971\"]/li[1]/label")
    WebElement filterBy120Pages;
    @FindBy(xpath = "/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[4]/ul/li[1]/label/a")
    WebElement filterByLongSleeves;
    @FindBy(xpath = "//*[@id=\"facet_64971\"]/li[3]/label")
    WebElement filterByRemovableCover;
    @FindBy(xpath = "//*[@id=\"facet_65314\"]/li[1]/label")
    WebElement filterByAvailable;
    @FindBy(xpath = "//*[@id=\"facet_65314\"]/li[2]/label")
    WebElement filterByInStock;
    @FindBy(xpath = "//*[@id=\"facet_18842\"]/li[1]/label")
    WebElement filterByGraphicCorner;
    @FindBy(xpath = "//*[@id=\"facet_18842\"]/li[2]/label")
    WebElement filterByStudioDesign;
    @FindBy(xpath = "//*[@id=\"facet_57878\"]/li[1]/label")
    WebElement filterBy40x60;
    @FindBy(xpath = "//*[@id=\"facet_57878\"]/li[2]/label")
    WebElement filterBy60x90;
    @FindBy(xpath = "//*[@id=\"facet_57878\"]/li[3]/label")
    WebElement filterBy80x120;
    @FindBy(xpath = "//*[@id=\"facet_27071\"]/li[1]/label")
    WebElement filterByRuled;
    @FindBy(xpath = "//*[@id=\"facet_27071\"]/li[2]/label")
    WebElement filterByPlain;
    @FindBy(xpath = "//*[@id=\"facet_27071\"]/li[3]/label")
    WebElement filterBySquarred;
    @FindBy(xpath = "//*[@id=\"facet_27071\"]/li[4]/label")
    WebElement filterByDotted;
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

    public void clickWhite() {
        filterByWhite.click();
    }

    public void clickBlack() {
        filterByBlack.click();
    }

    public void clickCeramic() {
        filterByCeramic.click();
    }

    public void clickCotton() {
        filterByCotton.click();
    }

    public void clickMattPaper() {
        filterByMattPaper.click();
    }

    public void clickPolyester() {
        filterByPolyester.click();
    }

    public void clickRecycledCardboard() {
        filterByRecycledCardboard.click();
    }

    public void click120Pages() {
        filterBy120Pages.click();
    }

    public void clickLongSleeves() {
        filterByLongSleeves.click();
    }

    public void clickRemovableCover() {
        filterByRemovableCover.click();
    }

    public void clickAvailable() {
        filterByAvailable.click();
    }

    public void clickInStock() {
        filterByInStock.click();
    }

    public void clickGraphicCorner() {
        filterByGraphicCorner.click();
    }

    public void clickStudioDesign() {
        filterByStudioDesign.click();
    }

    public void click40x60() {
        filterBy40x60.click();
    }

    public void click60x90() {
        filterBy60x90.click();
    }

    public void click80x120() {
        filterBy80x120.click();
    }

    public void clickRuled() {
        filterByRuled.click();
    }

    public void clickPlain() {
        filterByPlain.click();
    }

    public void clickSquarred() {
        filterBySquarred.click();
    }

    public void clickDotted() {
        filterByDotted.click();
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
    public boolean checkArtFilter() { return artFilterEnabled.isDisplayed(); }

    public boolean checkClothesFilter() { return clothesFilterEnabled.isDisplayed(); }
}

