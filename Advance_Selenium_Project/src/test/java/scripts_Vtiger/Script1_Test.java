package scripts_Vtiger;


import java.io.IOException;

//import java.util.Random;


import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genriclib.BaseClass;
import pomRepo.OrganisationPage;

public class Script1_Test extends BaseClass {
	
	@Test(groups="organisation")
	public void script1() throws EncryptedDocumentException,InterruptedException, IOException {
		OrganisationPage op=new OrganisationPage(driver);
		op.getOrganisationLink().click();
	test.log(Status.INFO,"user is in organisation page");
		op.getCreateOrganisation().click();
		int random=ju.getRandomeNumber();
		op.getNameTextBox().sendKeys(um.getDataFromExcelFile("Organisation", 3, 0)+random);
	test.log(Status.INFO,"user entered values");
		Thread.sleep(2000);
		op.getSaveButton().click();
	test.log(Status.INFO,"organisation successfully created");
		Thread.sleep(3000);
	}

}
