package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
		public static void closeAll(AutoCloseable ...autoCloseable) {
			for (AutoCloseable autoCloseable2 : autoCloseable) {
				try {
					autoCloseable2.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	
	
	public static String lastName(String str) {
		
		str=str.substring(str.lastIndexOf("."));
		
		
		
		return str;
	}
	
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				deleteFile(file2);
			}
			file.delete();
		}else {
			file.delete();
		}
	}

	public static String fileSize(File file) {
		long length=file.length();
		System.out.println(length);
		return String.format("%.2f", length/1024)+"kb";
	}
	
	public static void main(String[] args) throws IOException {
		//System.out.println(lastName("asd.jsp"));
		//System.out.println("C:\\Users\\10105\\Desktop\\demo2");
		/*File file=new File("C:\\Users\\10105\\Desktop\\sss");
		deleteFile(file);*/
		System.out.println(fileSize(new File("C:\\Users\\10105\\Desktop\\demo\\common-utils\\common-utils\\pom.xml")));;
		
	}
	
	
	
}
