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

		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		String state = "India";
		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
		Thread.sleep(2000);
		System.out.println("sent country");
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getText().equalsIgnoreCase(state)) {
				countryList.get(i).click();
				System.out.println("Clixked country");
				break;
			}
		}
		
		WebElement meow = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select drpdown = new Select(meow);
		drpdown.selectByIndex(1);
		System.out.println("option 1 is clicked");
		Thread.sleep(2000);
		drpdown.selectByVisibleText("Option2");
		System.out.println("option 2 is clicked");
		Thread.sleep(2000);
		drpdown.selectByValue("option3");
		System.out.println("option 2 is clicked");
		
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		Thread.sleep(2000);
		System.out.println("About to click");
		driver.switchTo().alert().accept();
		System.out.println("It clicked");
		
		
		driver.quit();
	}

}
