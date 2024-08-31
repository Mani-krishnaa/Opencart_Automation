package testCases;

import GenericUtility.BaseClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class tc001Accountregistration extends BaseClass {


    @Test ( groups = {"Regression", "Master"})
    void verify_account_registration() throws InterruptedException {

        HomePage hp = new HomePage(driver);

        hp.getMyAccount();
        Thread.sleep(1000);
        hp.getRegister();
        Thread.sleep(1000);
        AccountRegistrationPage ap = new AccountRegistrationPage(driver);
       // Thread.sleep(5000);
        ap.setFirstName(randomString().toUpperCase());
        ap.setLastName(RandomStringUtils.randomAlphabetic(5));

        ap.setEmail(randomString() + "@gmail.com");
        ap.setTelephone(randomNumber());
        String pass =randomAlphaString();
        ap.setPassword(pass);
        ap.setConpassword(pass);
        ap.setAgree();
        ap.setContinuee();

        String Result = ap.getConfirmationMeaasge();
        Assert.assertEquals(Result, "Your Account Has Been Created!");
    }


}
