package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement register;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    private WebElement login;

    public void getMyAccount() {
        myAccount.click();
    }

    public void getRegister() {
        register.click();
    }

    public  void getLogin() {
        login.click();
    }

}
