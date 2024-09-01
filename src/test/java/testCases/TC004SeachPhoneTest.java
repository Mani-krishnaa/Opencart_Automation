package testCases;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import GenericUtility.*;
import org.testng.annotations.Test;


public class TC004SeachPhoneTest extends BaseClass {

    @Test
    void verifyProductSearch() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLoginButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        myAccountPage.setSearchBar(p.getProperty("searchProductName"));
        myAccountPage.setSearchbtn();


        IPhonePage iPhonePage = new IPhonePage(driver);

        boolean isPhoneDisplayed = iPhonePage.isPhoneExists();
        Assert.assertTrue(isPhoneDisplayed, "\"Phone does not exist. Not Displayed\"");


    }
}
