package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage extends BasePage{

    // Locators
    @FindBy(xpath = "//*[@id=\"facet_57328\"]/li[1]/label")
    WebElement filterByAccessories;
    @FindBy(xpath = "//*[@id=\"facet_57328\"]/li[2]/label")
    WebElement filterByArt;
    @FindBy(xpath = "//*[@id=\"facet_57328\"]/li[3]/label")
    WebElement filterByClothes;
    @FindBy(xpath = "//*[@id=\"facet_37918\"]/li[1]/label")
    WebElement filterBySizeS;
    @FindBy(xpath = "//*[@id=\"facet_37918\"]/li[2]/label")
    WebElement filterBySizeM;
    @FindBy(xpath = "//*[@id=\"facet_37918\"]/li[3]/label")
    WebElement filterBySizeL;
    @FindBy(xpath = "//*[@id=\"facet_37918\"]/li[4]/label")
    WebElement filterBySizeXL;
    @FindBy(xpath = "//*[@id=\"facet_58981\"]/li[1]/label")
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
    @FindBy(xpath = "//*[@id=\"facet_64971\"]/li[2]/label")
    WebElement filterByLongSleeves;
    @FindBy(xpath = "//*[@id=\"facet_64971\"]/li[3]/label")
    WebElement filterByRemovableCover;
    @FindBy(xpath = "//*[@id=\"facet_64971\"]/li[4]/label")
    WebElement filterByShortSleeves;
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

    public void clickSizeS() {
        filterBySizeS.click();
    }

    public void clickSizeM() {
        filterBySizeM.click();
    }

    public void clickSizeL() {
        filterBySizeL.click();
    }

    public void clickSizeXL() {
        filterBySizeXL.click();
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

    public void clickShortSleeves() {
        filterByShortSleeves.click();
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
    public void clickHummingBirdTshirt() { hummingBirdTshirt.click(); }
}

