package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

// 4, 6원 화폐 단위로 고정함
public class DB2_ChangeMinCoinTest2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();//목표 금액 <= 1만원
		
		int[] dp = new int[money+1];//dp[i] = i금액을 만드는 최소 동전 수, 만들 수 없는 경우 INF
		
		int INF = 10000;//가장 작은 화폐단위를 가장 많이 써도 만들 수 없는 큰 값, +1 처리 시 오버 플로우 발생하지 않는 값 
		dp[0] = 0;//0원에 대한 최적해는 0
		for (int i = 1; i <= money; i++) {
			int min = INF;

			if(i >= 4) min = Math.min(min, dp[i-4]+1);
			if(i >= 6) min = Math.min(min, dp[i-6]+1);
			
			dp[i] = min;
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[money] == INF ? -1 : dp[money]);
	}
}
