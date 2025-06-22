package AutomationPractice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).click();
		System.out.println("Empty space clicked");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Ind");
		Thread.sleep(3000);
		System.out.println("Empty space clicked second");
		List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		String dynamicCountry = "India"; 
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getText().equalsIgnoreCase(dynamicCountry)) {
				countries.get(i).click();
				System.out.println("clicked");
				break;
			}
		}

	}

}
