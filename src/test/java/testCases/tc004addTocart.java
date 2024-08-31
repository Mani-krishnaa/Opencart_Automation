package testCases;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import GenericUtility.*;
import org.testng.annotations.Test;


public class tc004addTocart extends BaseClass {

    @Test
    void verify_mycart() throws InterruptedException {
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
        Thread.sleep(1000);
        mp.setSearchBar(p.getProperty("searchProductName"));
        Thread.sleep(2000);
        mp.setSearchbtn();

        Thread.sleep(1000);


        IPhonePage ip = new IPhonePage(driver);
        boolean message = ip.isPhoneExists();
        Thread.sleep(1000);
        Assert.assertTrue(message, "\"Phone does not exist. Not Displayed\"");


    }
}
