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


    public boolean ismyAccountPageExits() {

        try {
            return (msgHeading.isDisplayed());
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
