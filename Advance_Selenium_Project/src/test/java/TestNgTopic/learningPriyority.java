package TestNgTopic;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class learningPriyority {
	
	@Test(priority=1)
	public void logout() {
		Reporter.log("logout",true);
		
	}
	
	
	@Test(priority=-1)
	public void login() {
		Reporter.log("login",true);
		
	}
	
	
	@Test(priority=0)
	public void addCart()
	{
		Reporter.log("addtocart",true);
	}

}
