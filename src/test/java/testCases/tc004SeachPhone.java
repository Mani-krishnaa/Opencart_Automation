package testCases;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import GenericUtility.*;
import org.testng.annotations.Test;


public class tc004SeachPhone extends BaseClass {

    @Test
    void verify_product() throws InterruptedException {

        HomePage hm = new HomePage(driver);
        hm.getMyAccount();

        hm.getLogin();

        LoginPage lg = new LoginPage(driver);

        lg.setTxtEmail(p.getProperty("email"));
        lg.setTxtPassword(p.getProperty("password"));
        lg.setBtnLogin();

        MyAccountPage mp = new MyAccountPage(driver);

        mp.setSearchBar(p.getProperty("searchProductName"));

        mp.setSearchbtn();




        IPhonePage ip = new IPhonePage(driver);
        boolean message = ip.isPhoneExists();
        Thread.sleep(5000);
        Assert.assertTrue(message, "\"Phone does not exist. Not Displayed\"");


    }
}
