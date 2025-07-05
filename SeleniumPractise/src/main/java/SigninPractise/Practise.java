package SigninPractise;

import static org.junit.Assert.assertEquals;

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
		
		String year = "2024";
		String date = "15";
		String month = "06";
		String[] ExpectedList = {month,date,year};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
	/*	//------------------------DynamicDropdown-----------------------------------------//
		
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		 String targetCountry = "India";
		for(int i=0;i<countryList.size();i++) {
			System.out.println("Entered for loop");
			if(countryList.get(i).getText().equalsIgnoreCase(targetCountry)) {
				System.out.println("Entered if loop");
				countryList.get(i).click();
				Thread.sleep(2000);
				System.out.println("Targeted destination clicked");
				Thread.sleep(2000);
				break;
			}
		}
		
		//------------------------StaticDropdown-----------------------------------------//
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		dropdown.selectByValue("option1");
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Option3");
		Thread.sleep(2000);
		
		//------------------------------Alert------------------------------------------//
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Alert handled");
		Thread.sleep(2000);
		driver.quit();      
		
		*/
		
		//------------------------------Calendar----------------------------------------//
		String Date = "8";
		String Month = "7";
		String Year = "2026";
		String[] expectedList = {Month,Date,Year};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month react-date-picker__inputGroup__input--hasLeadingZero']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
		System.out.println("Year Clicked");
		Thread.sleep(2000);
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(Month)-1).click();
		System.out.println("month Clicked");
		Thread.sleep(2000);
		driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar__month-view__days__day')]")).get(Integer.parseInt(Date)+1).click();
		
		Thread.sleep(2000);
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<actualList.size();i++) {
		 System.out.println(actualList.get(i).getAttribute("value"));	
		 
		 assertEquals(actualList.get(i).getAttribute("value") , expectedList[i]);
		}
		Thread.sleep(4000);
		driver.quit();
	}
}
