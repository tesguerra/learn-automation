package ecommDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginDemo
{
	 public static String driverPath = "C:/Users/819178/Downloads/chromedriver_win32/";
	 public static WebDriver driver;
	 	 

	 public static void main (String[] args) {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("http://automationpractice.com/index.php");

//1) Login to the application
			driver.findElement(By.className("login")).click();
			driver.findElement(By.id("email")).sendKeys("selenatest001@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("tester0!");
			driver.findElement(By.id("SubmitLogin")).click();

//VALIDATE MY ACCOUNT PAGE
			String strPageTitle = driver.getTitle();
			System.out.println("Page title is "+strPageTitle);
			
			Assert.assertTrue(strPageTitle.equalsIgnoreCase("My account - My Store"), "Page title doesn't match");

//VALIDATE TEXT			
			String infoAccountText = driver.findElement(By.className("info-account")).getText();
			System.out.println("My account text is: " + infoAccountText);
			String expText = "Welcome to your account. Here you can manage all of your personal information and orders.";
	        if(infoAccountText.contains(expText)){
	            System.out.println("1) Expected text '"+expText+"' present in the web page.");
	        }else{
	            System.out.println("1) Expected text '"+expText+"' is not present in the web page.");
	        }

//2) Selecting a product category from Top Menu	
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"block_top_menu\"]/ul/li[1]/a")));
	        element.click();
	        driver.findElement(By.xpath(".//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
	        driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
	        driver.findElement(By.xpath(".//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	        
	      //*[@id="layer_cart"]/div[1]/div[1]/h2
	      //*[@id="layer_cart"]/div[1]/div[1]/h2
	      //*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]/span
	      //*[@id="center_column"]/ul/li[2]/div/div[2]/div[2]/a[1]/span
//3) Selecting a product and adding it to the cart
//4) Go to checkout page to provide personal details and complete the order
//5) Verify details from final Confirmation page	        
	        
//			driver.findElement(By.className("logout")).click();
			driver.quit();
		}
			
		
}
