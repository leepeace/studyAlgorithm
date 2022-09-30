package algorithm.dp;

import java.io.IOException;

//막대 색칠하기
public class Solution_02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] dp = new int[20];
		
		dp[1] = 2;//1cm인 경우
		dp[2] = 5;//2cm인 경우
		
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1] * 2 + dp[i-2];
		}
		
		
		System.out.println(dp[6]);
	}
	
	//Ncm 막대 경우의 수?
	//1cm 노란 막대 + n-1cm 막대
	//1cm 파란 막대 + n-1cm 막대
	//2cm 빨간 막대 + n-2cm 막대
	
	//dp[n] : ncm를 만드는 경우의 수
	//dp[n][0] = dp[n-1]
	//dp[n][1] = dp[n-1]
	//dp[n][2] = dp[n-2]
	
	//dp[n] = dp[n-1] + dp[n-1] + dp[n-2]
}
