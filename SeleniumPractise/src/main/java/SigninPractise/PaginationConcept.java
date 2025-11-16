package SigninPractise;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class PaginationConcept {

	public static boolean fruitPresent(WebDriver driver,List<String> texts) {
		boolean allFound = true;
        String pageSource = driver.getPageSource();

        for (String text : texts) {
            if (pageSource.contains(text)) {
                System.out.println("Text '" + text + "' found on the page.");
            } else {
                System.out.println("Text '" + text + "' NOT found on the page.");
                allFound = false;
            }
        }
        return allFound;
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("Webdriver.chrome.driver" , "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Search:']")));
		
		//table[@class='table table-bordered']//tbody/tr/td[1] -- veggie name 

		//a[@aria-label='Next'] -- next button
        List<WebElement> vegname = driver.findElements(By.xpath("table[@class='table table-bordered']//tbody/tr/td[1]"));
        
        List<String> names = new ArrayList<String>();
        
        for(WebElement name:vegname) {
        	names.add(name.getText());
        }
        
        String[] namefruits = {"Wheat","Pineapple","Cheese"};
        List<String> finalname = Arrays.asList(namefruits);
        
       
        String nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next']")).getAttribute("aria-disabled");
        
		while(!nextbutton.contains("true")) {
			fruitPresent(driver, finalname);
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
			vegname = driver.findElements(By.xpath("table[@class='table table-bordered']//tbody/tr/td[1]"));
			
			for(WebElement name:vegname) {
	        	names.add(name.getText());
	        	System.out.println(vegname);
	        
	        }
			
			nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next']")).getAttribute("aria-disabled");
			
			for(String name:names) {
				System.out.println(name);
			}
		}
		
		
		
		
		
		driver.quit();;
	}

}
