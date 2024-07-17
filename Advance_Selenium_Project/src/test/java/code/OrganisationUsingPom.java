package code;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genriclib.ExcelUtil;
import genriclib.JavaUtil;
import genriclib.WebdriverUtil;
import pomRepo.LoginPage;
import pomRepo.OrganisationPage;

public class OrganisationUsingPom {

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
				//Thread.sleep(3000);
				
				OrganisationPage org=new OrganisationPage(driver);
				
				//navigate to organisation page		
				org.getOrganisationLink().click();
				
				//click on create organisation
				org.getCreateOrganisation().click();
				
				JavaUtil ju=new JavaUtil();
				org.getNameTextBox().sendKeys(um.getDataFromExcelFile("Organisation", 1, 0)+ju.getRandomeNumber());
				//org.getNameTextBox().sendKeys("puma");
				Thread.sleep(2000);
				org.getIndustryDropdown().click();
				Thread.sleep(2000);
				//org.getGroupRadioButton().click();
				WebElement dropdown = org.getIndustryDropdown();
				Select s=new Select(dropdown);
				s.selectByValue("Apparel");
				
				Thread.sleep(2000);
				org.getGroupRadioButton().click();
				
				WebElement dropdown2 = org.getDropdown2();
				org.getDropdown2().click();
				Select s1=new Select(dropdown2);
				s1.selectByValue("2");
				
				Thread.sleep(3000);
				org.getSaveButton().click();
			}

		}
		




