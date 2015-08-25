/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.xml;

/**
 * XmlReader.java
 * @author 谭孟泷
 * @version 0.01
 * Last Date: 26-May-07
 * Description: XML文件解析类..
 */

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Attribute;
import java.util.List;
import java.util.Iterator;
import org.dom4j.io.XMLWriter;
import java.io.*;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader; 

public class XmlReader{
	private Document doc=null;
	private SAXReader saxReader=null;
	private Element parentElement=null;

	/**
	 * 读取XML文件.
	 * @param filePath XML文件路径.
	 * @param XPath XPath语句.
	 */
	public boolean loadFile(String filePath,String XPath){
		try{
			saxReader=new SAXReader();
			doc=saxReader.read(
					new File(filePath));
			List li=doc.selectNodes(XPath);
			Iterator iter1=li.iterator();
			while(iter1.hasNext()){
				parentElement=(Element)iter1.next();
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	/**
	 * 读取子元素数值.
	 * @param childName 子元素名字.
	 */
	public String getChildElementValue(String childName){
		try{
			Element childElement=parentElement.element(childName);
			if(childElement==null) return null;
			return childElement.getText();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 读取当前元素的属性数值.
	 * @param attributeName 属性名.
	 */
	public String getAttributeValue(String attributeName){
		try{
			Attribute attribute=parentElement.attribute(attributeName);
			return attribute.getText();
		}catch(NullPointerException npe){
			System.err.println("Invalid element, or no element is selected currently.");
			return null;
		}
	}

}
