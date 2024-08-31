package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class tc009Checkout extends BaseClass {
    @Test
    void verifying_Checkout() throws InterruptedException {
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
        ip.setCart();
        ip.setCartLink();

        Thread.sleep(5000);
         MyCartPage cp = new MyCartPage(driver);
        boolean outofStack = cp.setOutOfStack();
        Assert.assertFalse(outofStack,"This product is out my Stock");
        cp.setCheckoutButton();



    }
}
