package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends TestBase {

    @FindBy(id = "id_contact")
    @CacheLookup
    WebElement subjectHeadingDropDown;

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailField;

    @FindBy(id = "id_order")
    @CacheLookup
    WebElement orderReferenceField;

    @FindBy(id = "message")
    @CacheLookup
    WebElement messageField;

    @FindBy(id = "submitMessage")
    WebElement sendBtn;

    @FindBy(css = ".alert")
    WebElement alertMessage;

    //Initializing the Page Objects:
    public ContactUsPage(){
        PageFactory.initElements(driver, this);
    }

     public String validateContactUsPageTitle(){
        logger.info("Validating title of the page");
        return driver.getTitle();

    }

    public void selectSubjectHeading(String subject){
        logger.info("Selecting subject of the message");
        Select subjects = new Select(subjectHeadingDropDown);
        subjects.selectByVisibleText(subject);
    }

    public void enterEmailAddress(String email){
        logger.info("Entering email address");
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterOrderReference(String order){
        logger.info("Entering Order reference");
        orderReferenceField.clear();
        orderReferenceField.sendKeys(order);
    }

    public void enterMessageText(String message){
        logger.info("Entering the message");
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void clickOnSendBtn(){
        logger.info("Clicking on Send button");
        sendBtn.click();
    }

    public String getAlertMessage(){
        logger.info("Getting alert message");
        return alertMessage.getText();
    }

}
