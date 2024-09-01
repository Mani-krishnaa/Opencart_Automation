package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC005AddToCartTest extends BaseClass {
    @Test
    void verifyAddToCart() throws InterruptedException {
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
        iPhonePage.addToCart();
        boolean successMessage = iPhonePage.setCartSuccesPage();
        Assert.assertTrue(successMessage, "\"The product was not successfully added to the cart.\"");


    }
}
