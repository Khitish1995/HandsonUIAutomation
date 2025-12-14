package SigninPractise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;


public class GeoLocation_Notification {

    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	WebDriverManager.chromedriver().setup();
    	
        ChromeOptions options = new ChromeOptions();
        
        // Create a map to store the preferences
        Map<String, Object> prefs = new HashMap<>();
        
        // Key "profile.default_content_setting_values.geolocation" controls the location notification
        // Value 1 = Allow, Value 2 = Block
        prefs.put("profile.default_content_setting_values.geolocation", 1); // Set to 1 to allow

        // Set the experimental option "prefs"
        options.setExperimentalOption("prefs", prefs);

        // Initialize the ChromeDriver with the options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a website that requests geolocation
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // Example site

        // ... continue with your test steps
        
    	driver.quit();
    }   
}

