package firsttestngpackage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {

	private WebDriver driver;
    
    public HomePage(WebDriver driver) {
         
        this.driver = driver;
    }
     
    public String getErrorText() {
         
        return driver.findElement(By.className("error")).getText();
    }
}