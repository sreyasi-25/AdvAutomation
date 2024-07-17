package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

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

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
	/*	//fetching values
		System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
		
		//wb.getSheet("Sheet1").getRow(1).getCell(2).getNumericCellValue();
		System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(1).getNumericCellValue());
		
		System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(2).getBooleanCellValue());
		*/
		Cell cell1 = wb.getSheet("Sheet1").getRow(1).getCell(0);
		Cell cell2 = wb.getSheet("Sheet1").getRow(1).getCell(1);
		Cell cell3 = wb.getSheet("Sheet1").getRow(1).getCell(2);
		
		DataFormatter data=new DataFormatter();
		System.out.println(data.formatCellValue(cell1));
		System.out.println(data.formatCellValue(cell2));
		System.out.println(data.formatCellValue(cell3));
       
	}

}

