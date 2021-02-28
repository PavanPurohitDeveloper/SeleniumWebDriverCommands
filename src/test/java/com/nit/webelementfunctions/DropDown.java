package com.nit.webelementfunctions;

import com.nit.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

//https://www.qtpselenium.com/contact-us
public class DropDown extends TestBase {

    @Test
    public void appTest(){

        WebDriver driver = launchBrowser("Chrome");
        driver.get("https://www.qtpselenium.com/contact-us");
        //select
        //read selected
        //total number of elements -size
        //print all options
        //Multi select option.

        WebElement dropList = driver.findElement(By.name("country_id"));
        Select select = new Select(dropList);
        //select.selectByIndex(5);
        //select.selectByValue(vallue);
        select.selectByVisibleText("India");

        //read selected
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());

        //total number of elements -size
        List<WebElement> allOptionsList = select.getOptions();//This is will give List<WebElements>
        System.out.println(allOptionsList.size());

    }
}
