package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	public LeadsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		}
	
	@FindBy (xpath = "//a[@href='index.php?module=Leads&action=index']")
	private WebElement leadslink;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateLead;
	
	@FindBy (name = "lastname")
	private WebElement lastname;
	
	@FindBy (name = "company")
	private WebElement companyname;
	
	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getCompanyname() {
		return companyname;
	}

	@FindBy(name = "leadstatus")
	private WebElement leadstatus;
	

	public WebElement getCreateLead() {
		return CreateLead;
	}


	public WebElement getLeadstatus() {
		return leadstatus;
	}


	public WebElement getLeadslink() {
		return leadslink;
	}

	
}
