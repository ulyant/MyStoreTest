package com.mystore.qa.base;

import com.mystore.qa.util.OsCheck;
import com.mystore.qa.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public final Logger logger = LogManager.getLogger(this.getClass());

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("./src/main/java/com/mystore/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        //Getting OS type
        OsCheck.OSType ostype = OsCheck.getOperatingSystemType();
        switch (ostype) {
            case Windows:
                initializationWindows();
                break;
            case MacOS:
                initializationMacOS();
                break;
        }

        //Maximizing window
        driver.manage().window().maximize();
        //Delete cookies
        driver.manage().deleteAllCookies();
        //Page load wait time
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //Implicitly wait time
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        //Open the url
        driver.get(prop.getProperty("url"));
    }

    private static void initializationWindows() {
        String browserName = prop.getProperty("browser");
        //Initialization Chrome driver
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        //Initialization Firefox driver
        else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./webdrivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Initialization Internet Explorer driver
        else if (browserName.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "./webdrivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        //Initialization Edge driver
        else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "./webdrivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
    }

    private static void initializationMacOS() {

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./webdrivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equals("safari")) { ;
            driver = new SafariDriver();
        }
    }


}
