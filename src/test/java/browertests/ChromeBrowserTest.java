package browertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.*;

public class ChromeBrowserTest {
	private static WebDriver driver;

	public static final String USERNAME = "testgmailkhan1";
	public static final String AUTOMATE_KEY = "C4shbTCqwRpvE6aAdbxt";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void testcase1() throws InterruptedException, MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "80");
		caps.setCapability("name", "testgmailkhan1's First Test");
//	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/"+"chromedriver.exe");
//		driver = new ChromeDriver();
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Azhar");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Loves Saba");
		Thread.sleep(5000);
		System.out.println("End Test");
		driver.quit();
	}

}
