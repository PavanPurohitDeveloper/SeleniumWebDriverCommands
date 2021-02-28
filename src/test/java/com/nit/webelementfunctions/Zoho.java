package com.nit.webelementfunctions;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Zoho extends TestBase {

    @Test
    public void appTest() throws InterruptedException {
        WebDriver driver = launchBrowser("Chrome");
        driver.get("http://www.zohoo.com/signup.html");
        //Thread.sleep(5000);
        boolean b = driver.findElement(By.xpath("//span[@id='signup-termservice']")).isEnabled();
        System.out.println(b);
        //Thread.sleep(2);
        //WebDriverWait - expicit wait

        int i = 1;
        while(i <= 10){ //max 10 second will run.
            //If this element is enabled the break out of the loop .. other wise wait for 1 second
            //Every 1 second it will pool the page for the element to be enabled.
            if(driver.findElement(By.xpath("//input[@id='tos']]")).isEnabled())
                break;
            else{
                Thread.sleep(1000);
                i++;
            }
        }
        driver.findElement(By.xpath("//span[@id='signup-termservice']")).click();
        driver.findElement(By.id("emailfield")).sendKeys("hello");
        driver.findElement(By.id("emailfield")).clear();

        String text = driver.findElement(By.xpath("//h3")).getText();
        System.out.println(text);
        text = driver.findElement(By.id("emailfield")).getText();
        System.out.println("Value of text field "+ text);

        text = driver.findElement(By.id("signupbtn")).getAttribute("value");
        System.out.println(text);

        text = driver.findElement(By.xpath("//input[@id='tos']]")).getAttribute("checked");
        System.out.println(text);

        driver.quit(); //ends the selenium session and quit the browser.
    }
}
