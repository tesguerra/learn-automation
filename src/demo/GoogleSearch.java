package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch 
{
	 public static String driverPath = "C:/Users/819178/Downloads/chromedriver_win32/";
	 public static WebDriver driver;
	 	 

	 public static void main (String[] args) {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://www.google.com/");

			driver.findElement(By.xpath(".//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input")).sendKeys("selenium");
			driver.findElement(By.xpath(".//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input")).sendKeys(Keys.RETURN);
			String strPageTitle = driver.getTitle();
			System.out.println("Page title is "+strPageTitle);
			driver.quit();
		}
			
		
}
