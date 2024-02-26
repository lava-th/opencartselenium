package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
* 1.2: Create Page Object Classes for HomePage, RegistrationPage  under pageObjects package.
*  (These classes extends from BasePage).*/
public class HomePage extends BasePage {
    //WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;
    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;
    @FindBy(xpath="//div[contains(@class,'float-end')]//a[contains(@href,'login')]")
    WebElement lnkLogin;

    @FindBy(css = "#search >input")
    WebElement searchTextBox;

    @FindBy(css = "#search >button")
    WebElement searchBtn;



    public void clickMyAccount(){
        lnkMyaccount.click();
    }
    public void clickRegister(){
        lnkRegister.click();
    }
    public void clickLogin(){lnkLogin.click();}
    public void enterTextInSearchBox(String inputText){
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(inputText);
    }

    public void clickSearchBtn()
    {
        searchBtn.click();
    }


}
