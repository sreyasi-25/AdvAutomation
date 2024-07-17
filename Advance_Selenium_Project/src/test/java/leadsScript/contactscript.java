package leadsScript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.JavaUtil;
import genriclib.WebdriverUtil;

public class contactscript {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		 WebdriverUtil wb=new WebdriverUtil();
	     ExcelUtil um=new ExcelUtil();
		
		WebDriver driver=new ChromeDriver();
		
		
		
		wb.maximizeTheWindow(driver);
		
		
		wb.implicitlyWait(driver);
		
		driver.get(um.getDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		
		//contacts
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		
		//create contact
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		JavaUtil ju=new JavaUtil();
		
		//firstname
		driver.findElement(By.name("firstname")).sendKeys(um.getDataFromExcelFile("Contacts",1 , 0));
		//lastname
		driver.findElement(By.name("lastname")).sendKeys(um.getDataFromExcelFile("Contacts",1 , 1));
		
         //organisation lookup
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		String pw = driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		System.out.println(wh);
	    wh.remove(pw);
		
		wb.switchToChildWindow(driver, wh, pw);
		
		//seach
		driver.findElement(By.name("search_text")).sendKeys("nike72");
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='nike72']")).click();
		Thread.sleep(3000);
		//switch back to parent window for save
		
		//driver.switchTo().window(pw);
		wb.getParentWindow(driver,pw);
		
     //save
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	}

}
