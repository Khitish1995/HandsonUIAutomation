package SigninPractise;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\SeleniumWebdriver\\ChromeDriver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		System.setProperty("Webdriver.gecko.driver", "C:\\Softwares\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new Chromedriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.browserstack.com/guide/run-selenium-tests-using-firefox-driver");
		synchronized (driver) {
		driver.wait(5000);
		System.out.println("Able to login");
		driver.manage().window().maximize();
		driver.wait(2000);
		driver.close();
		}
		System.out.println("Windows closed");
		
		
		
	}

}
