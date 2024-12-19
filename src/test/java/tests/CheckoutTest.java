package tests;

import dto.Customer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        Customer customer = new Customer("Ivan", "Petrov", "1234");
        
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack").addToCart("Sauce Labs Bike Light")
                .clickCart()
                .clickCheckout()
                .writeInfo(customer)
                .clickContinue()
                .clickFinish();

        assertEquals(completePage.getCompleteMessage(), "Thank you for your order!");
    }
}
