package firsttestngpackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.ExcelDataConfig;

public class test {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		/*System.setProperty("webdriver.gecko.driver","C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://www.ballarddesigns.com/";
		driver.get(url);*/
		
		
		
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\new\\workspace\\FirstTestNGProject\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][3];
		for (int i=0;i<rows;i++){
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
		}
		for (int i=0;i<data.length;i++){
				System.out.println(data[i][2]);
		}
	}
}