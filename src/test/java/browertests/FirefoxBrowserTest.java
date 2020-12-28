package browertests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserTest {
   private static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/"+"geckodriver.exe");
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.quit();
	}
}
