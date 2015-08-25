/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.mail;

import java.net.MalformedURLException;
import org.apache.commons.mail.*;

/**
 * MailSender.java
 * @author 谭孟泷
 * @version 0.01
 * Date modified: 11-Jul-07
 * @description 一个基于Apache Commons Mail的简易电子邮件发送器.<BR/>这是一个扩展的JavaBean，使用前需要填充Bean的内容。<BR/>
 */
public class MailSender {
	private String mailSenderAccountUserame;
	private String mailSenderAccountPassword;
	private String mailSmtpServerURL;
	private String mailSenderAdd;
	private String mailSenderName;
	

	public String getMailSenderAccountPassword() {
		return mailSenderAccountPassword;
	}

	public void setMailSenderAccountPassword(String mailSenderAccountPassword) {
		this.mailSenderAccountPassword = mailSenderAccountPassword;
	}

	public String getMailSenderAccountUserame() {
		return mailSenderAccountUserame;
	}

	public void setMailSenderAccountUserame(String mailSenderAccountUserame) {
		this.mailSenderAccountUserame = mailSenderAccountUserame;
	}

	public String getMailSenderAdd() {
		return mailSenderAdd;
	}

	public void setMailSenderAdd(String mailSenderAdd) {
		this.mailSenderAdd = mailSenderAdd;
	}

	public String getMailSenderName() {
		return mailSenderName;
	}

	public void setMailSenderName(String mailSenderName) {
		this.mailSenderName = mailSenderName;
	}

	public String getMailSmtpServerURL() {
		return mailSmtpServerURL;
	}

	public void setMailSmtpServerURL(String mailSmtpServerURL) {
		this.mailSmtpServerURL = mailSmtpServerURL;
	}
	
	/**
	 * 发送一封纯文本的电子邮件（简易版）<BR/>字符集默认为UTF-8.
	 * @param mailSubject 邮件的标题.
	 * @param mailReceiverAdd 收件人的邮件地址 .
	 * @param mailContents 邮件的内容 .
	 * @return
	 */
	public boolean sendText(String mailReceiverAdd,
												String mailSubject,
												String mailContents){
		try{
			return sendText(mailSubject,mailReceiverAdd,"utf-8",mailContents);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 发送一封纯文本的电子邮件.
	 * @param mailSubject 邮件的标题.
	 * @param mailReceiverAdd 收件人的邮件地址 .
	 * @param mailCharset 邮件的字符集.
	 * @param mailContents 邮件的内容 .
	 * @return
	 * @throws EmailException
	 */
	public boolean sendText(String mailReceiverAdd,
												String mailSubject,
												String mailCharset,
												String mailContents)
												throws EmailException{
		try{
			SimpleEmail email = new SimpleEmail();
			email.setAuthentication(this.mailSenderAccountUserame, this.mailSenderAccountPassword);
			email.setHostName(this.mailSmtpServerURL);
			email.addTo(mailReceiverAdd);
			email.setFrom(this.mailSenderAdd,this.mailSenderName);
			email.setSubject(mailSubject);
			email.setContent(mailContents, "text/plain;charset="+mailCharset);
			email.send();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
  
	/**
	 * 发送HTML格式的邮件（简易版）.<BR/>默认的邮件字符解为UTF-8，客户端不支持HTML的显示为"You client does not support HTML messages."
	 * @param mailReceiverAdd 收件人地址
	 * @param mailSubject 邮件主题
	 * @param mailHtmlContents 邮件HTML内容
	 * @return
	 */
	public boolean sendHtml(String mailReceiverAdd,
												String mailSubject,
												String mailHtmlContents){
		try{
			return sendHtml(mailSubject,mailReceiverAdd,"utf-8",mailHtmlContents,"You client does not support HTML messages.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 发送HTML格式的邮件.
	 * @param mailReceiverAdd 收件人地址
	 * @param mailSubject 邮件主题
	 * @param mailCharset 邮件内容的字符集
	 * @param mailHtmlContents 邮件HTML内容
	 * @param mailTextContents 客户端不支持HTML内容邮件时显示的纯文本内容
	 * @return
	 * @throws EmailException
	 * @throws MalformedURLException
	 */
	public boolean sendHtml(String mailReceiverAdd,
												String mailSubject,
												String mailCharset,
												String mailHtmlContents,
												String mailTextContents)
												throws EmailException, MalformedURLException{
		try{
			HtmlEmail email = new HtmlEmail();
			email.setAuthentication(this.mailSenderAccountUserame, this.mailSenderAccountUserame);
			email.setHostName(this.mailSmtpServerURL);
			email.setFrom(this.mailSenderAdd, this.mailSenderName);
			email.setSubject(mailSubject);
			email.addTo(mailReceiverAdd);
			email.setHtmlMsg(mailHtmlContents);
			email.setTextMsg(mailTextContents);
			email.send();
		}catch(EmailException ee){
			ee.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 发送带附件的邮件
	 * @return
	 * @throws MalformedURLException
	 * @throws EmailException
	 */
	//TODO:调试通过这个方法，目前能发送邮件，但不能发送附件。
	private boolean sendattechTest() throws MalformedURLException, EmailException{
		try{
			EmailAttachment attachment = new EmailAttachment();
   	 
			attachment.setPath("/home/webDev/Desktop/a.txt");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("a.txt");
			attachment.setName("a.txt");
	
			MultiPartEmail email = new MultiPartEmail();
			email.setAuthentication(this.mailSenderAccountUserame, this.mailSenderAccountPassword);
			email.setHostName("smtp.163.com");
			email.setFrom(this.mailSenderAdd, this.mailSenderName);
			email.setSubject("The xml");
			email.addTo("tanmenglong@gmail.com");
			email.setContent("这apache log", "text/plain;charset=utf-8");
			email.attach(attachment);
			email.send();
		}catch(EmailException ee){
			ee.printStackTrace();
			return false;
		}
		return true;
	}


}