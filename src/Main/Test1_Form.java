package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testUtils.Helper;

public class Test1_Form extends testUtils.Helper {
	Helper h = new Helper();
	Workbook wb;
	@BeforeMethod
	public void beforeMethod(){
		h.drivers();
	}
	@Test
	  public void urlFunction() throws IOException, BiffException {
		
	   String str =System.getProperty("user.dir") + "\\src\\configFiles\\Olx.xls";
	   System.out.println(str);
	    File fp = new File(str);
		//File fp = new File("D:\\RoundTrip.xls");
	
		try
		{
          wb = Workbook.getWorkbook(fp);
			Sheet sheet = wb.getSheet(0);
			int columns = sheet.getColumns();
			int rows = sheet.getRows();
			//String data;
			int col =1;		
			//Boolean temp;
		for(int i=1 ; i< rows ;i++, col++)
		{
			
			System.out.println("This is new Test1 contains Submit Ad");
			Reporter.log("This is to Fill Submit ad Form");
			driver.get(conf.getProperty("testUrl"));
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			
			WebElement SubmitAd = driver.findElement(By.cssSelector("span.free-flag"));
			h.methodassert(SubmitAd);
			SubmitAd.click();
			h.sleep(2);
			
			
			WebElement category = driver.findElement(By.id("c-833"));
			h.methodassert(category);
			category.click();
			h.sleep(2);
			
			List<WebElement> subcategory = driver.findElement(By.id("c-833")).findElements(By.tagName("li"));
			System.out.println(subcategory.size());
			if (subcategory.size() == 0)
				Assert.fail();
			else				
				subcategory.get(1).click();
			h.sleep(3);
	
			WebElement title = driver.findElement(By.id("title"));
			h.methodassert(title);
			title.sendKeys(sheet.getCell(1,i).getContents());
			System.out.println(sheet.getCell(1,i).getContents());
			h.sleep(2);
			
			WebElement selecttype = driver.findElement(By.id("optionals[OptionalOne]"));
		    h.methodassert(selecttype);
		    selecttype.click();
	 
			List<WebElement> setype= driver.findElement(By.id("optionals[OptionalOne]")).findElements(By.tagName("option"));
			System.out.println(setype);
			setype.get(2).click();
			
			WebElement desc = driver.findElement(By.id("description"));
			h.methodassert(desc);
			desc.sendKeys(sheet.getCell(2,i).getContents());
			System.out.println(sheet.getCell(2,i).getContents());
			
			WebElement price = driver.findElement(By.id("C"));
			h.methodassert(price);
			price.sendKeys("400");
			h.sleep(5);
				
			WebElement name = driver.findElement(By.id("contact-name"));
			h.methodassert(name);
			name.sendKeys(sheet.getCell(3,i).getContents());
		    h.sleep(2);
			
			WebElement email = driver.findElement(By.id("email"));
			h.methodassert(email);
			email.sendKeys(sheet.getCell(4,i).getContents());
			h.sleep(2);
			
			WebElement state = driver.findElement(By.id("state"));
			h.methodassert(state);
			state.click();
			
			List<WebElement> li1= driver.findElement(By.cssSelector("select.state_filter_dropdown.req")).findElements(By.tagName("option"));
			System.out.println("The list size : " + li1.size());
			li1.get(6).click();
			sleep(6);
			
			WebElement city = driver.findElement(By.id("city"));
			h.methodassert(city);
			city.click();
			List<WebElement> li2= driver.findElement(By.id("city")).findElements(By.tagName("option"));
			System.out.println("The city : "+ li2.size());
			li2.get(1).click();
			h.sleep(3);
			
			WebElement locality = driver.findElement(By.id("neighborhood"));
			if ( locality != null)
			{
				locality.click();
				List<WebElement> Locality = driver.findElement(By.id("neighborhood")).findElements(By.tagName("option"));
				System.out.println(Locality.size());
			    Locality.get(2).click();
			    sleep(2);
			}
			else
			{
				WebElement Locality1 = driver.findElement(By.id("labelforneighborhood"));
				Locality1.sendKeys("Nijambad");

			}	
			WebElement checkbox = driver.findElement(By.id("saveMyData"));
			
	        
	        //If checkbox is selected by default .
	        if(checkbox.isSelected()){
	             checkbox.click();
	        }
	        
	        WebElement submit = driver.findElement(By.id("btnPublish"));
	        if (submit != null)
	        submit.click();
		}
	}
	catch ( Exception e) {
	  System.out.println(e);
	}
		
			
	}
	  
}
