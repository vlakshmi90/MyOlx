package Main;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testUtils.Helper;

	public class Test2_Search extends testUtils.Helper {
		Helper h = new Helper();
		@BeforeTest
		public void before(){
			h.drivers();
		}
		@Test
		public void imagesSort() throws IOException {
			System.out.println("This is new Test");
			Reporter.log("This is new Test");
			driver.get(conf.getProperty("testUrl"));
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			List<WebElement> lisearch = driver.findElement(By.id(conf.getProperty("home"))).findElements(By.tagName("input"));
			System.out.println(lisearch.size());
			if (lisearch.size() == 0)
				Assert.fail("");
			else
			{
				lisearch.get(0).sendKeys("car");
		        lisearch.get(0).sendKeys(Keys.ENTER);
			}
			System.out.println("The Title is : " + driver.getTitle());
			String title = driver.getTitle();
			if (!title.contains("car"))		
				Assert.fail(" You search for Car is not SucessFull");
			else
			{
				WebElement AdsWithImg = driver.findElement(By.id("listing-gallery-toggle-gallery"));
				AdsWithImg.click();
		    	System.out.println("Text displayed there is" + driver.findElement(By.id("listing-gallery-toggle")).getText());	
		    	String obtainedList = driver.findElement(By.id("listing-gallery-toggle")).getText();
		    	if (!obtainedList.equalsIgnoreCase("Ads with Photos") || !obtainedList.contains("Ads with Photos"))
		    	   Assert.fail("Search cars with Images were not found");
		    	else
		    	{
		    		System.out.println("Search For ads With Images are Sucessfull");
		    	}
		    }
			driver.close();
	    }
		
	}
