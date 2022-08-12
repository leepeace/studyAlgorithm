package com.algorithm.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * String은 내부의 문자열을 수정할 수 없어 +연산자를 많이 사용하면 
 * String 객체의 수가 늘어나기 때문에 프로그램 성능을 늘리게 하는 원인이 됨
 * */
public class StringBuilderInputTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//capacity로 주어진 개수만큼 문자를 저장할 수 있는 초기버퍼를 만듬
		//StringBuilder sb2 = new StringBuilder(30);
	
		
		/*int tc = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tc; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= N; i++) {		
				sb1.append(i);
			}
			System.out.println(sb1.toString());
			//System.out.println("\n");
		}*/
		
		// 100 * 100 크기의 숫자를 읽어와야 하는 경우
		StringBuilder sb1 = new StringBuilder();//16개의 문자들을 저장할 수 있는 초기버퍼를 만듬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		
		for(int i = 0; i < 100; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 100; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		br.close();
	}
}
