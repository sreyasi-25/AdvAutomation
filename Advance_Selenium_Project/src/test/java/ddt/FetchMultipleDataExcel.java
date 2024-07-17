package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis =new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet2");
		
		int rolnum =sheet.getPhysicalNumberOfRows();
		int colnum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for (int i=0;i<rolnum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				//will return the all value in string format only
				//String value1 = sheet.getRow(i).getCell(j).toString();
				//System.out.println(value1);
				
				//will return the value in the format which it is stored
				Cell data = sheet.getRow(i).getCell(j);
				
				DataFormatter datas=new DataFormatter();
				String value2 = datas.formatCellValue(data);
				
				System.out.println(value2);
				
				
			}
			
			System.out.println( );
		}
		
		

	}

}
