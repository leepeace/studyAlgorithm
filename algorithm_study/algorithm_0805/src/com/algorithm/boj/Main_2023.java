package com.algorithm.boj;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제 : 백준, 2023번 신기한 소수
 * 접근 유형 : 소수, DFS, 백트래킹
 * */
public class Main_2023 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dfs(0, N);
		
	}
	
	public static boolean checkPrime(int num) {
		if(num < 2) {
			return false;
		}
		
		for(int i = 2; i * i < num; i++) {
			if(num % i == 0) {//소수가 아님
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int num, int digit) {
		if(digit == 0) {
			System.out.println(num);
		}
		for(int i = 1; i < 10; i++) {
			int temp = num * 10 + i;
			if(checkPrime(temp)) {
				dfs(temp, digit-1);
			}
		}
	}
	
	
}
