package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_Fibo_MemoTest {
	static long[] cals1, cals2, memo;
	static long calCnt1, calCnt2;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		cals1 = new long[N+1];//각 항을 계산하기 위한 수행 횟수 
		cals2 = new long[N+1];
		
		calCnt1 = calCnt2 = 0;//총 수행 횟수
		
		memo = new long[N+1];
		Arrays.fill(memo, -1);//메모되지 않는 상태를 나타내는 값으로 초기화
		
		//처음부터 계산이 가능한 값 초기화
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println("ans : " + fibo1(N));
		System.out.println(calCnt1);
		
		for (int i = 0; i <= N; i++) { 
			System.out.println("fibo1(" + i + ") : " + cals1[i]);
		}
		System.out.println("----------------------------");
		
		
		System.out.println("ans : " + fibo2(N));
		System.out.println(calCnt2);
		
		for (int i = 0; i <= N; i++) { 
			System.out.println("fibo2(" + i + ") : " + cals2[i]);
		}
		System.out.println("----------------------------");
		
	}
	
	static long fibo1(int n) {//메모하지 않는 버전
		calCnt1++;
		cals1[n]++;
		
		if(n <= 1) return n;//1항이면 1, 0항이면 0
		return fibo1(n-1) + fibo1(n-2);
	}
	
	static long fibo2(int n) {//메모하는 버전
		calCnt2++;
		cals2[n]++;
		
		if(memo[n] == -1) {//메모가 안 된 상태
			memo[n] = fibo2(n-1) + fibo2(n-2);//계산 후 메모
		}
		return memo[n];//메모된 값 리턴
	}
	
}
