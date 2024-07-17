package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//locating the elements
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement OrganisationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrganisation;
	
	
    @FindBy(name="accountname")
    private WebElement nameTextBox;
    
    @FindBy(name="industry")
    private WebElement industryDropdown;
    
    @FindBy(xpath = "//input[@value='T']")
    private WebElement groupRadioButton;
    
    @FindBy(name="button")
    private WebElement saveButton;
    
    @FindBy(xpath = "//select[@name='assigned_group_id']")
    //@FindBy(name="assigned_group_id")
    private WebElement dropdown2;
    
    //generate getters

	

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDropdown2() {
		return dropdown2;
	}

	public WebElement getOrganisationLink() {
		System.out.println("I am in OrgLink");
		return OrganisationLink;
	}

	public WebElement getCreateOrganisation() {
		System.out.println("I am in orgCreate");
		return CreateOrganisation;
	}

	public WebElement getNameTextBox() {
		return nameTextBox;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}
}
