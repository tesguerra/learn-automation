package targetDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TargetLogin
{
	 public static String driverPath = "C:/Users/819178/Downloads/chromedriver_win32/";
	 public static WebDriver driver;
	 	 

	 public static void main (String[] args) {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://www.target.com/");
			
			driver.findElement(By.id("account")).click();
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"accountNav-signIn\"]/a/div")));
			
			element.click();
			driver.findElement(By.id("username")).sendKeys("selenatest001@gmail.com");
//			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("password")).sendKeys("tester0!");
			driver.findElement(By.id("login")).click();

			String strPageTitle = driver.getTitle();
			System.out.println("Page title is "+strPageTitle);
//			driver.quit();
		}
			
		
}
