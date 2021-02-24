package com.nit.optionsandprofiling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeProfilingAndOptions {

    @Test
    public void chrome(){

        System.setProperty("webdriver.chrome.driver", "D:\\MyDevelopment\\drivers\\chromedriver.exe");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs\\chrome.log");
        //with this below line browser logs will not write. if u comment it then u see writing logs..
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.setBinary();
        // chromeOptions.setPageLoadStrategy();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("ignore-certificate-errors");
        //proxy.. my complete proxy systems will gets updated.
        //chromeOptions.addArguments("--proxy-server=http://89.2872.292.2:9090");

        //profiling is linked to our account..If u want to open existing profile
        chromeOptions.addArguments("user-data-dir=C:\\Users\\pavan\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://pushengage.com/demo");
    }
}
