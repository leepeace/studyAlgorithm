package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준 2839번 설탕배달
 * 그리디 알고리즘
 * */
public class Main_2839 {
	static int result;
	private static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		search();
		System.out.println(result);
	}
	
	private static void search() {
		int cnt = 0;
		
		//1. 5kg으로 나누어 떨어지는지 확인
		//2. 5kg으로 나누어지지 않는 경우에는 나머지를 3으로 나눈다.
		//3-1. 3으로 바로 나누어 떨어지지 않는 경우
		//-> N에서 3kg을 빼고, 다시 5로 나누기(반복)
		//3-2. 3으로 나누어 떨어지는 경우
		//n=0인 경우 종료, n < 0 이면 -1 
		while(true) {
			if(N <= 0) break;
			
			//5로 나누어 떨어지는 경우
			if(N % 5 == 0) {
				cnt += N / 5;
				break;
			}
			
			
			N = N - 3;
			cnt++;
		}
		
		if(N < 0) {
			cnt = -1;
		}
		
		result = cnt;
	}
	
}
