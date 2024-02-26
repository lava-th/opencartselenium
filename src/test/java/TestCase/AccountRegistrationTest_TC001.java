package TestCase;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountRegistrationTest_TC001 extends BaseClass {
    @Test
    public void verify_account_registration(){
        logger.info("*** starting AccountRegsitrationTest ****");
        logger.debug("application logs started.......");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicked on MyAccount link");
            hp.clickRegister();
            logger.info("clicked on registration link");

           logger.info("Entering customer details...");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            String email = randomeString() + "@gmail.com";
            regpage.setEmail(email);// randomly generated the email
            System.out.println(email);
            //regpage.setTelephone(randomeNumber());

            String password = randomAlphaNumeric();
            System.out.println(password);
            regpage.setPassword(password);
            //regpage.setConfirmPassword(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();
            logger.info("clicked on continue...");

            String confmsg = regpage.getConfirmationMsg();
            logger.info("validation expected message...");

            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }
        catch(Exception e){
            logger.error("test failed...");
            logger.debug("debug logs....");
            Assert.fail();

        }
        logger.debug("application logs end.....");
        logger.info("***** finished AccountRegistrationTest ****");
    }
}
