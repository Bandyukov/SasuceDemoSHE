package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage {

    private final WebDriver driver;
    private final By checkoutButton = By.id("checkout");

    public CardPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInfoPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutInfoPage(driver);
    }

}
