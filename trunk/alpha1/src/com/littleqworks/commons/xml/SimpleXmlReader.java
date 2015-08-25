/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.xml;

/**
 * SimpleXmlReader.java
 * @author 谭孟泷
 * @version 0.01
 * Last Date: 07-Jun-07
 * Description: 简化的XML文件解析器.
 */

public class SimpleXmlReader {
	private static XmlReader xmlReader=new XmlReader();

	public boolean loadFile(String filePath,
												String nodeName,
												String attributeName,
												String attributeValue)
												throws XmlReaderException{
		if((nodeName==null)||(nodeName.equals(""))){
			throw new XmlReaderException("nodeName is null.");
		}
		if((attributeName==null)||(nodeName.equals(""))){
			throw new XmlReaderException("attributeName is null.");
		}
		if((attributeValue==null)||(nodeName.equals(""))){
			throw new XmlReaderException("attributeValue is null.");
		}
		return xmlReader.loadFile(filePath, "//"+nodeName+"[@"+attributeName+"='"+attributeValue+"']");
	}
	
	public String getAttributeValue(String attributeName){
		return xmlReader.getAttributeValue(attributeName);
	}
	
	public String getChildElementValue(String childName){
		return xmlReader.getChildElementValue(childName);
	}
}
