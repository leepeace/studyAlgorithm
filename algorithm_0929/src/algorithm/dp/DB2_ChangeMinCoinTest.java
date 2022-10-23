package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

//1, 4, 6원 화폐 단위로 고정함, 동전 개수 무제한
public class DB2_ChangeMinCoinTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();//목표 금액
		
		int[] dp = new int[money+1];//dp[i] = i금액을 만드는 최소 동전 수
		
		int INF = Integer.MAX_VALUE;
		dp[0] = 0;//0원에 대한 최적해는 0
		
		for (int i = 1; i <= money; i++) {
			int min = INF;
			min = Math.min(min, dp[i-1]+1);
			if(i >= 4) min = Math.min(min, dp[i-4]+1);//4원으로 만들 수 있는 금액인 경우
			if(i >= 6) min = Math.min(min, dp[i-6]+1);//6원으로 만들 수 있는 금액인 경우
			
			dp[i] = min;
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[money]);
	}
}
