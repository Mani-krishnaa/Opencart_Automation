package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC007ProductComparisionTest extends BaseClass {
    @Test
    void verifyProductComparison() {
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
        iPhonePage.addToCompare();
        boolean message = iPhonePage.SetCompareSuceesMessage();
        Assert.assertTrue(message, "verifyProductComparison");
    }
}
