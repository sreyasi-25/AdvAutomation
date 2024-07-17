package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement Contactlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContact;
	
	@FindBy(name = "lastname")
	private WebElement LastName;

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getCreateContact() {
		return CreateContact;
	}

	public WebElement getLastName() {
		return LastName;
	}
}
