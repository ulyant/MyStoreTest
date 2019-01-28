package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends TestBase {

    public String validateMyAccountPageTitle(){
        logger.info("Getting the title of MyAccountPage");
        return driver.getTitle();
    }
}
