package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.ShoppingCartPage;

public class CheckoutTest extends BaseTest{
    @Test(description = "Checkout product", groups = {"Smoke tests", "Regression tests"})
    public void checkOutProduct() {
        try {
        // Precondition: Account registration and adding a product to cart is needed

        // Register an account and login
        register();

        // Add a product to cart
        addProductToCart();

        // Proceed to the checkout page
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceedToCheckout();

        // Complete the checkout process
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterAlias("Mister");
        checkoutPage.enterCompany("Scoala Informala");
        checkoutPage.enterVatNumber("1234");
        checkoutPage.enterAddress1("Libertatii 1");
        checkoutPage.enterAddress2("Republicii 2");
        checkoutPage.enterZipCode("12345");
        checkoutPage.enterCity("Cluj-Napoca");
        checkoutPage.enterPhone("9898989");
        checkoutPage.clickContinue1();
        checkoutPage.selectMyCarrier();
        checkoutPage.clickContinue2();
        checkoutPage.selectCashOnDelivery();
        checkoutPage.setTermsCheckbox();
        checkoutPage.clickPlaceOrderButton();

        // Check that the order is confirmed
        Assert.assertTrue(checkoutPage.getOrderConfirmedText().contains("CONFIRMED"));

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}
