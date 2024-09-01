package testCases;

import GenericUtility.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;



public class TC002LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login() throws InterruptedException {



            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(p.getProperty("email"));
            loginPage.enterPassword(p.getProperty("password"));
            loginPage.clickLoginButton();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean message = myAccountPage.ismyAccountPageButtonExits();
            Assert.assertTrue(message, "Login Failed");


    }

}
