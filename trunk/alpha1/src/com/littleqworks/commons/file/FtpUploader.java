/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.file;

import java.io.*;
import java.net.SocketException;
import org.apache.commons.net.ftp.*;

import com.littleqworks.commons.util.*;

public class FtpUploader {
	/**
	 * FTP文件上传
	 * @param is 上传文件的InputStream
	 * @param serverFileName FTP服务器端文件名
	 * @param serverPath FTP服务器端文件路径
	 * @param serverUrl FTP服务器位置(IP等)
	 * @param serverPort FTP服务器端口
	 * @param userName FTP服务器帐号用户名
	 * @param passWord FTP服务器帐号密码
	 * @return
	 * @throws FileOperationException
	 */
	public boolean uploadFromServlet(InputStream is,
															String serverFileName,
															String serverPath,
															String serverUrl,
															int serverPort,
															String userName,
															String passWord) throws IOException{
		
		FTPClient ftp = new FTPClient();
		FTPClientConfig conf=new FTPClientConfig();
		conf.setServerLanguageCode("zh_CN");
		conf.setServerTimeZoneId("Asia/Chongqing");
		
		try {
			ftp.configure(conf);
			int reply;
			
			//设置FTP连接的端口
			ftp.setDefaultPort(serverPort);
			
			//连接服务器
			ftp.connect(serverUrl);
			
			//得到服务器返回的信息
			reply=ftp.getReplyCode();
			
			//如果连接不是Positive方式，则断开连接并抛出异常
			if (!FTPReply.isPositiveCompletion(reply)){
            	ftp.disconnect();
            	throw new IOException("FTP server refused connection.");
			}
		}catch(IOException e){
			disconnectFtp(ftp);
		}
		
		try{	
			//验证用户登录
			if(!ftp.login(userName, passWord)){
				throw new IOException("Can not log in with given username and password.");
			}
		 
			//验证路径转向
			if(!ftp.changeWorkingDirectory(serverPath)){
				throw new IOException("Can not change to working directory.");
			}
			
			//打开二进制传输方式
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			
			//验证能否向服务器传输文件
			if(!ftp.storeFile(serverFileName,is)){
				throw new IOException("Can not store file to FTP server.");
			}
			is.close();
		}catch (SocketException e) {
			e.printStackTrace();
			return false;
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			if (ftp != null && ftp.isConnected()) {
				try {
					ftp.logout();
					ftp.disconnect();
				}catch (IOException e) {
					e.printStackTrace();
					return false;
		        }
			}
		}		
		return true;
	}

	private static boolean disconnectFtp(FTPClient ftp) throws IOException{
		if (ftp.isConnected()){
			try{
				ftp.disconnect();
			}catch (Exception e){
				throw new IOException("Can not close connection.");
			}
		}
		return true;
	}
}
