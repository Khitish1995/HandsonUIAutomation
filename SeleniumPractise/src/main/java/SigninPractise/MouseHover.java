package SigninPractise;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[4]")));
		//document.querySelector('.tableFixHead').scrollTop=5000
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		WebElement elec = driver.findElement(By.xpath("//button[@id='mousehover']"));
		a.moveToElement(elec).build().perform();
		Thread.sleep(4000);
		
		driver.quit();
	}

}
