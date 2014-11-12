package password_box;

import java.util.Arrays;

public class password_engine {
	
	public static boolean checkpassword(char[] password){
		char[] correct_pword = {'B','u','g','a','b','o','o'};
		if (Arrays.equals(correct_pword,password)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
