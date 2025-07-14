package AutomationPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singlemultiwindowsopen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@id,'openwindow')]")).click();
		
		Set<String> windowjump = driver.getWindowHandles();
		Iterator<String> itr = windowjump.iterator();
		String parentttwindow = itr.next();
		String childwindow = itr.next();
		
		driver.switchTo().window(childwindow);
		String childtitlewindow = driver.getTitle();
		System.out.println(childtitlewindow);
		Thread.sleep(2000);
		driver.switchTo().window(parentttwindow);
		String parenttitlewindow = driver.getTitle();
		System.out.println(parenttitlewindow);
		
		Thread.sleep(2000);
		driver.quit();

	}

}
