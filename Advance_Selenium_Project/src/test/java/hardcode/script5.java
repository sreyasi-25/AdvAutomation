package hardcode;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;

public class script5 {

	public static void main(String[] args) throws IOException {
        WebdriverUtil wb=new WebdriverUtil();
        ExcelUtil um=new ExcelUtil();
        
		
		WebDriver driver=new ChromeDriver();
		wb.maximizeTheWindow(driver);
		
		
		wb.implicitlyWait(driver);
		driver.get(um.getDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();

		

	}

}
