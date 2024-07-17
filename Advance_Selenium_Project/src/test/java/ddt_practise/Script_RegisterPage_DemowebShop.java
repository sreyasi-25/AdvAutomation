package ddt_practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script_RegisterPage_DemowebShop {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/prop1.properties");
		
		Properties p=new Properties();
		p.load(fis);
		
		WebDriver driver=new ChromeDriver();
		String url = p.getProperty("url");
		
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		//adding details
		
		//1-gender
		
		//driver.findElement(By.name("[name='Gender']")).click();
		driver.findElement(By.xpath("(//input[@name='Gender'])[2]")).click();
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis1);
		String sheet = wb.getSheet("Sheet7").getRow(1).getCell(0).toString();
		
		//username
		//String un = sheet.getRow(1).getCell(0).toString();
		System.out.println(sheet);
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(sheet);
		
		
		
		
		
	}
	
	
	

	

}
