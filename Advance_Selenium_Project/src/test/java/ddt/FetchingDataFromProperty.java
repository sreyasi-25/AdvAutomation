package ddt;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FetchingDataFromProperty {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create fileinputstream obj
		FileInputStream fis=new FileInputStream("./src/test/resources/prop.properties");
		
		//create the property file object
		Properties p=new Properties();
		
		//load file
		p.load(fis);

		//get the data which is stored in property file
		
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("usn"));
		System.out.println(p.getProperty("pass"));
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//String u = p.getProperty("url");
		//driver.get(u);
		
		 String loginurl = p.getProperty("loginurl");
		driver.get(loginurl);
		
		String eid=p.getProperty("Email");
		
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(eid);
		
		String pass=p.getProperty("Password");
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@type='submit'])[2]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
	}

	

}
