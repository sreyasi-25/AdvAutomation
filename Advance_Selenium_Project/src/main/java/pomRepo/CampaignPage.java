package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	@FindBy (name = "Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateCampaign;
	
	//@FindBy(name = "campaignname")
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement NameCampaign;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement RadioGroup;
	
	public WebElement getCreateCampaign() {
		return CreateCampaign;
	}



	public WebElement getNameCampaign() {
		return NameCampaign;
	}



	public WebElement getRadioGroup() {
		return RadioGroup;
	}



	public WebElement getDropdownGroup() {
		return DropdownGroup;
	}

	@FindBy(name = "assigned_group_id")
	private WebElement DropdownGroup;
	
	

	public WebElement getCampaignLink() {
		return CampaignLink;
	}
}
