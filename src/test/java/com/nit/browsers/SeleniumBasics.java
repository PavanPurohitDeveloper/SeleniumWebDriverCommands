package com.nit.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SeleniumBasics {

    /**
     * Chrome will update automatically with latest version, and If your chromedriver.exe will be older then you will get an Error
     * SessionNot created Exception.
     * There is versioning problem in the browser.
     */
    @Test
    public void testAppChrome(){
        //latest chrome and the right chromedriver.exe which matches the latest chrome version.
        System.setProperty("webdriver.chrome.driver", "D:\\MyDevelopment\\drivers\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://yahoo.com");
    }

    @Test
    public void testAppFireFox(){
        //version of firefox - turn off the automatic updates ( Tools -> Options -> Firefox Updates )
        //take little older version of firefox 72.02
        System.setProperty("webdriver.gecko.driver", "D:\\MyDevelopment\\drivers\\geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://cnn.com");
    }

    @Test
    public void testAppIEDriver(){
        //zoom level should be 100%
        //IE -> Internet Options -> Under Security -> Make sure Enable protected mode is turned off for all 4
        //IE -> Internet Options -> Advanced -> Under Security -> Allow active content to run in files
        System.setProperty("webdriver.ie.driver", "D:\\MyDevelopment\\drivers\\IEDriverServer.exe");
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver();
        internetExplorerDriver.get("http://cnn.com");
    }

    @Test
    public void testAppMicrosoftEdgeDriver(){
        //Make sure version and right driver you using
        System.setProperty("webdriver.edge.driver", "D:\\MyDevelopment\\drivers\\msedgedriver.exe");
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("http://cnn.com");
    }


}
