package DropdownCalendarPractise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import dev.failsafe.internal.util.Assert;
import static org.junit.Assert.assertEquals;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String year = "2026";
		String month = "6";
		String Date = "12";
		String[] expectedList = {month,Date,year};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//div[@class='react-date-picker react-date-picker--closed react-date-picker--enabled']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//abbr[text()='"+Date+"']")).click();
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		

	for(int i =0; i<actualList.size();i++)
	
	{
	
	System.out.println(actualList.get(i).getAttribute("value"));
	
	assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
	
	   }
	
	//2nd way
	/*
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
	 */
	driver.quit();
	
	}

}
