package com.littleqworks.commons.mail;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailSender ms=new MailSender();
		try{
			ms.setMailSenderAccountUserame("cool_tml");
			ms.setMailSenderAccountPassword("3216tml000854");
			ms.setMailSenderAdd("cool_tml@163.com");
			ms.setMailSenderName("Crackcell");
			ms.setMailSmtpServerURL("smtp.163.com");
			System.out.println(ms.sendText("ThisIsHello", "tanmenglong@gmail.com", "HELLO"));
//			System.out.println(ms.sendHtml("我是", "crackcell@126.com", "gb2312", "<html><head><title>Hello</title></head><body>我是谭孟泷   <img src='http://www.iciba.com/image/Logo.gif'></body></html>","you"));
		}catch(Exception e){
			
		}

	}

}
