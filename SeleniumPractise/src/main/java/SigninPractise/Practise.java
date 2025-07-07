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
		
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> countryList = driver.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]"));
		String country = "India";
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getText().equalsIgnoreCase(country)) {
				countryList.get(i).click();
				System.out.println("Country clicked");
				break;
			}
		}
		
		
		WebElement staticDrpdown = driver.findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
		
		Select dropdown = new Select(staticDrpdown);
		dropdown.selectByIndex(1);
		System.out.println("option1 clicked");
		Thread.sleep(2000);
		
		dropdown.selectByValue("option2");
		System.out.println("option2 clicked");
		Thread.sleep(2000);
		
		dropdown.selectByVisibleText("Option3");
		System.out.println("option3 clicked");
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[contains(@id,'alertbtn')]")).click();
		driver.switchTo().alert().accept();
		System.out.println("Alert clicked");
		Thread.sleep(2000);
		
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
		/*String Date ="9";
		String Month ="October";
		String Year = "2026";
		
		driver.findElement(By.xpath("//div[contains(@class,'react-date-picker__inputGroup')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__label')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__label')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
		Thread.sleep(2000);
		
		List<WebElement> monthList = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar__year-view__months__month')]"));
		for(int i=0;i<monthList.size();i++) {
			if(monthList.get(i).getText().equalsIgnoreCase(Month)) {
				monthList.get(i).click();
				System.out.println("Month clicked");
				break;
			}
		}
		
		Thread.sleep(1000);
		
//		driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar__month-view__days__day')]")).get(Integer.parseInt(Date)+2).click();
//		Thread.sleep(1000);
		
		List<WebElement>dateList = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar__month-view__days__day')]"));
		for(int j=0;j<dateList.size();j++) {
			if(dateList.get(j).getText().equalsIgnoreCase(Date)) {
				dateList.get(j).click();
				System.out.println("Date clicked");
				break;
			}
		} */
		/*
		//---------------Auto-suggestiveDRopdown----------------------------
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		String country = "India";
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getText().equalsIgnoreCase(country)) {
				countryList.get(i).click();
				System.out.println("Country clicked");
				break;
			}
		}
		
		//---------------StaticDRopdown----------------------------
		
		WebElement drpDown = driver.findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
		Select staticDrpdown = new Select(drpDown);
		staticDrpdown.selectByIndex(1);
		System.out.println("1ST OPTION CLICKED");
		Thread.sleep(2000);
		
		staticDrpdown.selectByValue("option2");
		System.out.println("2ND OPTION CLICKED");
		Thread.sleep(2000);
		
		staticDrpdown.selectByVisibleText("Option3");
		System.out.println("3RD OPTION CLICKED");
		Thread.sleep(2000);
		
		//---------------Alert----------------------------
		
		driver.findElement(By.xpath("//input[contains(@id,'alertbtn')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Alert accepted CLICKED");  */
		
		Thread.sleep(2000);
		driver.quit();
	}
}
