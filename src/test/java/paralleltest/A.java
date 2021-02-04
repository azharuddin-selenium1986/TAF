package paralleltest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A {
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
      //this is new line.
		driver = new RemoteWebDriver(new URL(URL), caps);
		String sessionID = ((RemoteWebDriver) driver).getSessionId().toString();
		System.out.println(sessionID);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Azhar");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Loves Saba");
		Thread.sleep(5000);
		System.out.println("End Test");
		driver.quit();
		
		RestAssured.baseURI = "https://api.browserstack.com/automate/sessions/";
        RestAssured.authentication = RestAssured.preemptive().basic("testgmailkhan1", "C4shbTCqwRpvE6aAdbxt");
        RestAssured.given().header("Content-Type","Application/json").when().body("{\"status\":\"failed\", \"reason\":\"Deliberate Failing to test Browser Stack API\"}").put(sessionID+".json");
	}

}
