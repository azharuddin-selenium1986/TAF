package browertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class EdgeBrowserTest {
	
	private static WebDriver driver;
	
	@Test
	public void testcase2() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/" + "msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Azhar");
		Thread.sleep(5000);
		driver.quit();
	}
	

}
