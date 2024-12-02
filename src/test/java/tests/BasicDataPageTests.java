package tests;

import org.testng.annotations.Test;

import pages.BasicDataPage;



public class BasicDataPageTests extends BaseTest {

    @Test
    public void validateDetails() {
        BasicDataPage basicDataPage = new BasicDataPage(driver);

        System.out.println("Accepting cookies...");
        basicDataPage.acceptCookies();

        System.out.println("Entering zip code...");
        basicDataPage.enterZipCode("97491");
        
        System.out.println("Selecting street...");
        basicDataPage.selectStreet("Aidhäuser Str.");

        System.out.println("Entering house number...");
        basicDataPage.enterHouseNumber("8");

        System.out.println("Entering living space...");
        basicDataPage.enterLivingSpace("150");

        System.out.println("Entering date of birth...");
        basicDataPage.enterBirthDate("06.06.1990");

        System.out.println("Selecting single-family home...");
        basicDataPage.selectSingleFamilyHome();

        System.out.println("Answering last 5 years damage question...");
        basicDataPage.selectLast5YearsDamageNo();

        System.out.println("Answering gross negligence question...");
        basicDataPage.selectGrossNegligenceNo();

        System.out.println("Calculating tariff...");
        basicDataPage.clickCalculateTariffNow();
    }
}
