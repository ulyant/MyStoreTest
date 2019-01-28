package com.mystore.qa.testcases;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContactUsPageTest extends TestBase {

    MainPage mainPage;
    ContactUsPage contactUsPage;

    //call parent's class constructor to initialize prop (for properties)
    public ContactUsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        logger.info("=======================Test case execution is started====================");
        initialization();
        mainPage = new MainPage();
        contactUsPage = new ContactUsPage();
        mainPage.goToContactUsPage();
    }

    @Test(priority = 1, enabled = true)
    public void contactUsPageTitleTest(){
       String title = contactUsPage.validateContactUsPageTitle();
       Assert.assertEquals(title, "Contact us - My Store");
    }

    //Successful sending a message
    @Test(priority = 2, groups = "Message")
    public void sendMessageTest(){
        contactUsPage.selectSubjectHeading("Webmaster");
        contactUsPage.enterEmailAddress("marcy@marcy.com");
        contactUsPage.enterOrderReference("Order #12345");
        contactUsPage.enterMessageText("What is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");
        contactUsPage.clickOnSendBtn();
        String message = contactUsPage.getAlertMessage();
        Assert.assertEquals(message, "Your message has been successfully sent to our team.");
    }

    //Unsuccessful sending a message (empty fields)
    @Test(priority = 3, groups = "Message")
    public void sendMessageEmptyFieldsTest(){
        contactUsPage.clickOnSendBtn();
        String message = contactUsPage.getAlertMessage();
        Assert.assertEquals(message, "There is 1 error\n" + "Invalid email address.");
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
       logger.info("=======================Test case execution is completed====================");
    }

}
