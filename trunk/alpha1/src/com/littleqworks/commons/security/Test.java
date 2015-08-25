package com.littleqworks.commons.security;

import java.util.*;

import com.littleqworks.commons.security.util.SecurityUtils;

public class Test {
	public static void main(String[] args) {
//		Scanner cin=new Scanner(System.in);
//		System.out.println("MD5 : "+Encrypt.getMD5(cin.next()));
		System.out.println(SecurityUtils.isSqlInjectionAttack("1=1"));

	}

}
