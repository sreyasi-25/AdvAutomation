package code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genriclib.ExcelUtil;
import genriclib.JavaUtil;
import genriclib.WebdriverUtil;
import pomRepo.CampaignPage;
import pomRepo.HomePage;
import pomRepo.LoginPage;
import pomRepo.MorePage;
import pomRepo.OrganisationPage;

public class Campain_Assignment {

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
		
		//click on more link
		MorePage mp=new MorePage(driver);
		mp.getMoreLink().click();
		
		//click on campaign link
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampaignLink().click();
		
		Thread.sleep(2000);
		
		//create campaign and assign random no to it
		cp.getCreateCampaign().click();;
		Thread.sleep(2000);
		
		JavaUtil ju=new JavaUtil();
		int num = ju.getRandomeNumber();
		cp.getNameCampaign().sendKeys(um.getDataFromExcelFile("Campaign", 2, 0)+num);
		Thread.sleep(2000);
		
		
		//select the radio button for group
		cp.getRadioGroup().click();
		Thread.sleep(2000);
		
		WebElement grpDD = cp.getDropdownGroup();
		grpDD.click();
		
		//support gropup selection
		Select s=new Select(grpDD);
		s.selectByValue("4");
		Thread.sleep(2000);
		
		//save campaign
		OrganisationPage org=new OrganisationPage(driver);
		org.getSaveButton().click();
		
		//logout
		
		HomePage hp=new HomePage(driver);
		hp.getAdminstratorIcon().click();
		Thread.sleep(2000);
		hp.getLogout().click();
		
		

	}

}
