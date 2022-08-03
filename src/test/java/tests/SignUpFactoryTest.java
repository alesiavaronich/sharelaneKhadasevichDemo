package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountCreatedFactoryPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import pages.pagefactorypages.ZipcodeFactoryPage;
import utils.FakeMessageGenerator;

public class SignUpFactoryTest extends BaseWithFactoryTest {

    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driver);
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "Register button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {


        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {


        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();

        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void signUpTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driver);
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        String password = FakeMessageGenerator.generatePassword();
        signUpFormFactoryPage.sendRegistrationForm(FakeMessageGenerator.generateFirstName(),
                FakeMessageGenerator.generateLastName(),
                FakeMessageGenerator.generateEmail(),
                password,
                password);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(driver);
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "Account is created!' message isn't displayed");
    }
}
