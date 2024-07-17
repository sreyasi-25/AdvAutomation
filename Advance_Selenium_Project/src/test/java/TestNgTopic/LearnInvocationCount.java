package TestNgTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearnInvocationCount {

	@Test(invocationCount = 3)
	public void Demologin() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		//driver.quit();
		
	}
	
	
	@Test(invocationCount = 2)
	public void Amazonlogin() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		Thread.sleep(2000);
		
		//driver.quit();
		
	}
	
	
	
	
	
}


