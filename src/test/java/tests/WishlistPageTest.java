package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class WishlistPageTest extends BaseTest {

    @Test(description = "Create a new wishlist")
    public void createNewWishlist() {
        try {
            // Precondition: Account registration is needed before each test that requires a login

            // Register an account
            register();

            // Navigate to the Wishlist page
            homePage.clickWishlistButton();

            // Create a new list
            WishlistPage wishlistPage = new WishlistPage(driver);
            wishlistPage.clickCreateNewListButton();
            wishlistPage.addWishlistName();
            wishlistPage.clickCreateWishlistButton();
            Assert.assertTrue(wishlistPage.getWishlistText().contains("TestWishlist"));
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Add to wishlist - not signed in")
    public void addToWishlistNotSignedIn() {
        try {
            // Click on the first article's "Add to Wishlist" button
            HomePage homePage = new HomePage(driver);
            homePage.clickArticleOneWishlistButton();

            // Check that the Sign In pop-up is displayed
            SignInPopUp signInPopUp = new SignInPopUp(driver);
            Assert.assertTrue(signInPopUp.isSignInPopUpDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }

    }

    @Test(description = "Cancel the Sign In pop-up")
    public void cancelTheSignInPopUp() {
        try {
            // Click on the first article's "Add to Wishlist" button
            HomePage homePage = new HomePage(driver);
            homePage.clickArticleOneWishlistButton();

            // Click the "Cancel" button on the pop-up
            SignInPopUp signInPopUp = new SignInPopUp(driver);
            signInPopUp.clickCancelSignInPopUp();

            // Check that the Sign In pop-up is displayed
            Assert.assertFalse(signInPopUp.isSignInPopUpDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }

    }

    @Test(description = "Add to wishlist - signed in")
    public void addToWishlistSignedIn() {
        try {
            // Register an account and login
            register();

            // Click on the Hummingbird T-shirt "Add to Wishlist" button
            if (homePage.getHummingbirdTShirtText().contains("Hummingbird")) {
                homePage.clickArticleOneWishlistButton();
            }

            // Select My Wishlist from the pop-up
            AddToWishlistPopUp addToWishlistPopUp = new AddToWishlistPopUp(driver);
            addToWishlistPopUp.clickMyWishlistButton();

            // Navigate to the Wishlist page
            homePage.clickWishlistButton();

            // Open the default wishlist "My wishlist"
            WishlistPage wishlistPage = new WishlistPage(driver);
            wishlistPage.clickDefaultList();

            // Check if the added Hummingbird T-shirt is present
            Assert.assertTrue(wishlistPage.getHummingbirdTShirtText().contains("Hummingbird"));
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}
