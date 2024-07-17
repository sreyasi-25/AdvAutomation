package hardcode;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;

public class Script6StaleElementException {

	public static void main(String[] args) throws IOException {
	 WebDriver driver=new ChromeDriver();
	 WebdriverUtil wb=new WebdriverUtil();
	 ExcelUtil um=new ExcelUtil();
	 
	 wb.maximizeTheWindow(driver);
	 driver.get(um.getDataFromPropertyFile("url"));
	 
	 driver.findElement(By.name("user_name")).sendKeys(um.getDataFromPropertyFile("username"));
     driver.findElement(By.name("user_password")).sendKeys(um.getDataFromPropertyFile("password"));
	 driver.findElement(By.id("submitButton")).click();
	 
	WebElement searchbox = driver.findElement(By.name("query_string"));
	
	searchbox.sendKeys("contacts");
	
	//here we will get stale element exception
	wb.refreshThePage(driver);
	searchbox.sendKeys("contacts");
	 
	 
	 

	}

}
