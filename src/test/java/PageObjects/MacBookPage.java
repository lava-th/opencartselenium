package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends BasePage{

    MacBookPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement searchNav;
    @FindBy(xpath="//h1[normalize-space()='MacBook']']")
    WebElement macbookNavDetails;
    public void getMacBookNavDetails(){
        macbookNavDetails.isDisplayed();
    }
    public void clickSearchbtn(){
        searchNav.click();
    }
}
