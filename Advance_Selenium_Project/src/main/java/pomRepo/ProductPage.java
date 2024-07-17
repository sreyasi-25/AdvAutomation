package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productCreate;
	
	@FindBy(name = "productname")
	private WebElement productName;

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getProductCreate() {
		return productCreate;
	}

	public WebElement getProductName() {
		return productName;
	}
	
}
