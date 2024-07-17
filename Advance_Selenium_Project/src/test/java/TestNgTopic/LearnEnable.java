package TestNgTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LearnEnable {
	@Test(enabled = false)
	public void DemoLaunch() throws InterruptedException {
	
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
	
	@Test(enabled = true)
	public void amazonLaunch() throws InterruptedException {
	
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://amazon.com/");
		Thread.sleep(2000);
		
		driver.quit();
	}	

}
