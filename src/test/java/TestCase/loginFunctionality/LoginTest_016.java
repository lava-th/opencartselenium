package TestCase.loginFunctionality;

import PageObjects.*;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_016 extends BaseClass {
    @Test
    public void validateChangePasswordSuccessfulTest(){
        logger.info("*** Starting LoginTest_016 ******");
        logger.debug("Capturing application debug logs...");
        try {
            //Home Page
            HomePage homePage = new HomePage(driver);
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            //Login Page
            LoginPage loginPage = new LoginPage(driver);
            ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
            AccountPage accountPage = new AccountPage(driver);
            CommonPage commonPage = new CommonPage(driver);

            homePage.clickMyAccount();
            logger.info("clicked on myAccount link");
            homePage.clickRegister();
            logger.info("clicked on register link");

            logger.info("Entering customer details....");
            accountRegistrationPage.setFirstName(randomeString().toUpperCase());
            accountRegistrationPage.setLastName(randomeString().toUpperCase());

            String email = randomeString() + "@gmail.com";
            accountRegistrationPage.setEmail(email);// randomly generated the email

            String password = randomAlphaNumeric();
            accountRegistrationPage.setPassword(password);

            accountRegistrationPage.setPrivacyPolicy();

            accountRegistrationPage.clickContinue();
            logger.info("Clicked on continue...");

            String confmsg = accountRegistrationPage.getConfirmationMsg();
            logger.info("validating expected message...");
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");

            commonPage.clickLogoutbtn();
            logger.info("clicked on logout btn");

            homePage.clickMyAccount();
            logger.info("clicked on myAccount");
            homePage.clickLogin();
            logger.info("clicked on login");

            loginPage.setEntreEmail(email);
            logger.info("taken the mail");
            loginPage.setEntrePassword(password);
            logger.info("taken the passwored");

            loginPage.clickLoginbtn();
            logger.info("clicked on login btn");

            accountPage.clicklnkChangePwd();
            logger.info("clicked on change passsord link");

            String newPassword = randomAlphaNumeric();
            changePasswordPage.setEnterNewPassword(newPassword);
            logger.info("Entered the new password");
            changePasswordPage.setEnterConfirmPassword(newPassword);
            changePasswordPage.clickLnkButtonContinue();
            logger.info("Entered the confirmed password");

            String message = accountPage.getSuccessMsg();
            Assert.assertEquals(message, "Success: Your password has been successfully updated.");
            logger.info("Validate the expected  message...");

            commonPage.clickLogoutbtn();
            logger.info("clicked on logout btn..");

            homePage.clickMyAccount();
            logger.info("Again cilcked on Myaccount..");
            homePage.clickLogin();
            logger.info("clicked on login btn..");

            loginPage.setEntreEmail(email);
            logger.info("Entered the email ...");
            loginPage.setEntrePassword(newPassword);
            logger.info("Entered the new password");

            loginPage.clickLoginbtn();
            logger.info("clicked on login btn");

            boolean isMyAccountHeaderVisible = accountPage.isMyAccountHeaderVisible();
            Assert.assertTrue(isMyAccountHeaderVisible, "My Account header not validated successfully");
            logger.info("validated the expected message...");
        }
        catch (Exception e){
            logger.error("test failed....");
            logger.debug("debug logs...");
            Assert.fail();
        }
        logger.debug("application logs end....");
        logger.info("******** finished Validate Logging into the Application after changing the password ******");




    }
}
