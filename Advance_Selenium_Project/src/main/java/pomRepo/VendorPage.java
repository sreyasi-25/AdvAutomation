package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	public VendorPage (WebDriver driver)  {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "Vendors")
	private WebElement VendorLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateVendor;
	
	@FindBy(name = "vendorname")
	private WebElement VendorName;

	public WebElement getVendorName() {
		return VendorName;
	}

	public WebElement getCreateVendor() {
		return CreateVendor;
	}

	public WebElement getVendorLink() {
		return VendorLink;
	}
	

}
