package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final WebDriver driver;
    private final By title = By.cssSelector("[data-test=title]");
    private final By cartLink = By.id("shopping_cart_container");//By.cssSelector("[data-test=shopping-cart-link]");

    private static final String addToCard = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpen() {
        return driver.findElement(title).isDisplayed();
    }

    public CardPage clickCart() {
        driver.findElement(cartLink).click();
        return new CardPage(driver);
    }

    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCard, product))).click();
        return this;
    }
}
