package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorIcon;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement Logout;

	public WebElement getAdminstratorIcon() {
		return AdminstratorIcon;
	}

	public WebElement getLogout() {
		return Logout;
	}
	

}
