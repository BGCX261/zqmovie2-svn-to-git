/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

import java.util.*;

public class LinkedStackImpl<E> implements LinkedStack<E>{
	private LinkedList<E> linkedList=new LinkedList<E>();
	
	/**
	 * 检测堆栈是否为空
	 * @return 如果堆栈为空则返回true，否则返回false
	 */
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	
	/**
	 * 弹出栈顶元素
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E pop() throws StackEmptyException{
		if(linkedList.isEmpty()){
			throw new StackEmptyException("LinkedArrayStack is empty.");
		}
		E temp=linkedList.get(linkedList.size()-1);
		linkedList.remove(linkedList.size()-1);
		return temp;
	}
	
	/**
	 * 将一个元素压入堆栈
	 * @param element 元素
	 */
	public void push(E element){
		linkedList.add(element);
	}
	
	/**
	 * 获取栈顶元素，但不改变堆栈的结构
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E getTopElement() throws StackEmptyException{
		if(linkedList.isEmpty()){
			throw new StackEmptyException("LinkedArrayStack is empty.");
		}
		return linkedList.get(linkedList.size()-1);
	}
}
