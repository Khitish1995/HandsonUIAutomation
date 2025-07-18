package SigninPractise;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class secondPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		
		
		List<WebElement> veggiesList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j=0;
		for(int i=0;i<veggiesList.size();i++) {
			String[] name = veggiesList.get(i).getText().split("-");
			String veggiesName = name[0].trim();
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(veggiesName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				System.out.println("Clicked this " +veggiesName+ " Successfully");
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
