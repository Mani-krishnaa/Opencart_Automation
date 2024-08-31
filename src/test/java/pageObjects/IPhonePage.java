package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IPhonePage extends BasePage {

    public IPhonePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//a[normalize-space()='iPhone']")
    private WebElement iphone;

    public boolean isPhoneExists() {
        try {
            return iphone.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

