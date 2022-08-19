package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 : 백준, 16507번 어두운 건 무서워
 * 접근 유형 : 누적합
 * 출력 : 두 점 (r1, c1)과 (r2, c2)를 꼭짓점으로 하는 직사각형의 밝기 평균
 * */
public class Main_16507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[R+1][C+1];
		for(int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= C; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[R+1][C+1];//누적합을 저장할 배열
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + num[i][j]; 
			}
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = 0,c1 = 0,r2 = 0,c2 = 0;
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			sum = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1];//(r1, c1)과 (r2, c2) 사이의 합
			
			int result = sum / (((c2-c1)+1) * ((r2-r1)+1));
			System.out.println(result);
		}
				

		
	}

}
