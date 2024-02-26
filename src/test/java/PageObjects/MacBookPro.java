package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPro extends BasePage{
    MacBookPro(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement searchNav;


    @FindBy(xpath="//h1[normalize-space()='MacBook Pro']")
    WebElement macBookProNavDetails;

    public void getMacBookProNavDetails(){
        macBookProNavDetails.isDisplayed();
    }
    public void clickSearchBtn(){
        searchNav.click();
    }
}
