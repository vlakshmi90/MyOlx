package Main;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import testUtils.Helper;

public class Test_SelectCity extends testUtils.Helper {
	Helper h = new Helper();
	@BeforeSuite
	public void beforeMethod(){
		if(conf.getProperty("browserType").equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}else if (conf.getProperty("browserType").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chromedriver", "c:\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else 
		{
			System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		}
		
	//	h.drivers();
	}
	
	/*@Test
	  public void urlFunction() throws IOException {
		  System.out.println("This is new Test");
		  Reporter.log("This is new Test");
		  driver.get(conf.getProperty("testUrl"));
		  driver.manage().window().maximize();
		  System.out.println(driver.getTitle());
          h.login(conf.getProperty("username"), conf.getProperty("password"));
		  h.takescreenshot("flipkartshot");
		  driver.close(); 
		 
	  }*/
	
	@Test
		public void selectCityTest1(){
		    System.out.println("******** This method selects a city randomly from the List ********** ");
		    driver.get(conf.getProperty("testUrl"));
		    driver.manage().window().maximize(); 
			WebElement icon = driver.findElement(By.className("icon-arrowdown"));
			h.methodassert(icon);
			icon.click();
			h.sleep(5);
			List<WebElement> listweb = driver.findElement(By.cssSelector(conf.getProperty("city"))).findElements(By.tagName(conf.getProperty("citytag")));	
			System.out.println("No. of Elements in container:" + listweb.size());
			if (listweb.size() == 0)
				Assert.fail("There are no citys in the container");
			else
			{
				Random r = new Random();
				int j = r.nextInt(listweb.size());
				System.out.println("Element:" + j + "," + listweb.get(j).getText());
				h.sleep(5);
				listweb.get(j).click();
				h.sleep(5);
				System.out.println("The City which was selected: "+ driver.getTitle());
			}
			driver.close();
	}
	
	
	
	
	

}

	
			
		
