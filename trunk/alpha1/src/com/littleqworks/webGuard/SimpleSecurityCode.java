/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.webGuard;

/**
* VerifyCode.java
* @author 谭孟泷
* @version 0.03
* Last Date: 29-Mar-07
* Description: 验证码.
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
		//设置页面不缓存
		HttpSession session=request.getSession();

		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象
		int width=60, height=20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 设定背景色
		g.setColor(getRandColor(155,254));
		//g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, width, height);
		//设定字体
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		//画边框
		//g.setColor(new Color());
		//g.drawRect(0,0,width-1,height-1);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160,220));

		//生成随机类
		Random random = new Random();

		for(int i=0;i<155;i++){
			int x=random.nextInt(width);
		    int y=random.nextInt(height);
			int xl=random.nextInt(12);
			int yl=random.nextInt(12);
			g.drawLine(x,y,x+xl,y+yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand="";
		for(int i=0;i<4;i++){
			String rand=String.valueOf(random.nextInt(10));
			sRand+=rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand,13*i+6,16);
		}
		// 将认证码存入SESSION
		session.setAttribute(sessionAttributeName,sRand);
		// 图象生效
		g.dispose();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	Color getRandColor(int fc,int bc){
		//给定范围获得随机颜色
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
