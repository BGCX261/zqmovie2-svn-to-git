/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

import java.util.*;

public class UniqueArrayList<E>{
	private ArrayList<E> list=new ArrayList<E>();
	
	public ArrayList<E> getList(){
		return list;
	}
	public int size(){
		return list.size();
	}
	
	public void add(E element) throws DuplicationException{
		if(list.indexOf(element)!=-1)
			throw new DuplicationException("Duplicate element:"+element);
		list.add(element);
	}
	
	public E get(int index) throws IndexOutOfBoundsException{
		return list.get(index);
	}
	
	public boolean contains(E element){
		return list.contains(element);
	}

}
