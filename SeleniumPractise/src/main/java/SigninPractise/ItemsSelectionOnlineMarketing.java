package SigninPractise;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ItemsSelectionOnlineMarketing {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		
		String[] itemsNeededname = {"Tomato","Beetroot","Mushroom","Cauliflower"};
		List<WebElement> veggiesname =driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j=0;
		for(int i=0;i<veggiesname.size();i++) {
			String[] veggiesplit = veggiesname.get(i).getText().split("-");
			String finalVeggiesname = veggiesplit[0].trim();
			
			List itemsNeedednamelist = Arrays.asList(itemsNeededname);
			if(itemsNeedednamelist.contains(finalVeggiesname)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				Thread.sleep(2000);
				System.out.println("Clicked item " +finalVeggiesname+ " successfully");
				j++;
				if(j==itemsNeededname.length) {
					break;
				}
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
