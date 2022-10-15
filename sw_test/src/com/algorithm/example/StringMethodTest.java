package com.algorithm.example;

public class StringMethodTest {
	public static void main(String[] args) {
		
		//문자열->char 배열
		//1. toCharArray : 문자열을 한 글자씩 쪼개서 이를 char 타입의 배열에 집어넣음
		String tmp = "hello world";
		char[] test = tmp.toCharArray();
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println();
	
		//////////////////////////////////////////
		//2. 문자열 뒤집기
		String str = "EDCBA";
		String str2 = new StringBuilder(str).reverse().toString();
		System.out.println(str2);
		
	}
}
