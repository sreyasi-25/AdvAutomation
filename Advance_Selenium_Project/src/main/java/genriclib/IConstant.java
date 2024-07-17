package genriclib;
/**
 * for storing the path for the files (property and excelfile)
 */
public class IConstant {
	
	public static String propertyFilePath="./src/test/resources/commonData.properties";
	public static String excelFilePath="./src/test/resources/testData.xlsx";
	
	public static String ScreenShotPath="./screenShot/"+ExcelUtil.getCurrentTime()+".png";
	
	public static String reportPath="./reports/"+ExcelUtil.getCurrentTime()+".png";

}
