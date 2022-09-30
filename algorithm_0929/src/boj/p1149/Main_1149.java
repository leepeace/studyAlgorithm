package boj.p1149;

import java.util.Scanner;

/*
 * boj 1149 rgb거리
 * */
public class Main_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] costs = new int[N][N];
		
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < costs.length; j++) {
				costs[i][j] = sc.nextInt();
			}
		}
		
		//costs[i][0] : 빨강색
		//costs[i][1] : 초록색
		//costs[i][2] : 파랑색
		
	}
	
	private static void solve(int[][] costs, int r, int c) {
		int [][] dp = new int[costs.length][costs.length];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		
 		for (int i = 0; i < dp.length; i++) {
			if(i == 1 || i == dp.length-1) {
				//1번째 줄은 2번째 줄만, 마지막 줄은 그 전 줄만 확인
				
			}else {
				
			}
		}
	}
}
