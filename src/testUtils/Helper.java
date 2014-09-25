package testUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Main.TestBase;

public class Helper extends Main.TestBase {
	
	public void drivers()
	{
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
	}
	

	public void methodassert(WebElement wb ){
		if((wb == null) || (wb.getSize().equals(0)))
	      Assert.fail("The WebElement "+wb +"is null");
		else
		  System.out.println("You sucessfully identified Element " + wb);
	}
	
	public void listmethodassert(List<WebElement> wb ){
		if(wb.size() == 0)
		      Assert.fail("The WebElement "+wb +"is empty ");
			else
			  System.out.println("You sucessfully identified List Element " + wb);
			
	}
	
	public boolean  waitforElement(int timeout, By by){
		while(timeout> 0){
			sleep(1);
		    List<WebElement> list = driver.findElements(by);
			if(list.size()!= 0){
				return true;
		    }
			timeout --;
		}
		System.out.println("waiting Timed out element not found" + by.toString());
		return false;	
	}
	
	public void sleep(int secounds)
	{
		try{
			Thread.sleep(secounds*1000);
		}catch(Exception e){
			
		}
	}
	
	public void takescreenshot(String filename) throws IOException{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(conf.getProperty("screenShotsPaths")+"\\"+filename+".jpg"));
		
	}
	 	
	public void login(String username, String password) throws IOException{
		//System.out.println(String.format("signing in with %s/%s from header login"));
		System.out.println(driver.findElements(By.cssSelector("a.no-border")).size());
		if( driver.findElements(By.linkText("Login")).size()==0){
			System.out.println("user logged in");
			return;
		}
		List<WebElement> listweb1 = driver.findElement(By.id(conf.getProperty("id"))).findElements(By.tagName("a"));
		listweb1.get(0).click();
		sleep(5);
		driver.findElement(By.id("username")).sendKeys(username);
        byte[] decoded = Base64.decodeBase64(password);   
	    driver.findElement(By.id("password")).sendKeys(new String(decoded));
		driver.findElement(By.id("submit")).click();
		sleep(5);
	}
} 
		

	
	
	




