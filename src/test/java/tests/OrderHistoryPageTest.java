package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OrderHistoryPage;
import pageObjects.ShoppingCartPage;

import java.util.List;

public class OrderHistoryPageTest extends BaseTest {
    @Test(description = "Check if a completed order is displayed in the Order History", groups = "Regression tests")
    public void checkOrderHistory() {
        try {
            // Precondition: Account registration and a complete order is needed

            // Register an account and login
            register();

            // Add a product to cart and proceed to the checkout page
            addProductToCart();
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickProceedToCheckout();

            // Complete the order
            completeOrder();

            // Navigate to the order history page
            homePage.clickOrdersButton();

            // Get all rows of the table and check that there is an order present in the order list
            OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
            List<WebElement> rows = orderHistoryPage.orderList.findElements(By.tagName("tr"));
            Assert.assertTrue(!rows.isEmpty(), "No orders are present in the order list.");

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(description = "Reorder an order", groups = "Regression tests")
    public void reorderOrder() {
        try {
            // Precondition: Account registration and a complete order is needed

            // Register an account and login
            register();

            // Add a product to cart and proceed to the checkout page
            addProductToCart();
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickProceedToCheckout();

            // Complete the order
            completeOrder();

            // Navigate to the order history page
            homePage.clickOrdersButton();

            // Reorder the previously created order
            OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
            orderHistoryPage.clickReorderButton();

            checkoutPage.clickEditAddressContinueButton();
            checkoutPage.clickShippingMethodContinueButton();
            checkoutPage.selectBankWire();
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
