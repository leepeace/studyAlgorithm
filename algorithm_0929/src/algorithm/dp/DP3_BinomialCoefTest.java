package algorithm.dp;

import java.util.Scanner;

public class DP3_BinomialCoefTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[N+1][K+1];
		
		//dp[n][k] = dp[n-1][k-1] + dp[n-1][k]
		for (int i = 0; i <= N; i++) {
			int end = Math.min(i, K);
			for (int j = 0; j <= end; j++) {
				if(j == 0 || j == i) 
					dp[i][j] = 1;//아무것도 안뽑거나 전부 뽑은 경우는 1
				else 
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				
			}
		}
		System.out.println(dp[N][K]);
	}
}
