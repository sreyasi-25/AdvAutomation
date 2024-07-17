package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule1-constructor of this class where we will pass driver referance and also initilise the web element
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Rule2-to find element we will be using @FindBy
	
	@FindBy(name="user_name")
	private WebElement userTextBox;
	
	@FindBy(name="user_password")
	private WebElement pswd;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Powered by vtiger CRM - 5.4.0']")
	private WebElement Text;

	
	//Rule3-getters
	
	public WebElement getText() {
		return Text;
	}

	public WebElement getUserTextBox() {
		return userTextBox;
	}

	public WebElement getPswd() {
		return pswd;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
