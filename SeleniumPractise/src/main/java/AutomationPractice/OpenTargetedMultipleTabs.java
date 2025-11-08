package AutomationPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenTargetedMultipleTabs {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement columnfooterdriver = driver.findElement(By.xpath("//tbody//tr//td[1]//ul"));
		System.out.println(columnfooterdriver.findElements(By.tagName("a")).size());
		for(int i=0;i<columnfooterdriver.findElements(By.tagName("a")).size();i++) {
			
			String clicking = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnfooterdriver.findElements(By.tagName("a")).get(i).sendKeys(clicking);
			Thread.sleep(3000);
		}

		Set<String> footerwin = driver.getWindowHandles();
		Iterator<String> footitr = footerwin.iterator();
		String targettitle = "Learn REST API Design - REST API Tutorial";
		
		while(footitr.hasNext()) {
			String windowhandle = footitr.next();
			driver.switchTo().window(windowhandle);
			
			String currenttitle = driver.getTitle();
			System.out.println("Title name started");
			System.out.println(currenttitle);
			if(currenttitle.contains(targettitle)) {
				System.out.println("Targeted Tab Title: " + currenttitle);
				break;
			}
			
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
