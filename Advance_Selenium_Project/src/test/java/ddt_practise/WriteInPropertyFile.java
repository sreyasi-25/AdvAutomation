package ddt_practise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteInPropertyFile {

	public static void main(String[] args) throws IOException {
	
		
		Properties p=new Properties();
		
		p.setProperty("name","sreyasi");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/prop1.properties");
		p.store(fos,"prop1" );

	}

}
