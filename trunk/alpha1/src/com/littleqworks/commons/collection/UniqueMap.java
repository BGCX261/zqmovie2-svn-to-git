/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.collection;

import java.util.*;

public class UniqueMap<K,V>{
	private HashMap<K,V> map=new HashMap<K,V>();
	
	public HashMap<K,V> getMap(){
		return map;
	}
	
	public int size(){
		return map.size();
	}
	
	public void put(K key,V value) throws DuplicationException{
		if(map.get(key)!=null)
			throw new DuplicationException("Duplicate key:"+key);
		map.put(key, value);
	}
}
