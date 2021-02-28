package com.nit.multipleobjectextraction;

import com.nit.base.TestBase;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CnnHeaderLinkTesting extends TestBase {
	
	@Test
	public void cnnHeaderLinks() {
		// extract all links - list
		/*
		list{
		// get 1 link
		   Check the presence, visibility of element
		   check response code - 200
		   click
		   check - next page OK
		   go back to original page
		}
		*/
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = launchBrowser("Chrome");
		driver.get("http://cnn.com");
		List<WebElement> topLinks = driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
		System.out.println("Total Links: "+ topLinks.size());

		for(int i=0; i<topLinks.size(); i++){
			System.out.println(topLinks.get(i).getText());
			String url = topLinks.get(i).getAttribute("href");
			System.out.println(url);

			//check response code - 200
			boolean result = validateResponseCode(url);
			//Assert.assertTrue(result, "Invalid response code"); //test will fail on this line if response code is not 200
			softAssert.assertTrue(result, "Invalid response code");

			topLinks.get(i).click();
			System.out.println(driver.getTitle());
			driver.get("http://cnn.com");
			System.out.println("-------------------------");

			//Extract the topLinks again..re-initialize the variable
			topLinks = driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
		}
		softAssert.assertAll();
	}

	public boolean validateResponseCode(String url){
		int resp_code=0;
		try {
			resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
			System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
			if(resp_code == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//here wrong response code
		return false;
	}
}
