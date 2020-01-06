package FirstTask;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import lib.ExcelDataConfig;
public class StoresLoginExcel {

	WebDriver driver;
	
	@Test(dataProvider="storesDataPositive", priority = 0)
	public void LogintoStorePositive(String email, String password) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "https://www.ballarddesigns.com/";
		driver.get(url);
		// Click on Sign in/Register link
		driver.findElement(By.xpath("/html/body/div[3]/header/div[3]/div/div[1]/div[2]/div[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// Insert Email to its field
		driver.findElement(By.xpath("//*[@id='logonId']")).sendKeys(email);
		Thread.sleep(1000);
		// Insert Password to its field
		driver.findElement(By.xpath("//*[@id='logonPassword']")).sendKeys(password);
		Thread.sleep(1000);
		// Click on Sign In buttonl
		driver.findElement(By.xpath("//*[@id='logonButton']")).click();
		//Assert.assertTrue(driver.getTitle().contains("My Account"),"User is not able to login - Invalid Credentials");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("HomeView"), "Positive");
	}
	@Test(dataProvider="storesDataNegative", priority = 1)
	public void LogintoStoreNegative(String email, String password) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "https://www.ballarddesigns.com/";
		driver.get(url);
		// Click on Sign in/Register link
		driver.findElement(By.xpath("/html/body/div[3]/header/div[3]/div/div[1]/div[2]/div[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// Insert Email to its field
		driver.findElement(By.xpath("//*[@id='logonId']")).sendKeys(email);
		Thread.sleep(1000);
		// Insert Password to its field
		driver.findElement(By.xpath("//*[@id='logonPassword']")).sendKeys(password);
		Thread.sleep(1000);
		// Click on Sign In buttonl
		driver.findElement(By.xpath("//*[@id='logonButton']")).click();
		Assert.assertFalse(driver.getCurrentUrl().contains("LogonView"), "Negative");
	}
	@AfterMethod
	public void Exit(){
		driver.quit();
	}
	@DataProvider(name="storesDataPositive")
	public Object[][] sendDataPositive(){
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][1];
		for (int i=0;i<rows;i++){
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
		}
		return data;
	}
	@DataProvider(name="storesDataNegative")
	public Object[][] sendDataNegative(){
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(1);
		
		Object[][] data = new Object[rows][2];
		for (int i=0;i<rows;i++){
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
		}
		return data;
	}
}