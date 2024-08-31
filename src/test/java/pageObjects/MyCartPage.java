package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCartPage extends BasePage {
    public MyCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement outOfStack;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutButton;

    public void setCheckoutButton() {
        checkoutButton.click();
    }

    public boolean setOutOfStack() {
        try {
            return outOfStack.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
}
