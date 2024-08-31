package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.IPhonePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class tc006WishList extends BaseClass {

    @Test
    void verifying_WIshlist() {
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
        ip.setAddToWishList();
        boolean message = ip.setWishListSuccesPage();
        Assert.assertTrue(message, "Product is Not Added To wishList");
    }
}
