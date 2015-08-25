/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

/**
 * ���Ͷ�ջ�ӿ�
 * @author ̷����<TanMenglong@gmail.com>
 *
 * @param <E> ��ջ�洢��Ԫ������
 */
public  interface Stack<E> {	
	/**
	 * ����ջ�Ƿ�Ϊ��
	 * @return �����ջΪ���򷵻�true�����򷵻�false
	 */
	public boolean isEmpty();
	
	/**
	 * ����ջ��Ԫ��
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
	 */
	public E pop() throws StackEmptyException;
	
	/**
	 * ��һ��Ԫ��ѹ���ջ
	 * @param element Ԫ��
	 */
	public void push(E element);
	
	/**
	 * ��ȡջ��Ԫ�أ������ı��ջ�Ľṹ
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
	 */
	public E getTopElement() throws StackEmptyException;
}
