package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends  BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".description h4 a")
    List<WebElement> productDescription;
    @FindBy(id = "button-list")
    WebElement listButton;

    @FindBy(xpath = "//button[contains(@formaction,'checkout')]")
    List<WebElement> addToCartBtn;

    @FindBy(xpath = "//button[contains(@formaction,'wishlist')]")
    List<WebElement> addToWishlistBtn;

    @FindBy(xpath = "//button[contains(@formaction,'compare')]")
    List<WebElement> compareBtn;

    @FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
    WebElement successMsg;

    @FindBy(xpath = "//a[contains(text(),'wish list')]")
    WebElement successMsgWishList;

    @FindBy(xpath = "//a[contains(text(),'product comparison')]")
    WebElement successMsgCompareProduct;

    @FindBy(xpath = "//img[@class='img-fluid']")
    List<WebElement> productImages;


    public int getProductDescriptionCount() {
        return productDescription.size();
    }

    public void clickListButton() {
        listButton.click();
    }

    public void clickAddToCartBtn() {
        for (WebElement element : addToCartBtn) {
            element.click();
        }
    }

    public List<WebElement> getAddToCartBtn() {
        return addToCartBtn;
    }

    public List<WebElement> getAddToWishlistBtn() {
        return addToWishlistBtn;
    }

    public List<WebElement> getCompareBtn() {
        return compareBtn;
    }

    public void clickAddToWishListBtn() {
        for (int i = 1; i < addToWishlistBtn.size(); i++) {
            addToWishlistBtn.get(i).click();
        }
    }

    public void clickCompareBtn() {
        for (int i = 1; i < compareBtn.size(); i++) {
            compareBtn.get(i).click();
        }
    }

    public boolean isSuccessMsgDisplayed() {
        if (successMsg.isDisplayed())
            return true;
        else
            return false;
    }

    public boolean isSuccessMsgDisplayedWishList() {
        if (successMsgWishList.isDisplayed())
            return true;
        else
            return false;
    }

    public boolean isSuccessMsgDisplayedCompare() {
        if (successMsgCompareProduct.isDisplayed())
            return true;
        else
            return false;
    }

    public List<WebElement> clickOnProductImages() {
        return productImages;
        }





}
