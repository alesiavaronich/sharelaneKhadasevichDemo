package pages.fluentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpFormLoadablePomPage extends BaseFluentPomPage {

    private By REGISTER_BUTTON = By.cssSelector("[value=Register");

    public SignUpFormLoadablePomPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegisterDisplayed() {
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }
}
