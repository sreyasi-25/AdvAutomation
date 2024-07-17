package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_ToDemoWebShop_usingExcel_withFetchAndStore {
	
	
		

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
			
			//WebDriver driver=new ChromeDriver();
			
			FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
			
			Workbook wb=WorkbookFactory.create(fis);
			
						
			wb.getSheet("Sheet2").createRow(3).createCell(0).setCellValue("https://demowebshop.tricentis.com/login");
			
		//	wb.getSheet("Sheet1").createRow(4).createCell(0).setCellValue("https://www.myntra.com");
			
			
			FileOutputStream fos=new FileOutputStream("./src/test/resources/exceldata.xlsx");
			wb.write(fos);
			wb.close();
			
			
			WebDriver driver=new ChromeDriver();
			
 
		
		
		
		
		
	}
	
	

}
