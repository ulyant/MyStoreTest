package com.mystore.qa.testcases;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.CreateNewAccountPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SignInPage;
import com.mystore.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignInPageTest extends TestBase {

    SignInPage signInPage;
    MainPage mainPage;
    MyAccountPage myAccountPage;
    CreateNewAccountPage createAccountPage;

    //call parent's class constructor to initialize prop (for properties)
    public SignInPageTest(){
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

    @Test(priority = 1, enabled = true)
    public void signInPageTitleTest(){
       String title = signInPage.validateSignInPageTitle();
       Assert.assertEquals(title, "Login - My Store");
    }

    @Test(priority = 2, enabled = true)
    public void LogoImageTest(){
        boolean flag = signInPage.validateLogoImage();
        Assert.assertTrue(flag);
    }

    //Successful login with valid credentials
    @Test(priority = 3, groups = "signin")
    public void signInTestSuccessful(){
        myAccountPage  = signInPage.signIn(prop.getProperty("email"), prop.getProperty("password"));
        String myAccountPageTitle = myAccountPage.validateMyAccountPageTitle();
        Assert.assertEquals(myAccountPageTitle, "My account - My Store");
    }

    //Unsuccessful login with empty credentials
    @Test(priority = 4, groups = "signin")
    public void signInTestUnsuccesful(){
        signInPage.clickOnSignInBtn();
        boolean flag = signInPage.getErrorMesage();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
       logger.info("=======================Test case execution is completed==================");
    }

}
