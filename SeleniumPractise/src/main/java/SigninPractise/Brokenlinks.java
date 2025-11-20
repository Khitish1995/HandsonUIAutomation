package SigninPractise;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.Proxy;
import java.net.URL;



public class Brokenlinks {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(5000);

		Set<String> brokenlinkUrls = new HashSet<String>();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");	
			Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("hostname", 80));
			URL url = new URL(linkURL);
			URLConnection urlConnection = url.openConnection(proxy);
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			if(httpURLConnection.getResponseCode() != 200)
			{
				brokenlinkUrls.add(linkURL);
			}
//				System.out.println(linkURL + " - " + httpURLConnection.getResponseMessage());
//			else
//				System.err.println(linkURL + " - " + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage());
			
			httpURLConnection.disconnect();
		}

		driver.quit();
		
		for (String brokenLinkUrl : brokenlinkUrls) {
			System.err.println(brokenLinkUrl);

	  }
	}
  }
