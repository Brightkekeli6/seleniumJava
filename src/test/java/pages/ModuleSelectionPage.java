/*
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuleSelectionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locator for the Basis module button
    private final By basisModuleOption = By.xpath("//*[@id='nx-comparison-table-cell-592']/div/button");

    // Constructor
    public ModuleSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize WebDriverWait
    }

    // Method to select the Basis module
    public void selectBasisModule() {
        wait.until(ExpectedConditions.elementToBeClickable(basisModuleOption)).click();
    }
}
*/