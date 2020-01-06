package PageobjectwithTestng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import lib.ExcelDataConfig;

public class TestNGPOM {

	WebDriver driver;
	
    @Test(dataProvider="storesData")
    public void testLoginNOK(String email, String password, String status) throws InterruptedException, IOException{
         
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://www.ballarddesigns.com/";
		driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.clkSighinRegister();
        Thread.sleep(1000);
        lp.setEmail(email);
        Thread.sleep(1000);
        lp.setPassword(password);
        Thread.sleep(1000);
        lp.clkBtn();
        if(status.equals("Positive") || status.equals("")){
        Assert.assertTrue(driver.getCurrentUrl().contains("krypto"), "Positive Test Case");
        Thread.sleep(1000);
        lp.Signout();
        }
        else if(status.equals("Negative")){
        Assert.assertTrue(driver.getCurrentUrl().contains("Logon"), "Negative Test Case");
        }
    }   
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    	driver.quit();
    }
    @DataProvider(name="storesData")
	public Object[][] sendData(){
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][3];
		for (int i=0;i<rows;i++){
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
		}
		return data;
	}
}