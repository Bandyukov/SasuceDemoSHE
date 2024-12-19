package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By loginField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get("https://www.saucedemo.com");
        return this;
    }

    public void loginNegative(String user, String password) {
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public ProductsPage login(String user, String password) {
        driver.findElement(loginField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();

        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
