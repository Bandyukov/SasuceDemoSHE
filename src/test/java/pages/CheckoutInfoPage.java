package pages;

import dto.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {

    private final WebDriver driver;
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInfoPage writeInfo(Customer customer) {
        driver.findElement(firstNameField).sendKeys(customer.getFirstName());
        driver.findElement(lastNameField).sendKeys(customer.getLastName());
        driver.findElement(zipCodeField).sendKeys(customer.getZipCode());
        return this;
    }

    public OverviewPage clickContinue() {
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }


}
