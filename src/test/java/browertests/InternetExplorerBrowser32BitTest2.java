package browertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerBrowser32BitTest2 {

	
	 private static WebDriver driver;
		public static void main(String[] args) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/"+"IEDriverServer.exe");
			driver =  new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get("https://google.com");
			driver.findElement(By.name("q")).sendKeys("Azhar");
			driver.quit();
		}
}
