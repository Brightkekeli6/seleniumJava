package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;

    @BeforeSuite
    public void setUp() {
        // Initialize Log4j Core
        logger = LogManager.getLogger(getClass());
        logger.info("Setting up the WebDriver and initializing the browser.");

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser initialized and maximized.");

        // Navigate to the base URL
        String baseUrl = "https://www.allianz.de/recht-und-eigentum/hausratversicherung/rechner/#/"; // Replace with your actual URL
        driver.get(baseUrl);
        logger.info("Navigated to URL: " + baseUrl);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed and WebDriver quit.");
        }
    }
}
