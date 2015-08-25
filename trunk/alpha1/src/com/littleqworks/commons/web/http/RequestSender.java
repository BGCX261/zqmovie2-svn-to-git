package com.littleqworks.commons.web.http;

import java.net.*;
import java.io.*;

public class RequestSender {
	private String urlStr;
	private URL url;
	private HttpURLConnection httpURLConnection;
	private String responseContent;
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public String getResponseContent() {
		return responseContent;
	}
	
	public void sendRequest(String method){
		try{
			url=new URL(urlStr);
			httpURLConnection=(HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod(method);
			httpURLConnection.setDoOutput(true);
			
			httpURLConnection.getOutputStream().flush();
			httpURLConnection.getOutputStream().close();
//			for(int i=0;i<7;i++)
//				System.out.println(httpURLConnection.getHeaderField(i));
			System.out.println(httpURLConnection.getResponseMessage());
/*			InputStream in=httpURLConnection.getInputStream();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in)); 
			StringBuilder tempStr=new StringBuilder();
			while(bufferedReader.read()!=-1){
				System.out.println(bufferedReader.readLine());
			}
			responseContent=new String(tempStr);
*/		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(httpURLConnection!=null){
				httpURLConnection.disconnect();
			}
		}
	}
}
