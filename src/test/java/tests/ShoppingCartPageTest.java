package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class ShoppingCartPageTest extends BaseTest {
    @Test(description = "Add product to cart")
    public void addProductToCart() {
        try {
            // Precondition: Account registration is needed before each test that requires a login

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Click on the HummingBird T-shirt
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickHummingBirdTshirt();

            // Click on the Add to cart button
            ProductPage productPage = new ProductPage(driver);
            productPage.clickHummingBirdTshirtCartButton();

            // Click on the Proceed to Checkout button
            AddToCartPopUp addToCartPopUp = new AddToCartPopUp(driver);
            addToCartPopUp.clickProceedToCheckoutButton();

            // Check if the product is in the shopping cart
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            Assert.assertTrue(shoppingCartPage.getShoppingCartTitleText().contains("CART") &&
                    shoppingCartPage.getHummingBirdText().contains("Hummingbird"));
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Cancel Add to cart Pop-up")
    public void cancelAddToCartPopup() {
        try {
            // Precondition: Account registration is needed before each test that requires a login

            // Register an account and login
            register();

            // Navigate to the "All products" page
            homePage.clickAllProductsButton();

            // Click on the HummingBird T-shirt
            AllProductsPage allProductsPage = new AllProductsPage(driver);
            allProductsPage.clickHummingBirdTshirt();

            // Click on the Add to cart button
            ProductPage productPage = new ProductPage(driver);
            productPage.clickHummingBirdTshirtCartButton();

            // Click on the Proceed to Checkout button
            AddToCartPopUp addToCartPopUp = new AddToCartPopUp(driver);
            addToCartPopUp.clickContinueShoppingButton();

            // Check that the Pop-up is closed and the product page is displayed
            Assert.assertTrue(productPage.getHummingBirdTshirtTitleText().contains("HUMMINGBIRD"));
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}
