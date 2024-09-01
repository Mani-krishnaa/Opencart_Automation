package testCases;

import GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC008ProductComparisonLinkTest extends BaseClass {


    @Test
    void verifyLinkInSuccessMessage() {
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
        iPhonePage.addToCompare();
        iPhonePage.clickComparisonLink();

        ProductComparisionPage productComparisonPage = new ProductComparisionPage(driver);
        String message = productComparisonPage.setProductComparison();
        Assert.assertEquals(message, "Product Comparison", "The product comparison header is not correct.");
    }
}
