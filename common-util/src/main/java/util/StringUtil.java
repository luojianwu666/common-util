package util;

import java.util.Random;

public class StringUtil {
	
	public static boolean isNull(String str) {
		if(str==null || str.equals("")) {
			return false;
		}
		if(str!=null && !str.equals("") && !str.equals("''")) {
			return true;
		}
		
		
		return false;
	}
	
	public static boolean isPhone(String str) {
		String name="1[3458]\\d{9}";
		
		return str.matches(name);
	}
	
	public static boolean isEmail(String str) {
		String name="\\w+@\\w+\\.\\w+";
		
		return str.matches(name);
	}
	public static boolean isLetter(String str) {
		String name="[A-z]+";
		
		return str.matches(name);
	}
	
	public static String randomString(int i) {
		int maxNum=26;
		int ram;
		String[] str= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x",
				"y","z"};
		int count=0;
		StringBuffer stringBuffer = new StringBuffer();
		Random r=new Random();
		while(count<i) {
			ram=Math.abs(r.nextInt(maxNum));
			stringBuffer.append(str[ram]);
			count++;
		}
		
		
		
		return stringBuffer.toString();
	}
	public static String randomStringAndNum(int i) {
		int maxNum=36;
		int ram;
		String[] str= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x",
				"y","z","0","1","2","3","4","5","6","7","8","9"};
		int count=0;
		StringBuffer stringBuffer = new StringBuffer();
		Random r=new Random();
		while(count<i) {
			ram=Math.abs(r.nextInt(maxNum));
			
			stringBuffer.append(str[ram]);
			count++;
		}
		
		
		
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		/*System.out.println(isNull("4567"));
		System.out.println(isPhone("18345678911"));
		System.out.println(isEmail("11qq.com"));*/
		System.out.println(isLetter("ALaaa"));
		System.out.println(randomString(5));
		System.out.println(randomStringAndNum(6));
	}
	
	
	
	
}
