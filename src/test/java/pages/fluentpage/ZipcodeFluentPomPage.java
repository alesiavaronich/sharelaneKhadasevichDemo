package pages.fluentpage;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipcodeFluentPomPage extends BaseFluentPomPage {

    private By ZIPCODE_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value=Continue]");

    //Constructor
    public ZipcodeFluentPomPage(WebDriver driver) {
        super(driver);
    }

    //Method works with the same page -> use class/page name as a type -> return this (returns the same page)
    public ZipcodeFluentPomPage openZipCodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
        return this;
    }

    //same as above method
    public ZipcodeFluentPomPage inputZipcode(String zipCode) {
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
        return this;
    }

    public SignUpFormLoadablePomPage clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new SignUpFormLoadablePomPage(driver);
    }

    public void performZipSend(String zipCode) {
        driver.get(Urls.REGISTER_FORM_URL);
        driver.findElement(ZIPCODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
