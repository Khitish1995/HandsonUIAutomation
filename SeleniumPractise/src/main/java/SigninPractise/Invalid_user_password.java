package SigninPractise;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invalid_user_password {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.name("inputPassword")).click();
		driver.findElement(By.name("inputPassword")).sendKeys("jblJEWH");
		
		driver.findElement(By.xpath("//button[contains(@class,'submit signInBtn')]")).click();
		Thread.sleep(2000);
		
		String expectedMssg = "* Incorrect username or password";
		String actualMssg = driver.findElement(By.xpath("//p[text()='* Incorrect username or password']")).getText();
		System.out.println(actualMssg);
		
		assertEquals(expectedMssg, actualMssg);
		
		
		driver.quit();
		

	}

}
