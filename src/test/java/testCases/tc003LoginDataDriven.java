package testCases;


// data is valid - login success -- test pass -logout
// data is valid -- login failed - test fail

// data is invalid - login success - test fail - logout
// data is invalid -- login failed -- test pass


import GenericUtility.BaseClass;
import GenericUtility.DataProviders;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class tc003LoginDataDriven extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
    // The second Parametre is for here our login data is in another package so we need to provide Class also in which class it is present
    public void verify_loginDDT(String email, String pwd, String expextedResult) throws InterruptedException {

            //HomePage
            HomePage hm = new HomePage(driver);
            hm.getMyAccount();
            Thread.sleep(1000);
            hm.getLogin();
            Thread.sleep(1000);
            //Login
            LoginPage lg = new LoginPage(driver);
            lg.setTxtEmail(email);
            lg.setTxtPassword(pwd);
            Thread.sleep(1000);
            lg.setBtnLogin();

            //MyAccount
            MyAccountPage mp = new MyAccountPage(driver);
            boolean message = mp.ismyAccountPageExits();

            if (expextedResult.equalsIgnoreCase("Valid")) {
                if (message == true) {
                    mp.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (expextedResult.equalsIgnoreCase("Invalid")) {
                if (message == true) {
                    mp.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue((false));
                }
            }

    }
}

