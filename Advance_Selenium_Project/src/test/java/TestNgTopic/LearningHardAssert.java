package TestNgTopic;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genriclib.BaseClass;
import pomRepo.OrganisationPage;

public class LearningHardAssert  extends BaseClass {
	
	@Test(groups="organisation")
	public void script1() throws EncryptedDocumentException, IOException, InterruptedException {
		OrganisationPage op=new OrganisationPage(driver);
		op.getOrganisationLink().click();
		
		assertEquals(driver.getTitle()," Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		op.getCreateOrganisation().click();
		int random=ju.getRandomeNumber();
		op.getNameTextBox().sendKeys(um.getDataFromExcelFile("Organisation", 3, 0)+random);
		Thread.sleep(2000);
		op.getSaveButton().click();
		Thread.sleep(3000);

}}
