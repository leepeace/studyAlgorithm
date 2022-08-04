package com.algorithm.boj;

import java.util.Scanner;

/*
 * 문제 : 백준, 2167번
 * 유형 : 누적합
 * 출력 : (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합
 * */
public class Main_2167 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//행
		int M = sc.nextInt();//열
		
		int[][] num = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		
		int K = sc.nextInt();//합을 구할 부분의 개수
		
		//누적합을 구함
		int[][] dp = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + num[i][j];
			}
		}
		
		//출력 : (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합
		for(int l = 0; l < K; l++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int result = dp[x][y] - dp[i][y] - dp[x][j] + dp[i][j]; 
			System.out.println(result);
		}
		
	}//end main
	
}
