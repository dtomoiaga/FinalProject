package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class ShoppingCartPageTest extends BaseTest {
    @Test(description = "Add product to cart")
    public void addProductToCart(){
    try {
        // Navigate to the Sign-In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Register an account
        register();

        // Navigate to the All products page
        homePage.clickAllProductsButton();

        // Click on the HummingBird T-shirt
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        allProductsPage.clickHummingBirdTshirt();

        // Click on the Add to cart button
        allProductsPage.clickHummingBirdTshirtCartButton();

        // Click on the Proceed to Checkout button
        AddToCartPopUp addToCartPopUp = new AddToCartPopUp(driver);
        addToCartPopUp.clickProceedToCheckoutButton();

        // Check if the product is in the shopping cart
        // check for the shopping cart text to see that the section is correct and then check for the hummingbird tshirt presence
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.getShoppingCartTitleText().contains("CART") &&
                shoppingCartPage.getHummingBirdText().contains("Hummingbird"));
        //Assert.assertTrue(homePage.getHummingbirdTShirtText().contains("Humingbird"));

    } catch(Throwable e) {
        takeScreenshot();
        throw e;
    }
}
}
