package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IPhonePage extends BasePage {

    public IPhonePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//a[normalize-space()='iPhone']")
    private WebElement iphone;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement cartSuccesPage;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    private WebElement addtocart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement wishlListSucessMessgae;

    public boolean isPhoneExists() {
        try {
            return iphone.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setCart() {
        addtocart.click();
    }

    public boolean setWishListSuccesPage() {
        try {
            return wishlListSucessMessgae.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setCartSuccesPage() {
        try {
            return cartSuccesPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}

