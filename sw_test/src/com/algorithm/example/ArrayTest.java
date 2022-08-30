package com.algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayTest {
	public static void main(String[] args) throws IOException {
		
		/*char[][] map = new char[5][5];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		////////////////String->Char 배열로 변환///////////////////////////
		String str = "123456";
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("---------------------");
		////////////////////////2차원 배열 초기화////////////////////////
		char[][] arr2 = new char[10][10];
		
		for(char[] row : arr2) {
			Arrays.fill(row, 'a');
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	
		///////////////////////1차원 배열 초기화/////////////////////
		boolean[] check = new boolean[20];
		
		Arrays.fill(check, true);
		
		for (int i = 0; i < check.length; i++) {
			System.out.print(check[i] + " ");
		}
		System.out.println();
		System.out.println("---------------------");

		////////////////구간 지정하여 초기화////////////////////
		int[] arr3 = new int[] {0,1,2,3,4,5,6,7};
		//[2]~[3]인덱스의 값을 채워줌
		Arrays.fill(arr3, 2, 4, 101);
		
		System.out.println(Arrays.toString(arr3));
	}
}
