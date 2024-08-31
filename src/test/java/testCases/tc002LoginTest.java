package testCases;

import GenericUtility.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;



public class tc002LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login() throws InterruptedException {



            HomePage hm = new HomePage(driver);
            hm.getMyAccount();
            Thread.sleep(1000);
            hm.getLogin();

            LoginPage lg = new LoginPage(driver);
            lg.setTxtEmail(p.getProperty("email"));
            lg.setTxtPassword(p.getProperty("password"));
            lg.setBtnLogin();

            MyAccountPage mp = new MyAccountPage(driver);
            boolean message = mp.ismyAccountPageExits();
            Thread.sleep(1000);
            Assert.assertTrue(message, "Login False");


    }

}
