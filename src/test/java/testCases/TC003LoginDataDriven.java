package testCases;


// data is valid - login success -- test pass -logout
// data is valid -- login failed - test fail

// data is invalid - login success - test fail - logout
// data is invalid -- login failed -- test pass


import GenericUtility.BaseClass;
import GenericUtility.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC003LoginDataDriven extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
    // The second Parametre is for here our login data is in another package so we need to provide Class also in which class it is present
    public void verifyLoginDataDriven(String email, String pwd, String expextedResult) throws InterruptedException {

            //HomePage
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            //LoginPage
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(pwd);
            loginPage.clickLoginButton();

            //MyAccount
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean isAccountPageDisplayed = myAccountPage.ismyAccountPageButtonExits();

            if (expextedResult.equalsIgnoreCase("Valid")) {
                if (isAccountPageDisplayed) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }
            if (expextedResult.equalsIgnoreCase("Invalid")) {
                if (isAccountPageDisplayed) {
                    myAccountPage.clickLogout();
                    Assert.fail();
                } else {
                    Assert.assertTrue((false));
                }
            }

    }
}

