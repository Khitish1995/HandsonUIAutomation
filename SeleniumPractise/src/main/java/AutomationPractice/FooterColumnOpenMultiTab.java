package AutomationPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterColumnOpenMultiTab {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement coloumnfooterdriver = driver.findElement(By.xpath("//tbody//tr//td[1]//ul"));
		
		System.out.println(coloumnfooterdriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<coloumnfooterdriver.findElements(By.tagName("a")).size();i++) {
			
			String clickon = Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumnfooterdriver.findElements(By.tagName("a")).get(i).sendKeys(clickon);
			Thread.sleep(3000);
		}
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();
		while(itr.hasNext()) {
		  driver.switchTo().window(itr.next());	
		  System.out.println(driver.getTitle());
		}
		
		
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
