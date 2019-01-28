package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class SignInPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(id = "email")
    @CacheLookup
    private WebElement emailSignIn;

    @FindBy(id = "passwd")
    @CacheLookup
    private WebElement passwordSignIn;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    private WebElement signInBtn;

    @FindBy(linkText = "Forgot your password?")
    @CacheLookup
    WebElement forgotPasswordLink;

    @FindBy(id = "email_create")
    @CacheLookup
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    @CacheLookup
    WebElement createAnAccountBtn;

    @FindBy(css = ".logo")
    WebElement yourLogoImage;

    //Message unsuccessful singin
    @FindBy(xpath = "//p[contains(text(),'There is 1 error')]")
    WebElement errMsgSignIn;


    //Initializing the Page Objects:
    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    //Create a random email
    public static String getRandomEmail() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            str.append(CHARS.charAt(index));
        }
        return str.toString()+"@mail.com";
    }

    //Actions (methods of the page):

    public String validateSignInPageTitle(){
        logger.info("Getting title of the page");
        return driver.getTitle();
    }

    public Boolean validateLogoImage(){
        logger.info("Validating Logo");
        return yourLogoImage.isDisplayed();
    }

    public void clickOnSignInBtn(){
        logger.info("Clicking on SignIn button");
        signInBtn.click();
    }

    public boolean getErrorMesage(){
        logger.info("Validating error message is displayed");
        return errMsgSignIn.isDisplayed();
    }

    public MyAccountPage signIn(String email, String password){
        logger.info("Signing in to the account");
        emailSignIn.clear();
        passwordSignIn.clear();
        emailSignIn.sendKeys(email);
        passwordSignIn.sendKeys(password);
        signInBtn.click();
        return new MyAccountPage();
    }

    public CreateNewAccountPage goToCreateNewAccountPage(){
        logger.info("Entering an email to create a new account");
        emailCreate.clear();
        emailCreate.sendKeys(getRandomEmail());
        createAnAccountBtn.click();
        return new CreateNewAccountPage();
    }
}
