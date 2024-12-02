/*
package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pages.ModuleSelectionPage;

public class ModuleSelectionPageTests extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ModuleSelectionPageTests.class);

    @Test
    public void testSelectBasisModule() {
        try {
            // Instantiate the ModuleSelectionPage
            ModuleSelectionPage moduleSelectionPage = new ModuleSelectionPage(driver);

            // Navigate to the URL
            driver.get("https://allianz.de/recht-und-eigentum/hausratversicherung/rechner/?page=angebot");

            // Select the Basis module
            moduleSelectionPage.selectBasisModule();

            logger.info("Module selection test passed!");
        } catch (Exception e) {
            logger.error("Module selection test failed!", e);
        }
    }
}
*/