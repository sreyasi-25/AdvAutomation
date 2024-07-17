package hardcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class script4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String Url = p.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
		
		Random ranNum=new Random();
		int num = ranNum.nextInt(100);
		
		
			
		//login
		
		String usernameTxtBox = p.getProperty("username");
		String pswTxtBox = p.getProperty("password");
		
		driver.findElement(By.name("user_name")).sendKeys(usernameTxtBox);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(pswTxtBox);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		//click on contact link
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//adding details in contact page
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/testData.xlsx");
		//FileInputStream fis1=new FileInputStream(".src/test/resources/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		
		Sheet sheet = wb.getSheet("Contacts");
		//String data = sheet.getRow(1).getCell(0).toString();
		
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		
		String data = cell.getStringCellValue()+num;
		
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data);
		
		//add organisation from lookup
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String parentId = driver.getWindowHandle();
		Set<String> alltabs = driver.getWindowHandles();
		alltabs.remove(parentId);
		for(String i:alltabs)
			
		{
					
			System.out.println(i);
			driver.switchTo().window(i);
			
			driver.findElement(By.id("search_txt")).sendKeys("Clinique20");
			
			WebElement dropdown = driver.findElement(By.name("search_field"));
			Select sel=new Select(dropdown);
			sel.selectByVisibleText("Organization Name");
			
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='Clinique20']")).click();
			
			Thread.sleep(3000);
		
		}
		
		
		
		
		driver.switchTo().window(parentId);
		
		//save the file
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		
		
		//logout
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
       
		
	}

}
