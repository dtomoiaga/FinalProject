package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AllProductsPage;

public class FilteringTest extends BaseTest{
    @Test(description = "Filter by Accessories", groups = "Regression tests")
    public void filterByAccessories(){
        try {
        // Precondition: Account registration is needed

        // Register an account and login
        register();

        // Navigate to the "All products" page
        homePage.clickAllProductsButton();

        // Filter by Accessories
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickAccessories();

        // Check if the filter is set
        Assert.assertTrue(allProductsPage.checkAccessoriesFilter());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Filter by Art", groups = "Regression tests")
    public void filterByArt() {
        try {
            // Precondition: Account registration is needed

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Filter by Accessories
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickArt();

            // Check if the filter is set
            Assert.assertTrue(allProductsPage.checkArtFilter());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Filter by Clothes - this test will fail", groups = "Regression tests")
    public void filterByClothes(){
        try {
            // Precondition: Account registration is needed

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Filter by Clothes
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickClothes();
            allProductsPage.clickSizeM();
            allProductsPage.clickLongSleeves();

            // Check if the filter is set
            Assert.assertTrue(allProductsPage.checkClothesFilter());

        } catch (Throwable e) {
        takeScreenshot();
        throw e;
    }
    }

}
