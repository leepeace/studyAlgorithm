package com.algorithm.boj;

import java.util.Scanner;

public class Main_11659_02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//수의 개수
		int M = sc.nextInt();//합을 구해야 하는 횟수
		
		int[] num = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] subSum = new int[N+1];
		subSum[0] = num[0];
		for(int i = 1; i <= N; i++) {
			subSum[i] = subSum[i-1] + num[i];
		}
	
		//i번째 수부터 j번째 수까지 합을 구함
		//sum[j] - sum[i]
		for(int l = 0; l < M; l++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			System.out.println(subSum[j] - subSum[i-1]);
		}
		
		sc.close();
	}
	
	
}
