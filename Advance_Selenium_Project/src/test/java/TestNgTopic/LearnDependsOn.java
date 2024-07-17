package TestNgTopic;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearnDependsOn {
	
	@Test(priority = 1)
	public void login() {
		
		int i=0;
		i=i/0;
		
		Reporter.log("user is logged in",true);
	}

	
	@Test(priority = 2,dependsOnMethods = "login")
	public void addToCart() {
		Reporter.log("user is in cart",true);
	}
	
	
	
	@Test(priority = 3,dependsOnMethods = "login")
	public void logout() {
		Reporter.log("user is logged out",true);
	}
}
