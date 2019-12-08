package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamUtil {
	
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
	
	
	
	public static String readLine(String pathName) throws IOException {
		StringBuffer sb=new StringBuffer();
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(new File(pathName)));
			do {
				sb.append(br.readLine());
				sb.append("\n");
			} while (br.read()!=-1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			br.close();
		}
		
		return sb.toString();
	}
	
	public static void writeText(String context,File file,boolean append) {
		BufferedWriter bf=null;
		
		String parent=file.getParent();
		File parentFile =new File(parent);
		if(!parentFile.exists()) {
			parentFile.mkdir();
		}
		
		
		try {
			bf=new BufferedWriter(new FileWriter(file,append));
			
			bf.write(context);
			bf.write("\n");
			bf.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
	//	System.out.println(readLine("C:\\Users\\10105\\Desktop\\demo2\\pom.xml"));
		String context="按时打算打多少";
		File file=new File("C:\\Users\\10105\\Desktop\\demo2\\ddddd.txt");
	writeText(context, file, true);
	
	}
	
	
	
	
	
	
	
	
}
