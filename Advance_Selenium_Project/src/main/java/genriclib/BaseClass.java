package genriclib;

import java.io.IOException;
import java.lang.reflect.*; //reflect.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomRepo.CampaignPage;
import pomRepo.ContactPage;
import pomRepo.HomePage;
import pomRepo.LeadsPage;
import pomRepo.LoginPage;
import pomRepo.MorePage;
import pomRepo.OrganisationPage;
import pomRepo.ProductPage;
import pomRepo.VendorPage;
//to add listners
@Listeners(ImplimentListener.class)
public class BaseClass{
	
	public static WebDriver driver ;//  =new ChromeDriver();
	public static WebdriverUtil wb ;
	
	public static ExcelUtil um = new ExcelUtil();
	public static JavaUtil ju = new JavaUtil();
	public static LoginPage lp;
	public static HomePage hp;
	public static OrganisationPage op ;
	public static ContactPage cp;
	public static CampaignPage camp;
	public static MorePage mp;
	public static LeadsPage leads;
	public static ProductPage prod;
	public static VendorPage vp;
	
	/*public static LoginPage lp =new LoginPage(driver);
	public static HomePage hp=new HomePage(driver);*/
	// public static OrganisationPage op =new OrganisationPage(driver);
	//public static ContactPage cp =new ContactPage(driver);
	//public static CampaignPage camp;
	//public static MorePage mp;
	
	//public static CampaignPage camp=new CampaignPage(driver);
	//public static MorePage mp=new MorePage(driver);
	
	/*public static LeadsPage leads=new LeadsPage(driver);
	public static ProductPage prod=new ProductPage(driver);
	public static VendorPage vp=new VendorPage(driver);*/
	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	public ExtentTest test;
	
	
	
//report generation	
@BeforeSuite
public void beforeSuit() {
	
	Reporter.log("Report Generation",true);
 reporter=new ExtentSparkReporter(IConstant.reportPath);
 reports=new ExtentReports();
 reports.attachReporter(reporter);
 
}




//launch
@BeforeClass
public void beforeClass() throws IOException, InterruptedException {
	Thread.sleep(3000);
	
	
	driver  = new ChromeDriver();
	wb = new WebdriverUtil();
	op = new OrganisationPage(driver);
	cp = new ContactPage(driver);
    
	wb.maximizeTheWindow(driver);
	//test.log(Status.INFO,"windows maximised");
	wb.implicitlyWait(driver);
	driver.get(um.getDataFromPropertyFile("url"));
	
}

//login
@BeforeMethod(alwaysRun = true)
public void beforeMethod(Method method) throws IOException {
    // LoginPage lp =new LoginPage(driver);
	
	
	test=reports.createTest(method.getName());
	
	lp=new LoginPage(driver);
	test.log(Status.INFO,"user loged in");
	lp.getUserTextBox().sendKeys(um.getDataFromPropertyFile("username"));
	test.log(Status.INFO,"user entered username");
	lp.getPswd().sendKeys(um.getDataFromPropertyFile("password"));
	test.log(Status.INFO,"user entered password");
	lp.getLoginButton().click();
	
}	
	
//Afters
//logout
@AfterMethod
public void AfterMethod() throws InterruptedException {
	//HomePage hp=new HomePage(driver);
	hp=new HomePage(driver);
	hp.getAdminstratorIcon().click();
	
	hp.getLogout().click();
	test.log(Status.INFO,"user logged out");
	Thread.sleep(2000);
}

//close driver
@AfterClass
public void AfterClass() throws InterruptedException {
	System.out.println("Testing the after class: ");
	try
	{
	wb.driverClose(driver); }
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	Thread.sleep(2000);
}

//report generation
@AfterSuite
public void AfterSuit() {
	
	Reporter.log("Report",true);
	reports.flush();
}

	
}
