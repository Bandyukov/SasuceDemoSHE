package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    private final WebDriver driver;
    private final By title = By.xpath("//*[@class = 'complete-header']");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompleteMessage() {
        return driver.findElement(title).getText();
    }
}
