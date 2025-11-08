package SigninPractise;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class secondPractise {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='brand greenLogo']/child::div")));
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> qaz = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		String country = "India";
		for(int i=0;i<qaz.size();i++) {
			String plm = qaz.get(i).getText();
			if(qaz.get(i).getText().equals(country)) {
				qaz.get(i).click();
				System.out.println("Country clicked " + plm);
				break;
			}
		}
		//just for practice
		Thread.sleep(2000);
		driver.quit();
	}

}
