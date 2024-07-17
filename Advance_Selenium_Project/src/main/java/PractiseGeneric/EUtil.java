package PractiseGeneric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EUtil {
	
	public String getDatafromProperties(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/resources/practiseProp.properties");
		Properties p=new Properties();
		p.load(fis);
	    
        String value = p.getProperty(key);
		return value;
	}
	
	
	public String getDatafromExcel(String sheet,int rowNum,int ColNum) throws EncryptedDocumentException, IOException
	
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resourses/practiseexcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		String value1 = sh.getRow(rowNum).getCell(ColNum).toString();
		return value1;
		
		
	}

}
