package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class
CreateNewAccountPage extends TestBase {

    @FindBy(id = "id_gender1")
    @CacheLookup
    WebElement MrRadioBtn;

    @FindBy(id = "id_gender2")
    @CacheLookup
    WebElement MrsRadioBtn;

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement firstNameNewAcc;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement lastNameNewAcc;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement passwordNewAcc;

    @FindBy(id = "days")
    @CacheLookup
    WebElement dropDownDays;

    @FindBy(id = "months")
    @CacheLookup
    WebElement dropDownMonths;

    @FindBy(id = "years")
    WebElement dropDownYears;

    @FindBy(id = "newsletter")
    @CacheLookup
    WebElement checkBoxNewsletter;

    @FindBy(id = "optin")
    @CacheLookup
    WebElement checkBoxOffers;

    @FindBy(id = "company")
    @CacheLookup
    WebElement company;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement addressLine1;

    @FindBy(id = "address2")
    @CacheLookup
    WebElement addressLine2;

    @FindBy(id = "city")
    @CacheLookup
    WebElement city;

    @FindBy(id = "id_state")
    @CacheLookup
    WebElement dropDownStates;

    @FindBy(id ="postcode")
    @CacheLookup
    WebElement zipcode;

    @FindBy(id = "id_country")
    @CacheLookup
    WebElement dropDownCountry;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    WebElement mobilePhone;

    @FindBy(id = "alias")
    @CacheLookup
    WebElement addressAlias;

    @FindBy(id ="submitAccount")
    @CacheLookup
    WebElement registerAccBtn;

    //Initializing the Page Objects:
    public CreateNewAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public void setTitleRadioBtn(String title){
        logger.info("Selecting title");
        if (title.equalsIgnoreCase("Mr.")){
            MrRadioBtn.click();
        } else if (title.equalsIgnoreCase("Mrs.")){
            MrsRadioBtn.click();
        }
    }

    public void enterFirstName(String name){
        logger.info("Entering first name");
        firstNameNewAcc.clear();
        firstNameNewAcc.sendKeys(name);
    }

    public void enterLastName(String lname){
        logger.info("Entering last name");
        lastNameNewAcc.clear();
        lastNameNewAcc.sendKeys(lname);
    }

    public void enterPassword(String password){
        logger.info("Entering password");
        passwordNewAcc.clear();
        passwordNewAcc.sendKeys(password);
    }

    public void selectDOB(String day, String month, String year){
        logger.info("Selecting DOB");
        Select days = new Select(dropDownDays);
        days.selectByValue(day);
        Select months = new Select(dropDownMonths);
        months.selectByValue(month);
        Select years = new Select(dropDownYears);
        years.selectByValue(year);
    }

    public void setCheckBoxNewsletter() {
        logger.info("Checking box Newsletter");
        checkBoxNewsletter.click();
    }

    public void setCheckBoxOffers(){
        logger.info("Checking box Offers");
        checkBoxOffers.click();
    }

    public void enterAddress1(String adr) {
        logger.info("Entering address");
        addressLine1.clear();
        addressLine1.sendKeys(adr);
    }

    public void enterCity(String cityAd){
        logger.info("Entering city");
        city.clear();
        city.sendKeys(cityAd);
    }

    public void selectState(String state){
        logger.info("Selecting state");
        Select states = new Select(dropDownStates);
        states.selectByVisibleText(state);
    }

    public void enterZipcode(String code){
        logger.info("Entering zip code");
        zipcode.clear();
        zipcode.sendKeys(code);
    }

    public void selectCountry(String country){
        logger.info("Selecting country");
        Select countries = new Select(dropDownCountry);
        countries.selectByVisibleText(country);
    }

    public void enterMobilePhone(String number){
        logger.info("Entering mobile phone");
        mobilePhone.clear();
        mobilePhone.sendKeys(number);
    }

    public void enterAddressAlias(String alias){
        logger.info("Entering address alias");
        addressAlias.clear();
        addressAlias.sendKeys(alias);
    }

    public MyAccountPage clickOnRegisterBtn(){
        logger.info("Clicking on Register button");
        registerAccBtn.click();
        return new MyAccountPage();
    }

}
