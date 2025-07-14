package SigninPractise;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		//Dynamic Dropdown
		
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).sendKeys("Ind");
		Thread.sleep(2000);

		String country = "India";
		List<WebElement> countryList = driver.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]"));
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getText().equalsIgnoreCase(country)) {
				countryList.get(i).click();
				System.out.println("Clicked the country");
				Thread.sleep(2000);
				break;
			}
		}
		

		//Static dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
		Select staticdrpdown = new Select(dropdown);
		staticdrpdown.selectByIndex(1);
		System.out.println("1st quota clicked");
		Thread.sleep(2000);
		
		staticdrpdown.selectByValue("option2");
		System.out.println("2nd quota clicked");
		Thread.sleep(2000);
		
		staticdrpdown.selectByVisibleText("Option3");
		System.out.println("3rd quota clicked");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@id,'alertbtn')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Alert clicked");
		
		//switch Tab Example
		driver.findElement(By.xpath("//a[contains(@id,'opentab')]")).click();
		
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> jump = windowhandles.iterator();
		
		String parentid = jump.next();
		String childid = jump.next();
		
		driver.switchTo().window(childid);
		String childtitle = driver.getTitle();
		Thread.sleep(2000);
		System.out.println(childtitle);
		
		driver.switchTo().window(parentid);
		String parenttitle = driver.getTitle();
		Thread.sleep(2000);
		System.out.println(parenttitle);
		System.out.println("Switch window started");
		System.out.println();
		//switch window Example
		
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
