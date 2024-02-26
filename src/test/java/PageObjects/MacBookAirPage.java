package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookAirPage extends HomePage{
    public MacBookAirPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement searchNav;

    @FindBy(xpath="//h1[normalize-space()='MacBook Air']")
    WebElement macBookAirNavDetails;

    public void getmacBookAirNatails(){
        macBookAirNavDetails.isDisplayed();
    }
    public void clickSearchbtn(){
        searchNav.click();
    }
}
