package SigninPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> listCountry = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		String target = "India";
		
		for(int i=0;i<listCountry.size();i++) {
			if(listCountry.get(i).getText().equals(target)) {
			listCountry.get(i).click();
			System.out.println("Country Clicked");
			break;}
		}
		System.out.println("Windows closed");
		driver.close();
	}

}
