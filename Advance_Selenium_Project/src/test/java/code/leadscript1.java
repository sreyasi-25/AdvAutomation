package code;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class leadscript1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Random ran=new Random();
		int num = ran.nextInt(10);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/practiseProp.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
		String UNTextfeild = p.getProperty("username");
		String PassTextfeild = p.getProperty("password");
		

		driver.findElement(By.name("user_name")).sendKeys(UNTextfeild);
		driver.findElement(By.name("user_password")).sendKeys(PassTextfeild);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		//clicking leads link
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		Thread.sleep(2000);
		
		
		//create new lead
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(2000);
		
		//fetching data from excel
		
		FileInputStream fis1 =new FileInputStream("./src/test/resources/practiseexcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sheet=wb.getSheet("Sheet1");
		
		String lastname = sheet.getRow(1).getCell(0).toString();
		String company = sheet.getRow(1).getCell(1).toString();
		
		driver.findElement(By.name("lastname")).sendKeys(lastname+num);
		driver.findElement(By.name("company")).sendKeys(company);
		
		//select from dropdown lead status
		WebElement dropdown = driver.findElement(By.name("leadstatus"));
		Select s=new Select(dropdown);
	    s.selectByValue("Contacted");
	    
	    //click on save
	    
	    driver.findElement(By.name("button")).click();  
		
	    
	}

}
