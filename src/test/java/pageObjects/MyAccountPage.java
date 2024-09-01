package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()=\"My Account\"]")
    private WebElement msgHeading;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement linkLogout;


    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement searchbtn;


    @FindBy(xpath = "//h2[normalize-space()='My Orders']")
    private WebElement myOrders;

    @FindBy(xpath = "//h2[normalize-space()='My Affiliate Account']")
    private WebElement myAffiliateAccount;

    @FindBy(xpath = "//h2[normalize-space()='Newsletter']")
    private WebElement newsletter;


    public boolean ismyAccountPageButtonExits() {

        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMyAffiliateButtonExists() {
        try {
            return myAffiliateAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isMyOrdersButtonExists() {
        try {
            return myOrders.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMyNewsletterButtonExists() {
        try {
            return newsletter.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickLogout() {
        linkLogout.click();
    }

    public void setSearchBar(String text) {
        searchBar.sendKeys(text);
    }

    public void setSearchbtn() {
        searchbtn.click();
    }

}
