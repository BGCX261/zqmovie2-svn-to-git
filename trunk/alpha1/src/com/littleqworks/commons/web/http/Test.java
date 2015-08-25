package com.littleqworks.commons.web.http;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestSender requestSender=new RequestSender();
		requestSender.setUrlStr("http://www.ublog.cn/user1/6730/archives/2006/22176.html");
		requestSender.sendRequest("POST");
		System.out.println(requestSender.getResponseContent());

	}

}
