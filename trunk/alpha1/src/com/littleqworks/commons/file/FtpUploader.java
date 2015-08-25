/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.file;

import java.io.*;
import java.net.SocketException;
import org.apache.commons.net.ftp.*;

import com.littleqworks.commons.util.*;

public class FtpUploader {
	/**
	 * FTP�ļ��ϴ�
	 * @param is �ϴ��ļ���InputStream
	 * @param serverFileName FTP���������ļ���
	 * @param serverPath FTP���������ļ�·��
	 * @param serverUrl FTP������λ��(IP��)
	 * @param serverPort FTP�������˿�
	 * @param userName FTP�������ʺ��û���
	 * @param passWord FTP�������ʺ�����
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
			
			//����FTP���ӵĶ˿�
			ftp.setDefaultPort(serverPort);
			
			//���ӷ�����
			ftp.connect(serverUrl);
			
			//�õ����������ص���Ϣ
			reply=ftp.getReplyCode();
			
			//������Ӳ���Positive��ʽ����Ͽ����Ӳ��׳��쳣
			if (!FTPReply.isPositiveCompletion(reply)){
            	ftp.disconnect();
            	throw new IOException("FTP server refused connection.");
			}
		}catch(IOException e){
			disconnectFtp(ftp);
		}
		
		try{	
			//��֤�û���¼
			if(!ftp.login(userName, passWord)){
				throw new IOException("Can not log in with given username and password.");
			}
		 
			//��֤·��ת��
			if(!ftp.changeWorkingDirectory(serverPath)){
				throw new IOException("Can not change to working directory.");
			}
			
			//�򿪶����ƴ��䷽ʽ
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			
			//��֤�ܷ�������������ļ�
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
