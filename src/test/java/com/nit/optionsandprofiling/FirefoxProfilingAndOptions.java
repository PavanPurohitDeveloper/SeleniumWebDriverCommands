package com.nit.optionsandprofiling;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfilingAndOptions {

    //set the binary file
    // Notifications.. you want to cancel this notifications
    // maximize the browsers at times
    // certificate errors
    // work with proxy

    @Test
    public void firefox(){

        //By default SSL Errors are managed in Selenium 4
        System.setProperty("webdriver.gecko.driver", "D:\\MyDevelopment\\drivers\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log");
        FirefoxOptions options = new FirefoxOptions();
        //options.setPageLoadStrategy(strategy);
        //if selenium is not finding the firefox.exe
        //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        ProfilesIni allProfilesIni = new ProfilesIni(); //Get all the profiles
        FirefoxProfile profile = allProfilesIni.getProfile("feb2021");//get your specific profile u interested

        //to manage notifications - to disable the notifictaions when visiting URL
        profile.setPreference("dom.webnotifications.enabled", false);

        //to manage SSL certificate errors.. these 2 lines need to add
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);

        //How to work with proxy server
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "83.778.87.11");
        profile.setPreference("network.proxy.socks_port", 1827);

        options.setProfile(profile);

        FirefoxDriver firefoxDriver = new FirefoxDriver(options); //creates a new Profile
        //firefoxDriver.get("http://pushengage.com/demo");
        firefoxDriver.get("https://expired.badssl.com/");
    }
}
