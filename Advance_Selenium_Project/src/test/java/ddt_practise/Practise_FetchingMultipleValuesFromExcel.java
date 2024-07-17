package ddt_practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practise_FetchingMultipleValuesFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
		FileInputStream fis =new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sheet=wb.getSheet("Sheet3");
		int rownum=sheet.getPhysicalNumberOfRows();
		int colnum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for (int i=0;i<rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				//String val = sheet.getRow(i).getCell(j).toString();
				//System.out.print(val);
				
				Cell data=sheet.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				String val2 = df.formatCellValue(data);
				System.out.print(val2);
				
				
				
			}
		}
		
		

	}

}
