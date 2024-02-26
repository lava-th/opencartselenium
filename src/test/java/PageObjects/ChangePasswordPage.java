package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name='password']")
    WebElement enterNewPassword;

    @FindBy(xpath="//input[@name='confirm']")
    WebElement enterConfirmPassword;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    WebElement lnkButtonContinue;



//div[contains(@class,'alert-success ')]


        public void setEnterNewPassword(String npwd){
            enterNewPassword.sendKeys(npwd);
        }
        public void setEnterConfirmPassword(String cpwd){
            enterConfirmPassword.sendKeys(cpwd);
        }
        public void clickLnkButtonContinue(){
            lnkButtonContinue.click();
        }



        }



