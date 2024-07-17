package genriclib;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtil {
	WebDriver driver;
	/**
	 * for maximising the page
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * for refreshing the page
	 * 
	 */
	public void refreshThePage (WebDriver driver) {
		driver.navigate().refresh();
	}
/**
 * for forward the page
 * @param driver
 */
	public void forwardThePage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * method for implicit wait
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void elementToBeClickWait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is to switch the frame using webelement...if want some more tye switch we can add rest
	 * @param driver
	 */
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	/**
	 * used to switch back the driver control to main page
	 */
	public void switchBackToParentPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * used to select dropdown using value
	 */
	public void selectDropdownByValue(WebElement dropdown,String value)
	{
		Select s=new Select(dropdown);
		s.selectByValue(value);
	}
	/**
	 * used to select the dropdown from visible text
	 * @param dropdown
	 * @param visibleText
	 */
	public void selectDropdownByVisibleText(WebElement dropdown,String visibleText)
	{
		Select s=new Select(dropdown);
		s.selectByValue(visibleText);
	}
	
	/**
	 * Tis method is used to deselect
	 */
	
	public void deselectDropdownByVisibleText(WebElement dropdown,String visibleText)
	{
		Select s=new Select(dropdown);
		s.deselectByValue(visibleText);
	}
	
	/**
	 * this method is for handling simpleAlert
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to click cancel button in popup
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 */
	
	public void clickOnElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
	
	
	
	public void doubleClick(WebElement element) {
		
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
public void contextClick(WebElement element) {
		
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();;
	}
/**
 * scrolling up the window
 * @param driver
 */

public void scrollUp(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-500);");
	
	}

/**scrolling down window
 * 
 */

public void scrollDown(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500);");
}


public void switchToChildWindow(WebDriver driver,Set<String> wh,String pw) throws InterruptedException {
	
	/*	
	String pw = driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		System.out.println(wh);
	     wh.remove(pw);
	 */    
	    for (String i :wh) {
	     driver.switchTo().window(i);
	     Thread.sleep(3000);
	     
	        }
    
     
        }

public void getWindowahandles(WebDriver driver) throws InterruptedException {
	String pw = driver.getWindowHandle();
	Set<String> wh = driver.getWindowHandles();
	System.out.println(wh);
     wh.remove(pw);
    for (String i :wh) {
     driver.switchTo().window(i);
     Thread.sleep(3000);
     
        }
 //   driver.switchTo().window(pw);
}
    
    public void getParentWindow(WebDriver driver,String pw)
    {
    	System.out.println("parent window"+driver.getWindowHandle());
    	
    	// driver.getWindowHandle();
    	System.out.println(pw);
    	
        driver.switchTo().window(pw);
    	  
        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
    }
    
    
    public void driverClose(WebDriver driver)
    {
    	driver.close();
    }
    
    
}


	
	
	
	
	
	
	

 