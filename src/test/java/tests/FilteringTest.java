package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilteringTest extends BaseTest{
    @Test(description = "Filter products")
    public void filterProducts(){
        // Precondition: Account registration is needed

        // Register an account and login
        register();

        // Navigate to the "All products" page
        homePage.clickAllProductsButton();

        // Filter Accessories
        filterAccessories();

        // Check if the filters are set
        Assert.assertTrue(allProductsPage.checkAccessoriesFilter() && allProductsPage.checkWhiteFilter());

        // test fails, filter elements are not found, not mapped correctly
    }
}
