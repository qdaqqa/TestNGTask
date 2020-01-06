package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class DemoTestNG {
    String appUrl = "https://accounts.google.com";
  
    @Test
      public void gmailLogin() {
      String driverPath = "C:\\Users\\new\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
      System.setProperty("webdriver.gecko.driver",driverPath);
      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      capabilities.setCapability("marionette", true);
      WebDriver driver = new FirefoxDriver();
      driver.get("https://gmail.com");
      driver.manage().window().maximize();
      String expectedTitle = " Sign in - Google Accounts ";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(expectedTitle,actualTitle);
      WebElement username = driver.findElement(By.id("Email"));
      username.clear();
      username.sendKeys("TestSelenium");
      WebElement password = driver.findElement(By.id("Passwd"));
      password.clear();
      password.sendKeys("password123");
      WebElement SignInButton = driver.findElement(By.id("signIn"));
      SignInButton.click();
      driver.close();
  }
}
