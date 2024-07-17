package genriclib;

import java.util.Random;

public class JavaUtil {
	/**
	 * add randome num 
	 */
	public int getRandomeNumber() {
		Random random=new Random();
		int num=random.nextInt(100);
		return num;
	}

}
