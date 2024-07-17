package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.OrganisationPage;

public class Script8_Test extends BaseClass {
	
	@Test(groups="organisation")
	public void organisationScript2() throws EncryptedDocumentException, IOException, InterruptedException {
		op =new OrganisationPage(driver); 
		
		op.getOrganisationLink().click();
		op.getCreateOrganisation().click();
		int random=ju.getRandomeNumber();
		op.getNameTextBox().sendKeys(um.getDataFromExcelFile("Organisation", 1, 0)+random);
		WebElement dropdown1 = op.getIndustryDropdown();
		dropdown1.click();
		Select s=new Select(dropdown1);
		s.selectByValue("Apparel");
		
		op.getGroupRadioButton().click();
		 WebElement dropdown2 = op.getDropdown2();
		 dropdown2.click();
		 Select s1=new Select(dropdown2);
		 s1.selectByValue("2");
		 
		 Thread.sleep(2000);
		 op.getSaveButton().click();
		 
		 Thread.sleep(2000);
		
		
	}
	

}
