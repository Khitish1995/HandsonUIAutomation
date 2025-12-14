package SigninPractise;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;

public class Brokenlinks {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.linkedin.com/");
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(5000); // 5 seconds wait

        Set<String> brokenlinkUrls = new HashSet<String>();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement link : links) {
            String linkURL = link.getAttribute("href");	
            
            // --------------------------------------------------------------------------------
            // ✨ CRITICAL FIX: Filter out invalid/internal/empty links before checking
            // --------------------------------------------------------------------------------
            if (linkURL == null || linkURL.isEmpty() || 
                linkURL.startsWith("javascript:") || 
                linkURL.contains("#")) { // Exclude internal page anchors
                continue; 
            }
            
            // FIX from previous conversation: Change HTTPS to HTTP to avoid SSL checks
            if (linkURL.startsWith("https://")) {
                linkURL = linkURL.replace("https://", "http://");
            }
            
            // --------------------------------------------------------------------------------
            
            HttpURLConnection httpURLConnection = null; // Declare outside try/catch for finally block
            try {
                URL url = new URL(linkURL);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                
                // You MUST remove the proxy lines (Proxy proxy = new...) if you aren't using one.
                
                httpURLConnection.setConnectTimeout(5000); // 5 seconds connection timeout
                httpURLConnection.connect();
                
                // Get the response code
                int responseCode = httpURLConnection.getResponseCode();
                
                if(responseCode != 200)
                {
                    brokenlinkUrls.add(linkURL + " (Code: " + responseCode + " - Msg: " + httpURLConnection.getResponseMessage() + ")");
                }
                
            } catch (IOException e) {
                // Catch network or malformed URL exceptions
                brokenlinkUrls.add(linkURL + " (Exception: " + e.getMessage() + ")");
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }

        driver.quit();
        
        System.out.println("\n--- Broken Links Found (" + brokenlinkUrls.size() + ") ---");
        for (String brokenLinkUrl : brokenlinkUrls) {
            System.err.println(brokenLinkUrl);
        }
        System.out.println("------------------------------------------");
    }
}