package com.bawei.luojianwu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public static String lastName(String fileName ) {
		
		//处理空异常
				if(fileName==null || "".equals(fileName)) {
					throw new RuntimeException("文件名不能为空");
				}
				if(fileName.indexOf(".")<=-1) {
					throw new RuntimeException(fileName+":该文件名没有包含扩展名");
				}
				String extName = fileName.substring(fileName.lastIndexOf("."));
				return fileName ;
		
		
		
		
	}
	
	/**
	 * 获取系统当前用户目录
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
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

	/**
	 * @Title: getSystemTempDirectory   
	 * @Description: 操作系统临时目录
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	
	
	
	
	public static String fileSize(File file) {
		long length=file.length();
		System.out.println(length);
		return String.format("%.2f", length/1024)+"kb";
	}
	
	/**
	 * @Title: readTextFileByLine   
	 * @Description: 读取文件内容   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@SuppressWarnings("resource")
	public static String readTextFileByLine(String pathname) {
		String str=null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			while((str=br.readLine())!=null) {
				
				sb.append(str);
				sb.append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll(br);
		}
		return sb.toString();
	}
	
	/**
	 * @Title: readTextFileOfList   
	 * @Description: 按行读取文件内容到list集合   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	@SuppressWarnings("resource")
	public static List<String> readTextFileOfList(String pathname) {
		String str=null;
		BufferedReader br = null;
		List<String> strList = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			while((str=br.readLine())!=null) {
				
				strList.add(str);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll(br);
		}
		return strList;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//System.out.println(lastName("asd.jsp"));
		//System.out.println("C:\\Users\\10105\\Desktop\\demo2");
		/*File file=new File("C:\\Users\\10105\\Desktop\\sss");
		deleteFile(file);*/
		//System.out.println(fileSize(new File("C:\\Users\\10105\\Desktop\\demo\\common-utils\\common-utils\\pom.xml")));;
		//System.out.println(FileUtil.readTextFileByLine("C:\\Users\\10105\\Desktop\\新建文本文档.txt"));
		List<String> readTextFileOfList = FileUtil.readTextFileOfList("C:\\Users\\10105\\Desktop\\新建文本文档.txt");
		for (String string : readTextFileOfList) {
			System.out.println(string);
		}
	}
	
	
	
}
