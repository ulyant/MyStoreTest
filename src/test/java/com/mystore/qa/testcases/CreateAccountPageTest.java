package com.mystore.qa.testcases;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.CreateNewAccountPage;
import com.mystore.qa.pages.MainPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAccountPageTest extends TestBase {

    SignInPage signInPage;
    MainPage mainPage;
    MyAccountPage myAccountPage;
    CreateNewAccountPage createNewAccountPage;

    //call parent's class constructor to initialize prop (for properties)
    public CreateAccountPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        logger.info("=======================Test case execution is started====================");
        initialization();
        signInPage = new SignInPage();
        mainPage = new MainPage();
        mainPage.goToSignInPage();
    }

    @Test(priority = 1)
    public void registerNewAccount() throws InterruptedException {
        createNewAccountPage = signInPage.goToCreateNewAccountPage();
       // Thread.sleep(1000);

        createNewAccountPage.setTitleRadioBtn("Mrs.");
        createNewAccountPage.enterFirstName("Marcy");
        createNewAccountPage.enterLastName("Warton");
        createNewAccountPage.enterPassword("qwerty123");
        createNewAccountPage.selectDOB("12", "4", "1985");
        createNewAccountPage.setCheckBoxNewsletter();
        createNewAccountPage.setCheckBoxOffers();
        createNewAccountPage.enterAddress1("1 Main Ave");
        createNewAccountPage.enterCity("New York");
        createNewAccountPage.selectState("New York");
        createNewAccountPage.enterZipcode("11001");
        createNewAccountPage.selectCountry("United States");
        createNewAccountPage.enterMobilePhone("1234567890");
        createNewAccountPage.enterAddressAlias("My home");
        myAccountPage = createNewAccountPage.clickOnRegisterBtn();
       // Thread.sleep(1000); for Edge browser
        String myAccountPageTitle = myAccountPage.validateMyAccountPageTitle();
        Assert.assertEquals(myAccountPageTitle, "My account - My Store");
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
       logger.info("=======================Test case execution is completed====================");
    }

}
