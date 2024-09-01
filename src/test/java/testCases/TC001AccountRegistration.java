package testCases;

import GenericUtility.BaseClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001AccountRegistration extends BaseClass {


    @Test(groups = {"Regression", "Master"})
    void verifyAccountRegistration() throws InterruptedException {
        HomePage hp = new HomePage(driver);

        hp.clickMyAccount();
        hp.getRegister();

        AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);

        registrationPage.setFirstName(randomString().toUpperCase());
        registrationPage.setLastName(RandomStringUtils.randomAlphabetic(5));
        registrationPage.setEmail(randomString() + "@gmail.com");
        registrationPage.setTelephone(randomNumber());

        String password = randomAlphaString();

        registrationPage.setPassword(password);
        registrationPage.setConpassword(password);
        registrationPage.setAgree();
        registrationPage.setContinuee();

        String confirmationMessage = registrationPage.getConfirmationMeaasge();
        Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
    }
}
