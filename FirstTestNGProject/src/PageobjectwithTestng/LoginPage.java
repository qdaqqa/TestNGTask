package PageobjectwithTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	By signin = By.xpath("/html/body/div[3]/header/div[3]/div/div[1]/div[2]/div[2]/a/span"); 
	By email = By.xpath("//*[@id='logonId']");
	By password = By.xpath("//*[@id='logonPassword']");
	By loginbtn = By.xpath("//*[@id='logonButton']");
	By logout = By.xpath("/html/body/div[3]/header/div[3]/div/div[1]/div[2]/div[2]/a/span");
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;       
    }
    
    public void clkSighinRegister(){
    	driver.findElement(signin).click();
    }
    
    public void setEmail(String Email){
    	driver.findElement(email).sendKeys(Email);
    }
    
    public void setPassword(String Password){
    	driver.findElement(password).sendKeys(Password);
    }
    
    public void clkBtn(){
    	driver.findElement(loginbtn).click();
    }
    public void Signout(){
    	driver.findElement(logout).click();
    }
}