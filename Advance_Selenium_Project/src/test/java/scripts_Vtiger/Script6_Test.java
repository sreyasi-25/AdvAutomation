package scripts_Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.ProductPage;

public class Script6_Test extends BaseClass {
	@Test
	public void ProductScript5() throws EncryptedDocumentException, IOException, InterruptedException {
		
		prod=new ProductPage(driver);
		
		prod.getProductLink().click();
		prod.getProductCreate().click();
		prod.getProductName().sendKeys(um.getDataFromExcelFile("Product", 2, 0));
		
		op.getSaveButton().click();
		Thread.sleep(2000);
		
	}

}
