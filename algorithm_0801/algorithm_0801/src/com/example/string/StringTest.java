package com.example.string;

public class StringTest {

	public static void main(String[] args) {
		String str = " _ _ ";
		
		//문자열 연산
		str += str;
		System.out.println(str);
		
		for(int i = 0; i < 2; i++) {
			str += str;
			System.out.println(str);
		}
		
	}
	
}
