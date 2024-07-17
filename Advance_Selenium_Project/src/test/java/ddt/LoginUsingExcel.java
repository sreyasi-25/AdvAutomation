package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Formatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUsingExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		/*String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		driver.get(url);
		
		
	  String eid=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(eid);
		
		String pass=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
		*/
		
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		DataFormatter data=new DataFormatter();
	   // Cell url = wb.getSheet("Sheet1").getRow(1).getCell(0);
	   // Cell email = wb.getSheet("Sheet1").getRow(1).getCell(1);
	   // Cell pass = wb.getSheet("Sheet1").getRow(1).getCell(2);
	    
	    String url=wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
	    driver.get(url);
	   // data.formatCellValue(url);
	   // data.formatCellValue(url);
	    
		//yes
	  // driver.get();
		
		
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@type='submit'])[2]"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	}

}
