package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.MorePage;
import pomRepo.VendorPage;

public class Script7_Test extends BaseClass {
	@Test
	public void VendorScript7() throws EncryptedDocumentException, IOException, InterruptedException {
		
		mp=new MorePage(driver);
		mp.getMoreLink().click();
		
		vp=new VendorPage(driver);
		vp.getVendorLink().click();
		vp.getCreateVendor().click();
		int random = ju.getRandomeNumber();
		vp.getVendorName().sendKeys(um.getDataFromExcelFile("Vendor", 1, 0)+random);
		op.getSaveButton().click();
		Thread.sleep(2000);
	}
	

}
