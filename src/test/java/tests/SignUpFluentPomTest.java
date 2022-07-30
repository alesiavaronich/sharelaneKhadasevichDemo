package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpage.ZipcodeFluentPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.services.SendZipService;
import utils.FakeMessageGenerator;

public class SignUpFluentPomTest extends BaseTest {

    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeFluentPomPage zipPage = new ZipcodeFluentPomPage(driver);
        boolean isRegisterDisplayed = zipPage.openZipCodePage()
                .inputZipcode(FakeMessageGenerator.generateFiveDigitsZipCode())
                .clickContinue()
                .isRegisterDisplayed();
        Assert.assertTrue(isRegisterDisplayed, "Register button isn't displayed.");

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


}
