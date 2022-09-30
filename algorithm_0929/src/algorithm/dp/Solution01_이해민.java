package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//아파트 색칠하기
public class Solution01_이해민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/*int[] dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 3;
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);*/
		
		int[][] memo = new int[N+2][2];
		
		//memo[n][0] = n번째 층을 노란색으로 칠할 때
		//memo[n][1] = n번째 층을 파란색으로 칠할 때
		 
		memo[1][0] = 1;
		memo[1][1] = 1;
		
		for (int i = 2; i <= N; i++) {
			memo[i][0] = memo[i-1][0] + memo[i-1][1];
			memo[i][1] = memo[i-1][0];
		}
		System.out.println(memo[N][0] + memo[N][1]);
	}
	
}
