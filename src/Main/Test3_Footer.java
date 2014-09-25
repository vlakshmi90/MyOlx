package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testUtils.Helper;

public class Test3_Footer extends Helper {
    // This Class checks for all Footer Links.
	Helper h = new Helper();
	@BeforeTest
	public void before(){
		h.drivers();
	}
	@Test
	public void imagesSort() throws IOException {
		System.out.println("This is new images sort");
		Reporter.log("This is new Test for Footer Links");
		driver.get(conf.getProperty("testUrl"));		
		driver.manage().window().maximize();	
		System.out.println(driver.getTitle());
        
		List<String> str = new ArrayList<String>();
		List<WebElement> ll = driver.findElement(By.cssSelector("div.txt-center")).findElements(By.tagName("a"));
        h.listmethodassert(ll);
        
		for(int i=0;i<ll.size()-1;i++){
			str.add(ll.get(i).getAttribute("href"));
			Reporter.log(" The Footer link href " + ll.get(i).getAttribute("href") +"	Class name is:" + ll.get(i).getAttribute("class") );
			System.out.println("Link href is: " + ll.get(i).getAttribute("href") + " 	Class name is:" + ll.get(i).getAttribute("class"));
		}
		for(int j=0;j<str.size();j++){
			System.out.println(str.get(j));
			( ( JavascriptExecutor ) driver ) .executeScript( "window.onbeforeunload = function(e){};" );
			driver.get(str.get(j));	
			if(driver.getTitle().contains("Page Not Found"))
        		Assert.fail("404 Exception");
        	else
        		System.out.println("Pass");
			
        }
			
	}
		
}




