/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.webGuard;

/**
* VerifyCode.java
* @author ̷����
* @version 0.03
* Last Date: 29-Mar-07
* Description: ��֤��.
*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class SimpleSecurityCode extends HttpServlet{
	private ServletConfig servletConfig=null;
	private String sessionAttributeName=null;
//	private static final String CONTENT_TYPE="image/jpeg; charset=GB2312";

	//Initialize global variables
	public void init(ServletConfig servletConfig) throws ServletException{
		this.servletConfig=servletConfig;
		sessionAttributeName=servletConfig.getInitParameter("sessionAttributeName");
	}
	
	//Process the HTTP Get request
	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
					throws ServletException,IOException{
		response.setContentType("image/jpeg;charset=gb2312");
		//����ҳ�治����
		HttpSession session=request.getSession();

		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		// ���ڴ��д���ͼ��
		int width=60, height=20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ��ȡͼ��������
		Graphics g = image.getGraphics();
		// �趨����ɫ
		g.setColor(getRandColor(155,254));
		//g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, width, height);
		//�趨����
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		//���߿�
		//g.setColor(new Color());
		//g.drawRect(0,0,width-1,height-1);
		// �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(getRandColor(160,220));

		//���������
		Random random = new Random();

		for(int i=0;i<155;i++){
			int x=random.nextInt(width);
		    int y=random.nextInt(height);
			int xl=random.nextInt(12);
			int yl=random.nextInt(12);
			g.drawLine(x,y,x+xl,y+yl);
		}
		// ȡ�����������֤��(4λ����)
		String sRand="";
		for(int i=0;i<4;i++){
			String rand=String.valueOf(random.nextInt(10));
			sRand+=rand;
			// ����֤����ʾ��ͼ����
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
			g.drawString(rand,13*i+6,16);
		}
		// ����֤�����SESSION
		session.setAttribute(sessionAttributeName,sRand);
		// ͼ����Ч
		g.dispose();
		// ���ͼ��ҳ��
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	Color getRandColor(int fc,int bc){
		//������Χ��������ɫ
		Random random = new Random();
		if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}

	public void destroy(){
	}
}
