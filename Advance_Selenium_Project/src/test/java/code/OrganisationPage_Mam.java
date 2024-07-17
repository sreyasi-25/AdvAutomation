package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genriclib.ExcelUtil;
import genriclib.JavaUtil;
import genriclib.WebdriverUtil;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class OrganisationPage_Mam {

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
		
		
		JavaUtil ju=new JavaUtil();
		OrganisationPage op=new OrganisationPage(driver);
		
		op.getOrganisationLink().click();
		op.getCreateOrganisation().click();
		int num = ju.getRandomeNumber();
		op.getNameTextBox().sendKeys(um.getDataFromExcelFile("Organisation",3 , 0)+num);
		
		op.getSaveButton().click();
		
		
		
		

	}

}

