package DropdownCalendarPractise;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //implicitly wait latest
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //Explicitly wait - step 1 //This line initializes the wait.
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='product-name']"))); //Explicitly wait - step 2
		//wait.until(...): This is the method that performs the waiting. It polls the DOM for the condition to be met.
		//ExpectedConditions.visibilityOfElementLocated(By.id("elementId")): This is the condition to wait for.
		
		String[] list = {"Beetroot","Brinjal","Potato","Pumpkin"};
		List<WebElement> veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j=0;
		for(int i=0;i<veggies.size();i++) {
			String[] splittedlist = veggies.get(i).getText().split("-");
			String finalveggieslist = splittedlist[0].trim();
			List itemsneeded = Arrays.asList(list);
			if(itemsneeded.contains(finalveggieslist)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				//Thread.sleep(2000);
				System.out.println("Clicked items " +finalveggieslist+ " successfully");
				j++;
				if(j==finalveggieslist.length()) {
					break;
				}
			}
		}
		
		//Thread.sleep(2000);
		driver.quit();
		
	}

}
