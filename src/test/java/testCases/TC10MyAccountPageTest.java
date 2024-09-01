package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC10MyAccountPageTest extends BaseClass {

    @Test
    void verifyMyAccountPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLoginButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        boolean isMyAccountButtonDisplayed = myAccountPage.ismyAccountPageButtonExits();
        Assert.assertTrue(isMyAccountButtonDisplayed, "My Account Button is Not Displayed");

        boolean isMyOrdersButtonDisplayed = myAccountPage.isMyOrdersButtonExists();
        Assert.assertTrue(isMyOrdersButtonDisplayed, "My order Button is not Displayed");

        boolean isMyAffiliateButtonDisplayed = myAccountPage.isMyAffiliateButtonExists();
        Assert.assertTrue(isMyAffiliateButtonDisplayed, "My isMyAffiliateButtonDisplayed Button is not Displayed");

        boolean isMyNewsletterButtonDisplayed = myAccountPage.isMyNewsletterButtonExists();
        Assert.assertTrue(isMyNewsletterButtonDisplayed, "My isMyNewsletterButtonDisplayed Button is not Displayed");
    }
}
