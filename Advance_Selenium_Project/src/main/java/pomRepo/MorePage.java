package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
	
	
	public WebElement getMoreLink() {
		return MoreLink;
	}

	public MorePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "//a[@href='javascript:;']")
	private WebElement MoreLink;

}
