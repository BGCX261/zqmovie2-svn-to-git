package com.littleqworks.commons.file.parser;

import com.littleqworks.commons.collection.*;

public class HtmlPage implements Document{
	private String charset;
	private String body;
	private String title;
	private String head;
	private UniqueArrayList<String> urls=new UniqueArrayList<String>();
	
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public UniqueArrayList<String> getUrls() {
		return urls;
	}
	public void setUrls(UniqueArrayList<String> urls) {
		this.urls = urls;
	}
	public void addUrl(String url) throws DuplicationException{
		urls.add(url);
	}
}
