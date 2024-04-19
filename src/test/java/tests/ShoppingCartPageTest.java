package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AllProductsPage;
import pageObjects.ProductPage;
import pageObjects.AddToCartPopUp;
import pageObjects.ShoppingCartPage;

public class ShoppingCartPageTest extends BaseTest {
    @Test(description = "Add product to cart", groups = {"Smoke tests", "Regression tests"})
    public void addProductToCart() {
        try {
            // Precondition: Account registration is needed

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Click on the HummingBird T-shirt
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickHummingBirdTshirt();

            // Click on the Add to cart button
            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductCartButton();

            // Click on the Proceed to Checkout button
            AddToCartPopUp addToCartPopUp = new AddToCartPopUp(driver);
            addToCartPopUp.clickProceedToCheckoutButton();

            // Check if the product is in the shopping cart
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            Assert.assertTrue(shoppingCartPage.getShoppingCartTitleText().contains("CART") &&
                    shoppingCartPage.getProductInCartText().contains("Hummingbird"));

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Cancel Add to cart Pop-up", groups = "Regression tests")
    public void cancelAddToCartPopup() {
        try {
            // Precondition: Account registration is needed

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Click on the HummingBird T-shirt
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickHummingBirdTshirt();

            // Click on the Add to cart button
            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductCartButton();

            // Click on the Continue shopping button
            AddToCartPopUp addToCartPopUp = new AddToCartPopUp(driver);
            addToCartPopUp.clickContinueShoppingButton();

            // Check that the Pop-up is closed and the product page is displayed
            Assert.assertTrue(productPage.getProductTitleText().contains("HUMMINGBIRD"));

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}
