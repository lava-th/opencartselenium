package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*1.1: Create BasePage under "pageObjects" which includes only constructor.
 This will be invoked by every Page Object Class constructor (Re-usability).*/
public class BasePage {
    WebDriver driver;
    BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
