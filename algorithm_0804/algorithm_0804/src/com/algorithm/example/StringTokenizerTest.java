package com.algorithm.example;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String str = "this is string tokenizer test";
		
		StringTokenizer st = new StringTokenizer(str);
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		
		
	}
}
