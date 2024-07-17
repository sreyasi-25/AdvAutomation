package TestNgTopic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;
import pomRepo.LoginPage;

public class Script1 {
	ExcelUtil um=new ExcelUtil();
	WebdriverUtil wb=new WebdriverUtil();
	
	WebDriver driver=new ChromeDriver();
	@Test
	public void launch() throws IOException {
		
		//Reporter.log("testNG",true);
		//ExcelUtil um=new ExcelUtil();
		//WebdriverUtil wb=new WebdriverUtil();
		
		//WebDriver driver=new ChromeDriver();
		
		driver.get(um.getDataFromPropertyFile("url"));
		
		
	}
	
	@Test
	public void login() throws IOException {
		
		LoginPage l=new LoginPage(driver);
		l.getUserTextBox().sendKeys(um.getDataFromPropertyFile("username"));
		l.getPswd().sendKeys(um.getDataFromPropertyFile("password"));
		l.getLoginButton().click();
		
		
	}

	
	@Test
	public void logout() {
		
		Reporter.log("");
	}
	
	
	
}


