package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.WishlistPage;

public class WishlistPageTest extends BaseTest {
    @Test (description = "Create a new wishlist")
    public void wishlistTest(){
        // Navigate to the Sign-In page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Navigate to the Create Account page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCreateAccountButton();

        // Register an account
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Mr", "Daniel", "Tomoiaga", "email@email.com", "Scoalainformala");

        // Navigate to the Wishlist page
        homePage.clickWishlistButton();

        // Create a new list
        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.clickCreateNewListButton();
        wishlistPage.addWishlistName();
        wishlistPage.clickCreateWishlistButton();
        Assert.assertTrue(wishlistPage.getWishlistText().contains("TestWishlist"));
    }
}
