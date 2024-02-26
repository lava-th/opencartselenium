package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement entreEmail;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement enterPwd;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    WebElement lnkLoginBtn;



    public void setEntreEmail(String email){
        entreEmail.sendKeys(email);

    }
    public void setEntrePassword(String pwd){
        enterPwd.sendKeys(pwd);

    }
    public void clickLoginbtn(){
        lnkLoginBtn.click();
    }


}
