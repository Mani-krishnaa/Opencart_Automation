package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class tc005AddToCart extends BaseClass {
    @Test
    void verifying_addTocart() throws InterruptedException {
        HomePage hm = new HomePage(driver);
        hm.getMyAccount();
        Thread.sleep(1000);
        hm.getLogin();

        LoginPage lg = new LoginPage(driver);
        Thread.sleep(1000);
        lg.setTxtEmail(p.getProperty("email"));
        lg.setTxtPassword(p.getProperty("password"));
        lg.setBtnLogin();

        MyAccountPage mp = new MyAccountPage(driver);
        mp.setSearchBar(p.getProperty("searchProductName"));
        Thread.sleep(3000);
        mp.setSearchbtn();


        IPhonePage ip = new IPhonePage(driver);
        ip.setCart();
        Thread.sleep(3000);
        boolean succesMessage = ip.setCartSuccesPage();
        Assert.assertTrue(succesMessage);


    }
}
