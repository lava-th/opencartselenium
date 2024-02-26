package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImacDescriptionPage extends HomePage {
    public ImacDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='iMac']")
    WebElement imacNavDetails;
    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement searchNav;

    public void getimacimage(){
       imacNavDetails.isDisplayed();
    }
    public void clickSearchbtn(){
        searchNav.click();
    }
}

