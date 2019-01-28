package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    @FindBy(css = ".login")
    @CacheLookup
    WebElement signInLink;

    @FindBy(css = "#contact-link a")
    @CacheLookup
    WebElement contactUsLink;

    @FindBy(id = "search_query_top")
    @CacheLookup
    WebElement searchForm;

    @FindBy(name = "submit_search")
    @CacheLookup
    WebElement searchFormSubBtn;

    //Initializing the Page Objects:
    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    public void goToSignInPage() {
        logger.info("Clicking on SignIn link");
        signInLink.click();
    }
    public void goToContactUsPage(){
        logger.info("Clicking on Contact Us link");
        contactUsLink.click();
    }


}
