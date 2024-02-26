package TestCase.loginFunctionality;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseClass;
import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDataDrivenTest extends BaseClass {
/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/
@Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)
public void verify_loginDDT(String email, String password, String exp)
{
    logger.info("**** Starting TC_003_LoginDDT *****");

    try {

        //Home page
        HomePage hp=new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin(); //Login link under MyAccount

        //Login page
        LoginPage lp=new LoginPage(driver);
       lp.setEntreEmail(email);
       lp.setEntrePassword(password);
       lp.clickLoginbtn();


        //My Account Page
        AccountPage macc=new AccountPage(driver);
        boolean targetPage= macc.isMyAccountHeaderVisible();

        if(exp.equalsIgnoreCase("Valid"))
        {
            if(targetPage==true)
            {
                macc.clickLogout();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

        if(exp.equalsIgnoreCase("Invalid"))
        {
            if(targetPage==true)
            {
                macc.clickLogout();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }
    }
    catch(Exception e)
    {
        Assert.fail("An exception occurred: " + e.getMessage());
    }

    logger.info("**** Finished TC_003_LoginDataDrivenTest *****");
}


}
