package SigninPractise;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webelementadditioncalculation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//WebElement myele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Type to Select Countries')]")));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement eleID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='dropdown-class-example']")));
		int sum=0;
		List<WebElement> stress = driver.findElements(By.xpath("(//div[@class='left-align'])[3]//tbody/tr/td[3]"));
		for(int i=0;i<stress.size();i++) {
			String number = stress.get(i).getText();
			System.out.println("Each time the course price " + number);
			sum = sum + Integer.parseInt(number);
		}
		System.out.println(sum);
		
		
		driver.quit();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		/*List<WebElement> veggielist = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		String VegCaught = "Cheese";
		
		for(int i=0;i<veggielist.size();i++) {
			Thread.sleep(2000);
				if(veggielist.get(i).getText() != VegCaught) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
					
				}
			
			//catch(NoSuchElementException productException) {
				
			
		}
		  }*/  
} 
  } 
    
