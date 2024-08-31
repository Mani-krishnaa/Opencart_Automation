package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement conpassword;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agree;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continuee;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement confirmationMeaasge;

    public void setLastName(String lName) {
        lastName.sendKeys(lName);
    }
    public void setTelephone(String num) {
        telephone.sendKeys(num);
    }

    public void setFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void setEmail(String e_mail) {
        email.sendKeys(e_mail);
    }

    public void setContinuee() {
        continuee.click();
    }

    public void setAgree() {
        agree.click();
    }

    public void setPassword(String passwordd) {
        password.sendKeys(passwordd);
    }
    public void setConpassword(String password) {
        conpassword.sendKeys(password);
    }

    public String getConfirmationMeaasge() {
        try {
            return confirmationMeaasge.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
