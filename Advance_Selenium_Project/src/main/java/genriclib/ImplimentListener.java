package genriclib;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ImplimentListener extends BaseClass implements ITestListener {
	
	private static final String String = null;

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test Script execution started",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result){
		
		Reporter.log("Test Script Failed",true);
		
		Reporter.log(result.getName());
		
		//take the screen shot when the script failed.will take the screen shot at the place it failed
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File trg=new File("./screenShot/one.png");
		File trg=new File(IConstant.ScreenShotPath);
	    try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Script Passes",true);
	}

}
