package com.algorithm.example;

import java.text.DecimalFormat;

public class PrintFormatTest {
	public static void main(String[] args) {
		double num = 3.14159265359;
		
		//1. 반올림
		//반올림하여 3번째 자리까지 출력		
		System.out.printf("%.3f \n", num);
		
		//String.format
		String result = String.format("%.3f", num);
		System.out.println(result);
		
		//Math.round()를 이용하여 소수점 n번째 자리까지 출력
		//Math.round는 반올림하여 가까운 int형을 리턴한다.
		//따라서, 3번째자리를 구하기 위해 1000을 곱한뒤 double형 리턴을 위해 1000.0으로 나누어준다
		System.out.println(Math.round(num * 1000)/1000.0);
		
		//DecimalFormat클래스 이용
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println(df.format(num));
		
		
		//2. 내림
		System.out.println("-------내림----------");
		System.out.println(Math.floor(num * 1000) / 1000.0);
		
		//3. 올림
		System.out.println("-------올림------------");
		System.out.println(Math.ceil(num * 1000) / 1000.0);
	}
}
