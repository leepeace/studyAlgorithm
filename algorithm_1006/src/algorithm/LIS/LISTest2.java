package algorithm.LIS;

import java.util.Arrays;
import java.util.Scanner;

/*
 * DP : 이진 검색 활용
 * 
 * */
public class LISTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];// 수열의 수들
		int[] dp = new int[N];// 동적테이블 : 해당 길이를 만족하는 자리에 오는 수의 최소값

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(dp, 0, size, arr[i]);
			System.out.println(pos);
			if (pos >= 0)
				continue;

			int insertPos = Math.abs(pos) - 1;// 멘뒤 또는 기존 원소의 대체 자리
			dp[insertPos] = arr[i];

			if (insertPos == size)
				size++;
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(size);
	}
}
