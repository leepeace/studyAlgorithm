package com.algorithm.test;

public class StringTest {
	public static void main(String[] args) {
		
		String str1 = "first string!";
		String str2 = "second string!";
		
		System.out.println(str1+str2);
		
		StringBuilder stringBuilder = new StringBuilder(str1);
		stringBuilder.append(str2);
		
		System.out.println(stringBuilder);
		
		System.out.println(str1.concat(str2));
		
	}
}
