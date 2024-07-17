package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;
import pomRepo.LoginPage;

public class ScriptUsingPom {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		WebdriverUtil wb=new WebdriverUtil();
		ExcelUtil um=new ExcelUtil();
		
		wb.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
		
		driver.get(um.getDataFromPropertyFile("url"));
		
		LoginPage lp =new LoginPage(driver);
		
		lp.getUserTextBox().sendKeys(um.getDataFromPropertyFile("username"));
		lp.getPswd().sendKeys(um.getDataFromPropertyFile("password"));
		lp.getLoginButton().click();
		

	}

}
