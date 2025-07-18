package AutomationPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabsopen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(@id,'opentab')]")).click();
		Set<String> windowwHandle = driver.getWindowHandles();
		Iterator<String> itr= windowwHandle.iterator();
		
		String parentID = itr.next();
		String childID = itr.next();
		
		driver.switchTo().window(childID);
		Thread.sleep(3000);
		String childtitle = driver.getTitle();
		System.out.println(childtitle);
		
		driver.switchTo().window(parentID);
		String pareenttitle = driver.getTitle();
		System.out.println(pareenttitle);
		Thread.sleep(3000);

		driver.close();
	}

}
