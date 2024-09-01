package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC009CheckoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    void verifyCheckout() throws InterruptedException {
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
        iPhonePage.setCartLink();

        MyCartPage myCartPage = new MyCartPage(driver);
        boolean isOutOfStock = myCartPage.setOutOfStack();
        Assert.assertFalse(isOutOfStock, "\"This product is out of stock.\"");
        myCartPage.clickCheckoutButton();


    }
}
