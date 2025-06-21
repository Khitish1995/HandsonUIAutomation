package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement Drop = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select drpdown = new Select(Drop);
		drpdown.selectByValue("option1");
		Thread.sleep(4000);
		drpdown.selectByVisibleText("Option2");
		Thread.sleep(2000);
		drpdown.selectByIndex(3);
		Thread.sleep(2000);
		driver.quit();
		

	}

}
