package DropdownCalendarPractise;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeCurrentScreenSS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Initialize the WebDriver
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sf = ts.getScreenshotAs(OutputType.FILE);
        File df = new File("C:/Softwares/ScreenshotsAuto/screenshot.png");
        FileUtils.copyFile(sf, df);
        System.out.println("Screenshot captured");
        
	}

}


