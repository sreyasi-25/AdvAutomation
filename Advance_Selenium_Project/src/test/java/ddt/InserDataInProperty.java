package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InserDataInProperty {

	public static void main(String[] args) throws IOException {
		
		Properties p=new Properties();
		p.setProperty("url","https://demowebshop.tricentis.com/login");
		p.setProperty("Email", "abc@gmail.com");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/prop1.properties");
		p.store(fos,"prop1");
		
		System.out.println("Data has been inserted");
		
		

	}

}
