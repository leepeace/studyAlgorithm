package algorithm.slidingwindow;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * 슬라이딩 윈도우
 * 배열의 부분합 구하기
 * */
public class SlidingWindowTest {
	public static void main(String[] args) {
		// 1. 입력부
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = r.nextInt(30);
		}
		
		System.out.println(Arrays.toString(arr));

		// 2. 연산부
		int sum = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];//다음 값을 더함
			cnt++;
			if(cnt >= K) {
				System.out.println(arr[i-K+1]);
				sum -= arr[i-K+1];//가장 앞의 값을 뺌
			}
		}
		
	}
}
