package com.algorithm.example;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("Hello World");
		sb2.insert(sb2.length(), "!!");
		
		System.out.println(sb2);
		
	}
}
