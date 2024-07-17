package ddt_practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_practise {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/prop.properties");
		
		Properties pobj =new Properties();
		
		pobj.load(fis);
		
		String val=pobj.getProperty("url");
        System.out.println(val);
	}

}
