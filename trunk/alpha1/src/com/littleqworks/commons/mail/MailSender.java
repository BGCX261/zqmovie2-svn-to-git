/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.mail;

import java.net.MalformedURLException;
import org.apache.commons.mail.*;

/**
 * MailSender.java
 * @author ̷����
 * @version 0.01
 * Date modified: 11-Jul-07
 * @description һ������Apache Commons Mail�ļ��׵����ʼ�������.<BR/>����һ����չ��JavaBean��ʹ��ǰ��Ҫ���Bean�����ݡ�<BR/>
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
	 * ����һ�ⴿ�ı��ĵ����ʼ������װ棩<BR/>�ַ���Ĭ��ΪUTF-8.
	 * @param mailSubject �ʼ��ı���.
	 * @param mailReceiverAdd �ռ��˵��ʼ���ַ .
	 * @param mailContents �ʼ������� .
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
	 * ����һ�ⴿ�ı��ĵ����ʼ�.
	 * @param mailSubject �ʼ��ı���.
	 * @param mailReceiverAdd �ռ��˵��ʼ���ַ .
	 * @param mailCharset �ʼ����ַ���.
	 * @param mailContents �ʼ������� .
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
	 * ����HTML��ʽ���ʼ������װ棩.<BR/>Ĭ�ϵ��ʼ��ַ���ΪUTF-8���ͻ��˲�֧��HTML����ʾΪ"You client does not support HTML messages."
	 * @param mailReceiverAdd �ռ��˵�ַ
	 * @param mailSubject �ʼ�����
	 * @param mailHtmlContents �ʼ�HTML����
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
	 * ����HTML��ʽ���ʼ�.
	 * @param mailReceiverAdd �ռ��˵�ַ
	 * @param mailSubject �ʼ�����
	 * @param mailCharset �ʼ����ݵ��ַ���
	 * @param mailHtmlContents �ʼ�HTML����
	 * @param mailTextContents �ͻ��˲�֧��HTML�����ʼ�ʱ��ʾ�Ĵ��ı�����
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
	 * ���ʹ��������ʼ�
	 * @return
	 * @throws MalformedURLException
	 * @throws EmailException
	 */
	//TODO:����ͨ�����������Ŀǰ�ܷ����ʼ��������ܷ��͸�����
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
			email.setContent("��apache log", "text/plain;charset=utf-8");
			email.attach(attachment);
			email.send();
		}catch(EmailException ee){
			ee.printStackTrace();
			return false;
		}
		return true;
	}


}