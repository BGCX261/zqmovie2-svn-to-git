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
	 * ����ջ�Ƿ�Ϊ��
	 * @return �����ջΪ���򷵻�true�����򷵻�false
	 */
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	
	/**
	 * ����ջ��Ԫ��
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
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
	 * ��һ��Ԫ��ѹ���ջ
	 * @param element Ԫ��
	 */
	public void push(E element){
		linkedList.add(element);
	}
	
	/**
	 * ��ȡջ��Ԫ�أ������ı��ջ�Ľṹ
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
	 */
	public E getTopElement() throws StackEmptyException{
		if(linkedList.isEmpty()){
			throw new StackEmptyException("LinkedArrayStack is empty.");
		}
		return linkedList.get(linkedList.size()-1);
	}
}
