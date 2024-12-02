package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicDataPage extends BasePage {

    private final WebDriverWait wait;

    // Locators
    private final By postCodeField = By.id("nx-input-1");
    private final By streetDropdown = By.id("nx-dropdown-rendered-2");
    private final By houseNumberField = By.id("nx-input-3");
    private final By livingSpaceField = By.id("nx-input-0");
    private final By birthDateField = By.id("nx-input-2");
    private final By singleFamilyHomeRadio = By.cssSelector("#nx-radio-6-0-label");
    private final By last5YearsDamageNoRadio = By.cssSelector("#nx-radio-7-1-label");
    private final By grossNegligenceNoRadio = By.cssSelector("#nx-radio-8-1-label");
    private final By calculateTariffButton = By.cssSelector("[data-cs-override-id='data-vhv-berechnen-button']");
    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

    // Constructor
    public BasicDataPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
    }

    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postCodeField)).sendKeys(zipCode);
    }

    // Updated method to handle the dropdown
    public void selectStreet(String streetName) {
        try {
            // Click to open the dropdown
            System.out.println("Clicking the dropdown...");
            WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(streetDropdown));
            dropdownElement.click();
            System.out.println("Dropdown clicked successfully!");

            // Wait for dropdown options to load
            System.out.println("Waiting for dropdown options...");
            List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'nx-dropdown-results__option')]")));

            if (options.isEmpty()) {
                System.err.println("No options found in the dropdown!");
                return;
            }

            // Select the matching option
            System.out.println("Searching for the matching option...");
            boolean optionFound = false;
            for (WebElement option : options) {
                if (option.getText().trim().equals(streetName)) {
                    System.out.println("Street option found: " + streetName);

                    // Click the option explicitly
                    Actions actions = new Actions(driver);
                    actions.moveToElement(option).click().perform(); // Hover and click action
                    System.out.println("Street option clicked: " + streetName);
                    optionFound = true;
                    break;
                }
            }

            if (!optionFound) {
                System.err.println("Street option not found: " + streetName);
            }

            // Verify that the dropdown is closed after selecting
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'nx-dropdown-results__option')]")));
            System.out.println("Dropdown closed successfully.");

        } catch (Exception e) {
            System.err.println("Error while selecting street: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterHouseNumber(String houseNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(houseNumberField)).sendKeys(houseNumber);
    }

    public void enterLivingSpace(String livingSpace) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(livingSpaceField)).sendKeys(livingSpace);
    }

    public void enterBirthDate(String birthDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateField)).sendKeys(birthDate);
    }

    public void selectSingleFamilyHome() {
        wait.until(ExpectedConditions.elementToBeClickable(singleFamilyHomeRadio)).click();
    }

    public void selectLast5YearsDamageNo() {
        wait.until(ExpectedConditions.elementToBeClickable(last5YearsDamageNoRadio)).click();
    }

    public void selectGrossNegligenceNo() {
        wait.until(ExpectedConditions.elementToBeClickable(grossNegligenceNoRadio)).click();
    }

    public void clickCalculateTariffNow() {
        wait.until(ExpectedConditions.elementToBeClickable(calculateTariffButton)).click();
    }
}
