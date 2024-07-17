package code;

import java.io.IOException;

import org.apache.poi.sl.draw.geom.GuideIf.Op;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.WebdriverUtil;
import pomRepo.ContactPage;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class ContactScript {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebdriverUtil wb=new WebdriverUtil();
        ExcelUtil um=new ExcelUtil();
        
		
		
		WebDriver driver=new ChromeDriver();
		
		wb.maximizeTheWindow(driver);
		wb.implicitlyWait(driver);
	    driver.get(um.getDataFromPropertyFile("url"));
		
	    LoginPage lp=new LoginPage(driver);
	  
		lp.getUserTextBox().sendKeys(um.getDataFromPropertyFile("username"));
		Thread.sleep(2000);
		
		lp.getPswd().sendKeys(um.getDataFromPropertyFile("password"));
		
		Thread.sleep(2000);
		
		lp.getLoginButton().click();
		Thread.sleep(3000);
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactlink().click();
		Thread.sleep(2000);
		cp.getCreateContact().click();
		Thread.sleep(2000);
		cp.getLastName().sendKeys(um.getDataFromExcelFile("Contacts", 3, 0));
		
		OrganisationPage org=new OrganisationPage(driver);
		org.getSaveButton().click();
		
		
		
		
		
		

	}

}
