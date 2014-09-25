package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import testUtils.Helper;

public class TestBase {
	Helper h = null;
	public static Properties conf = null;
    public static Properties OR = null;
    public static Logger  log = Logger.getLogger("devpinoyLogger");
    public static WebDriver driver;
	
    @BeforeSuite
    public void initialize() throws IOException{
    	FileInputStream fp = new FileInputStream(System.getProperty("user.dir" )+ "\\src\\configFiles\\config.properties" );
	    conf = new Properties();
	    conf.load(fp);
	
	    FileInputStream fp1 = new FileInputStream(System.getProperty("user.dir" )+ "\\src\\configFiles\\OR.properties" );
	    OR = new Properties();
	    conf.load(fp1);
	
	    System.out.println("Choosing the Browser " + conf.getProperty("browserType"));
	  
	}
  
  
    @AfterSuite
    public void afterSuite() {
    	driver.close();
    	
    }

}
