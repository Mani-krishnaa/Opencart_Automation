package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import javax.annotation.Tainted;

public class tc007ProductComparision extends BaseClass {
    @Test
    void verify_productComaprision() {
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
        ip.setAddToCompare();
        boolean message = ip.SetCompareSuceesMessage();
        Assert.assertTrue(message, "Product is not added to Comparision");
    }
}
