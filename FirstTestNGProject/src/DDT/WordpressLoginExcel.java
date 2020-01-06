package DDT;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib.ExcelDataConfig;

public class WordpressLoginExcel {

	WebDriver driver;
	@Test(dataProvider="wordpressData")
	public void LoginToWordpress(String username,String password) throws InterruptedException{
	
		System.setProperty("webdriver.gecko.driver","C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		Thread.sleep(4000);
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login - Invalid Credentials");
		System.out.println("Page Title verified - User is able to login Successfully");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider(name="wordpressData")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);  // 0 is means sheet1 in the excel file (sheet1 index = 0)
		
		Object[][] data = new Object[rows][2];
		for (int i=0;i<rows;i++){
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		return data;
	}
}