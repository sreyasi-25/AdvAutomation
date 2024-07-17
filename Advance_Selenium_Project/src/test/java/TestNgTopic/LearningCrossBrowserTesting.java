package TestNgTopic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;

public class LearningCrossBrowserTesting {
	
	WebDriver driver;
	WebdriverUtil wb=new WebdriverUtil();
	ExcelUtil um=new ExcelUtil();
	@Parameters("browser")
	@Test
	public void Launch(@Optional("firefox")String bname) throws IOException {
		if (bname.contains("chrome")) {
			driver=new ChromeDriver();
			wb.maximizeTheWindow(driver);
			driver.get(um.getDataFromPropertyFile("url"));
		}
		
		else if (bname.contains("firefox")) {
			driver=new FirefoxDriver();
			wb.maximizeTheWindow(driver);
			driver.get(um.getDataFromPropertyFile("url"));
		}
	

}}
