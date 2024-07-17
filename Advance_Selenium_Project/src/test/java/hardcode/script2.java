package hardcode;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class script2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url=p.getProperty("url");
		String usernameTxtBox=p.getProperty("username");
		String pswTxtBox=p.getProperty("password");
		Random ranNum=new Random();
		int num=ranNum.nextInt(100); 
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(usernameTxtBox);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(pswTxtBox);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		//navigate to organisation page
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//click on create organisation
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//entering mandatory feild
		FileInputStream fis1=new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sheet=wb.getSheet("Organisation");
		
		//sheet.getRow(0).getCell(0).toString();
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		String data = cell.getStringCellValue()+num;
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("988675432");
		
		
		
		//for save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		//logout
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

	}

}
