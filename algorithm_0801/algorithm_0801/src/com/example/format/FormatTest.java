package com.example.format;

public class FormatTest {

	public static void main(String[] args) {
	
		//반올림하기
		System.out.printf("%.3f\n", 1.123455);
		System.out.println("round()함수 사용 :  " + Math.round(1.123455*1000)/1000.0);
	}

}
