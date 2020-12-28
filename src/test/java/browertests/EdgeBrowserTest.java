package browertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserTest {
	
	private static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/" + "msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Azhar");
		driver.quit();
	}
	
	

}
