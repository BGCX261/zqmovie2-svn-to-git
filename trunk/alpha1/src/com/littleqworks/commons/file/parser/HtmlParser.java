package com.littleqworks.commons.file.parser;

import java.io.*;
import java.util.*;

import com.littleqworks.commons.collection.*;

public class HtmlParser implements Parser{
	private static int MAX_CHARSET_SEARCH_LENGTH=20;
	private InputStream inputStream;
	private BufferedInputStream bf;
	private String charset=null;
	
	char[] buff=new char[4];

	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream=inputStream;
		this.bf=new BufferedInputStream(inputStream);
	}

	public HtmlPage analyse(){
		HtmlPage htmlPage=new HtmlPage();
		try{
			String str=getWholePage();
			htmlPage.setCharset(getValueByKeyIgnoreCase(str, "charset"));
			htmlPage.setUrls(this.getValueListByKeyIgnoreCase(str,"a href"));
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return htmlPage;
	}
	
	public String getWholePage() throws IOException{
		String wholePage=null;
		try{
			byte[] byteData=new byte[bf.available()];
			bf.read(byteData);
			wholePage=new String(byteData);
			System.out.println(wholePage);
			inputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return wholePage;
	}
	
	public String getValueByKeyIgnoreCase(String str,String key){
		int offset=str.indexOf(key);
		if(offset==-1)
			return null;
		String value=null;
		for(int i1=offset+key.length();i1<offset+MAX_CHARSET_SEARCH_LENGTH;i1++){
			//Find non-space and non-equal-symbol char in str
			if((str.charAt(i1)!=' ')&&(str.charAt(i1)!='=')&&(str.charAt(i1)!='\"')&&(str.charAt(i1)!='\'')){
				for(int i2=i1+1;i2<i1+MAX_CHARSET_SEARCH_LENGTH;i2++){
					//Find non-space char in str
					if((str.charAt(i2)==' ')||(str.charAt(i2)=='"')){
						value=str.substring(i1,i2);
						break;//Reduce
					}
				}
				break;//Reduce
			}
		}
		return value;
	}

	public UniqueArrayList<String> getValueListByKeyIgnoreCase(String str,String key){
		UniqueArrayList<String> valueList=new UniqueArrayList<String>();
		
		key=key.toLowerCase();
		int keyLength=key.length();
		
		int offset=str.indexOf(key);
		if(offset==-1){
			System.out.println("Can not find elements.");
			return valueList;
		}
		for(int i1=0;i1<str.length()-keyLength;i1++){
			if((str.charAt(i1)==key.toUpperCase().charAt(0))||(str.charAt(i1)==key.charAt(0))){//Reduce
				//Search key
				if(str.substring(i1, i1+keyLength).equalsIgnoreCase(key.toLowerCase())){
					//find key
					for(int i2=i1+keyLength;i2<i1+MAX_CHARSET_SEARCH_LENGTH;i2++){
						//Find non-space char in str
						if((str.charAt(i2)!=' ')&&(str.charAt(i2)!='=')){
							for(int i3=i2+1;i3<str.length();i3++){
								//Find non-space char in str
								if((str.charAt(i3)==' ')||(str.charAt(i3)=='"')||(str.charAt(i3)=='\n')){
									try {
										System.out.println(str.substring(i2+1,i3));
										valueList.add(str.substring(i2+1,i3));
									}catch(DuplicationException e){}
									break;//Reduce
								}
							}
							break;//Reduce
						}
					}
					continue;
				}
			}
		}
		
		return valueList;
	}
}
