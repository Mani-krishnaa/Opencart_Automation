package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IPhonePage extends BasePage {

    public IPhonePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'iPhone')]")
    private WebElement iphone;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement cartSuccesPage;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    private WebElement addtocart;

    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[2]")
    private WebElement addToWishList;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement wishlListSucessMessgae;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//i[@class='fa fa-exchange']")
    private WebElement addToCompare;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement compareSuceesMessage;

    @FindBy(xpath = "//a[normalize-space()='product comparison']")
    private WebElement link;

    public void setAddToWishList() {
        addToWishList.click();
    }

    public boolean isPhoneExists() {
        try {
            return iphone.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setCartLink() {
        cartLink.click();
    }

    public void addToCart() {
        addtocart.click();
    }

    public boolean setWishListSuccesPage() {
        try {
            return wishlListSucessMessgae.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setCartSuccesPag() {

    }

    public boolean setCartSuccesPage() {
        try {
            return cartSuccesPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCompare() {
        addToCompare.click();
    }

    public boolean SetCompareSuceesMessage() {
        try {
            return compareSuceesMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickComparisonLink() {
        link.click();
    }


}

