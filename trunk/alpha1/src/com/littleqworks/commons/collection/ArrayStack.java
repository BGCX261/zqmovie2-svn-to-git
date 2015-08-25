/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

/**
 * 泛型数组堆栈接口
 * @author 谭孟泷<TanMenglong@gmail.com>
 *
 * @param <E> 数组堆栈存储的元素类型
 * @version 0.001
 */
public interface ArrayStack<E> extends Stack<E>{
	/** 堆栈尺寸 */
	public final static int STACK_SIZE=1000;
}
