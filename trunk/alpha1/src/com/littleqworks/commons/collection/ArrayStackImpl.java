/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

import java.util.*;

public class ArrayStackImpl<E> implements ArrayStack<E>{
	private ArrayList<E> arrayList=new ArrayList<E>(STACK_SIZE);
	
	/**
	 * 检测堆栈是否为空
	 * @return 如果堆栈为空则返回true，否则返回false
	 */
	public boolean isEmpty(){
		return arrayList.isEmpty();
	}
	
	/**
	 * 检测堆栈是否已满
	 * @return 如果堆栈为满则返回true，否则返回false
	 */
	public boolean isFull(){
		return arrayList.size()==STACK_SIZE;
	}

	/**
	 * 弹出栈顶元素
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E pop() throws StackEmptyException{
		if(arrayList.isEmpty()){
			throw new StackEmptyException("ArrayStack is empty.");
		}
		E temp=arrayList.get(arrayList.size()-1);
		arrayList.remove(arrayList.size()-1);
		return temp;
	}
	
	/**
	 * 将一个元素压入堆栈
	 * @param element 元素
	 */
	public void push(E element) throws StackOverflowException{
		if(isFull()){
			throw new StackOverflowException("ArrayStack overflows.");
		}
		arrayList.add(element);
	}
	
	/**
	 * 获取栈顶元素，但不改变堆栈的结构
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E getTopElement() throws StackEmptyException{
		if(arrayList.isEmpty()){
			throw new StackEmptyException("ArrayStack is empty.");
		}
		return arrayList.get(arrayList.size()-1);
	}
}
