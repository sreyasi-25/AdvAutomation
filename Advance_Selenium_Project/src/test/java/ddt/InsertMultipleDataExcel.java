package ddt;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class InsertMultipleDataExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		
		//for inserting elements
		
		for(int i=0;i<links.size();i++)
		{
			
			
		}
		
		
		

	}

}
