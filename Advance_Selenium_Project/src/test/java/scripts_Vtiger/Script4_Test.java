package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.CampaignPage;
import pomRepo.MorePage;

public class Script4_Test extends BaseClass {
	//public static MorePage mp=new MorePage(driver);
	//public static CampaignPage camp=new CampaignPage(driver);
	@Test
	public void campaignScript4() throws EncryptedDocumentException, IOException, InterruptedException {
		//more page
		mp=new MorePage(driver);
		mp.getMoreLink().click();
		
		//click on campaign link in more
		camp=new CampaignPage(driver);
		camp.getCampaignLink().click();
		
		camp.getCreateCampaign().click();
		int random = ju.getRandomeNumber();
		
		camp.getNameCampaign().sendKeys(um.getDataFromExcelFile("Campaign", 3, 0)+random);
		
		camp.getRadioGroup().click();
		WebElement grpdd = camp.getDropdownGroup();
		grpdd.click();
		Select s=new Select(grpdd);
		s.selectByValue("4");
		
		op.getSaveButton().click();
		//Thread.sleep(2000);
		
		
		
		
	}
	
	

}
