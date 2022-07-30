package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AccountCreatedPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.services.SendZipService;
import utils.FakeMessageGenerator;

public class SignUpPomTest extends BaseTest {

    @Test
    public void fiveDigitZipCodeTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());

        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        Assert.assertTrue(signUpFormPomPage.isRegisterDisplayed(), "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFourDigitsZipCode());

        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        Assert.assertTrue(signUpFormPomPage.isRegisterDisplayed(), "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateSixDigitsZipCode());

        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        Assert.assertTrue(signUpFormPomPage.isRegisterDisplayed(), "Error message isn't displayed");
    }

    @Test
    public void signUpTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());

        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        signUpFormPomPage.inputFirstName(FakeMessageGenerator.generateFirstName());
        signUpFormPomPage.inputLastName(FakeMessageGenerator.generateLastName());
        signUpFormPomPage.inputEmail(FakeMessageGenerator.generateEmail());
        String password = FakeMessageGenerator.generatePassword();
        signUpFormPomPage.inputPassword(password);
        signUpFormPomPage.inputConfirmPassword(password);
        signUpFormPomPage.clickRegister();
        AccountCreatedPomPage accountCreatedPomPage = new AccountCreatedPomPage(driver);
        Assert.assertTrue(accountCreatedPomPage.isSuccessMessageDisplayed(), "Account is created!' message isn't displayed");
    }
}
