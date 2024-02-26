package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//a[normalize-space()='Change your password']")
    WebElement lnkChangePWD;

    @FindBy(xpath = "//div[contains(@class,'alert-success ')]")
    WebElement pwdChangeSuccessMsg;
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountHeader;
/*6.1: Prepare test data in Excel, place the excel file inside the testData folder.
6.2: Create ExcelUtility class under utilities package.
6.3: Update Page Object class MyAccountPage , add logout link element)
6.4 : Create DataProviders class in utilities package to maintain data providers for data driven tests.
6.5: Create LoginDataDrivenTest under testCases package.
6.6: Add an Entry in testng.xml file
*/
    @FindBy(xpath = "//div[@class='list-group mb-3']//a[contains(@href,'logout')]")
    WebElement lnkLogout;

    public void clicklnkChangePwd() {
        lnkChangePWD.click();
    }

    public String getSuccessMsg() {
        return pwdChangeSuccessMsg.getText();
    }

    public boolean isMyAccountHeaderVisible() {
        if (myAccountHeader.isDisplayed())
            return true;
        else
            return false;
    }
    //Added the logout action and method for excel utility file

    public void clickLogout() {
        lnkLogout.click();

    }
}
