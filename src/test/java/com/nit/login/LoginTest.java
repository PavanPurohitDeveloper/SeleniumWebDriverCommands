package com.nit.login;

import com.nit.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void login(){
        WebDriver driver = launchBrowser("Chrome");
        driver.get("http://yahoo.com");
    }


}
