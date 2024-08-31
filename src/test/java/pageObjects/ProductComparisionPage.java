package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisionPage  extends BasePage{


    public ProductComparisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Product Comparison']")
    private WebElement productComparison;
    public String setProductComparison() {
        try {
            return productComparison.getText();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
