package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder=\"E-Mail Address\"]")
    private WebElement txtEmail;


    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnLogin;

    public void setTxtEmail(String mail) {
        txtEmail.sendKeys(mail);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setBtnLogin() {
        btnLogin.click();
    }

}
