package SigninPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import graphql.Assert;


public class SignIn {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rahul");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit signInBtn')]")).click();
		Thread.sleep(2000);
		
		String[] actualText = driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText().split(" ");
		String splittedText = actualText[2].trim();
		System.out.println(splittedText);
		
		driver.quit();
		
		
		
	  } 
	}

