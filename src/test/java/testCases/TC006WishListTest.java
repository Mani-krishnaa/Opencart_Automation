package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC006WishListTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    void verifyWishlist() {
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
        iPhonePage.setAddToWishList();
        boolean message = iPhonePage.setWishListSuccesPage();
        Assert.assertTrue(message, "\"Product was not added to the wishlist.\"");
    }
}
