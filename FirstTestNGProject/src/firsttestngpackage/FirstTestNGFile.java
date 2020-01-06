package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class FirstTestNGFile {
  
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
    public WebDriver driver ; 
	
    @BeforeTest
    public void luanchBrowser(){
    	  System.out.println("launching firefox browser"); 
	      //System.setProperty("webdriver.firefox.marionette", driverPath);
	      System.setProperty("webdriver.gecko.driver",driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
    }
	@Test
  public void verifyHomepageTitle() {  
	      String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
  }
	@AfterTest
  public void terminateBrowser(){
		driver.close();
	}	
}