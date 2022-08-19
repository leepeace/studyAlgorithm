package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//표의 크기
		int M = Integer.parseInt(st.nextToken());//합을 구해야 하는 횟수
		
		int[][] num = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 누적값 구하기
		int[][] dp = new int[N+1][N+1];
		
		//dp[1][1] = num[1][1];
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				dp[x][y] = dp[x][y-1] + dp[x-1][y] - dp[x-1][y-1] + num[x][y];
			}
		}
		
		
		//(x1, y1) ~ (x2, y2)까지의 합을 구함
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
			System.out.println(result);
		}
		
	}
	
	
}
