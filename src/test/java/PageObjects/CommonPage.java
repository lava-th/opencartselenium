package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage{
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='list-group mb-3']//a[contains(@href,'logout')]")
    WebElement lnkLogout;
    public void clickLogoutbtn(){
        lnkLogout.click();
    }


}
