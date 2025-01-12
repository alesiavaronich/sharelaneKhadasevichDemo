package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpage.SignUpFormLoadablePomPage;
import pages.loadablepage.ZipcodeLoadablePomPage;
import utils.FakeMessageGenerator;

public class SignUpLoadablePomTest extends BaseWithSingletonTest {

    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeLoadablePomPage zipPage = new ZipcodeLoadablePomPage(driver);
        zipPage.openZipCodePage();
        Assert.assertTrue(zipPage.isPageOpened(), "Continue button isn't displayed.");
        zipPage.inputZipcode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipPage.clickContinue();
        SignUpFormLoadablePomPage signUpFormLoadablePomPage = new SignUpFormLoadablePomPage(driver);
        Assert.assertTrue(signUpFormLoadablePomPage.isRegisterDisplayed(), "Register button isn't displayed");

    }



}
