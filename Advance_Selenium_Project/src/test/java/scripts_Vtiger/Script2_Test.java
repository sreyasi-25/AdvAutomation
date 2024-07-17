package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genriclib.BaseClass;

public class Script2_Test extends BaseClass {
	
	@Test
	public void script2() throws EncryptedDocumentException, IOException, InterruptedException {
		
		cp.getContactlink().click();
		cp.getCreateContact().click();
		int random=ju.getRandomeNumber();
		cp.getLastName().sendKeys(um.getDataFromExcelFile("Contacts", 1, 0)+random);
		op.getSaveButton().click();
		Thread.sleep(3000);
	}
	

}
