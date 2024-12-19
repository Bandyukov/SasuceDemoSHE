package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    private final WebDriver driver;
    private final By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public CompletePage clickFinish() {
        driver.findElement(finishButton).click();
        return new CompletePage(driver);
    }
}
