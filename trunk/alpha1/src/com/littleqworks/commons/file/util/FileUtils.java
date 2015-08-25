/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.file.util;

import java.io.*;

import com.littleqworks.commons.util.*;

public class FileUtils {
	public static File createFile(String path){
		try{			
			File newFile=new File(path);
			if(newFile.exists()){
				newFile.delete();
			}
			newFile.createNewFile();
			return newFile;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static File createFile(String path,String filename){
		String dirSeparator=getDirSeparator();
		return createFile(path+dirSeparator+filename);
	}

	public static File createDir(String path){
		try{
			File newDir=new File(path);
			newDir.mkdirs();
			return newDir;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static File createDir(String path,String dirName){
		String dirSeparator=getDirSeparator();
		return createDir(path+dirSeparator+dirName);
	}
	
	public static long getFileSize(String completePath){
		File file=new File(completePath);
		return file.length();
	}
	
	public static String getFileName(String completePath){
		completePath=Filters.replaceChar(completePath, '\\', '/');	
		return completePath.substring(completePath.lastIndexOf('/')+1);
	}
	
	public static String getFileNameSuffix(String completePath){
		completePath=Filters.replaceChar(completePath, '\\', '/');	
		return completePath.substring(completePath.lastIndexOf('.')+1);
	}
	
	public static String getFilePath(String completePath){
		completePath=Filters.replaceChar(completePath, '\\', '/');	
		return completePath.substring(0, completePath.lastIndexOf('/'));
	}
	
	public static String getDirSeparator(){
		char dirSeparator='/';
		if(Filters.isChildIgnoreCase("windows", System.getProperty("os.name"))){
			//Detect OS type
			dirSeparator='\\';
		}
		return String.valueOf(dirSeparator);
	}
}
