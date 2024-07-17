import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchingDataFromProperty {

	public static void main(String[] args) throws IOException {
		
		//create fileinputstream obj
		FileInputStream fis=new FileInputStream("./src/test/resources/prop.properties");
		
		//create the property file object
		Properties p=new Properties();
		
		//load file
		
		p.load(fis);

		//get the data which is stored in property file
		
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("usn"));
		System.out.println(p.getProperty("pass"));
		
	}

}
