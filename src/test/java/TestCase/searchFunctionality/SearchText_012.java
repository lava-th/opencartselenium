package TestCase.searchFunctionality;

import PageObjects.HomePage;
import PageObjects.SearchResultPage;
import TestBase.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class SearchText_012 extends BaseClass {

    @Test
    public void validateListGridViewSearchResults() throws InterruptedException {
        //HomePage
        HomePage homePage=new HomePage(driver);

        homePage.enterTextInSearchBox("Mac");
        homePage.clickSearchBtn();
        //SearchResult Page
        SearchResultPage searchResultPage=new SearchResultPage(driver);

        int numberOfSearchResults=searchResultPage.getProductDescriptionCount();
        Assert.assertTrue(numberOfSearchResults>1);

        searchResultPage.clickListButton();

        List<WebElement> addToCart = searchResultPage.getAddToCartBtn();
        for(WebElement element:addToCart){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            boolean successMsgDisplayed=searchResultPage.isSuccessMsgDisplayed();
            Assert.assertTrue(successMsgDisplayed);
            Thread.sleep(6000);
        }

        List<WebElement> addToWishList = searchResultPage.getAddToWishlistBtn();
        for(WebElement element:addToWishList){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            boolean successMsgDisplayed=searchResultPage.isSuccessMsgDisplayedWishList();
            Assert.assertTrue(successMsgDisplayed);
            Thread.sleep(6000);
        }

        List<WebElement> compareBtn = searchResultPage.getCompareBtn();
        for(WebElement element:compareBtn){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            boolean successMsgDisplayed=searchResultPage.isSuccessMsgDisplayedCompare();
            Assert.assertTrue(successMsgDisplayed);
            Thread.sleep(7000);
        }

        List<WebElement> imagesDisplay= searchResultPage.clickOnProductImages();
        for(WebElement element:imagesDisplay) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        }

    }

}
