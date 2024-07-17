package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.LeadsPage;

public class Script5_Test extends BaseClass{
	
	@Test
	public void leadsScript5() throws EncryptedDocumentException, IOException, InterruptedException {
		leads=new LeadsPage(driver);
		
		leads.getLeadslink().click();
		leads.getCreateLead().click();
		int random = ju.getRandomeNumber();
		leads.getLastname().sendKeys(um.getDataFromExcelFile("Leads", 2, 0)+random);
		leads.getCompanyname().sendKeys(um.getDataFromExcelFile("Leads", 2, 1));
		
		WebElement statusDD = leads.getLeadstatus();
		statusDD.click();
		Select s=new Select(statusDD);
		s.selectByValue("Contacted");
		
		op.getSaveButton().click();
		Thread.sleep(2000);
		
		
	}

}
