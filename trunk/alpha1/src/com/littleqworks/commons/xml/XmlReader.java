/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.xml;

/**
 * XmlReader.java
 * @author ̷����
 * @version 0.01
 * Last Date: 26-May-07
 * Description: XML�ļ�������..
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
	 * ��ȡXML�ļ�.
	 * @param filePath XML�ļ�·��.
	 * @param XPath XPath���.
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
	 * ��ȡ��Ԫ����ֵ.
	 * @param childName ��Ԫ������.
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
	 * ��ȡ��ǰԪ�ص�������ֵ.
	 * @param attributeName ������.
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
