package genriclib;
/**
 * @Chandana
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
public String getDataFromPropertyFile( String key) throws IOException {
	FileInputStream fis=new FileInputStream(IConstant.propertyFilePath);
	Properties p=new Properties();
	p.load(fis);
	return p.getProperty(key);
}


public String getDataFromExcelFile(String sheetname,int rowNum,int colNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(IConstant.excelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet=wb.getSheet(sheetname);
	return sheet.getRow(rowNum).getCell(colNum).toString();
}
/**
 * the below method is used to fetch the data from excel file with data formatter
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
public String getDataFromExcelFileDF(String sheetname,int rowNUm,int colNum) throws EncryptedDocumentException, IOException
{
	
FileInputStream fis=new FileInputStream(IConstant.excelFilePath);
Workbook wb=WorkbookFactory.create(fis);
Sheet sheet=wb.getSheet(sheetname);
Cell data=sheet.getRow(rowNUm).getCell(colNum);
DataFormatter result=new DataFormatter();
return result.formatCellValue(data);
}

/**for screenshot it is associated with date and time
 * 
 */
public static String getCurrentTime() {
	
	LocalDateTime datetime=LocalDateTime.now();
	String date=datetime.toString().replace(":","-");
	return date;
}



}
