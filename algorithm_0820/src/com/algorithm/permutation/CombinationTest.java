package com.algorithm.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	private static int N;//총 개수
	private static int R;//뽑을 개수
	private static int[] numbers;
	private static int totalCount;
	private static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];//전체 n개 배열
		numbers = new int[R];//전체 r개 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0,0);
		
		System.out.println("총 경우의 수 : " + totalCount);
	} 
	
	
	/**
	 * @param cnt 직전까지 뽑은 조합에 포함된 수의 개수
	 * @param start 시도할 수의 시작 위치
	 */
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			totalCount++;
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//start부터 처리하여 수를 중복되게 뽑는 경우를 방지하며, 순서가 다른 조합 추출 방지
		for (int i = start; i < N; i++) {
			//앞쪽에서 선택되지 않았다면 현재 수를 선택함
			numbers[cnt] = input[i];
			//다음 수를 뽑으러 가기
			combination(cnt+1, i+1);
		}
		
	}
	
}
