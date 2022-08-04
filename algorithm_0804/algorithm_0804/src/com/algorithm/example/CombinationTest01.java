package com.algorithm.example;

import java.util.Arrays;
import java.util.Scanner;


//nCr : n개의 입력받은 수 중 r개를 모두 뽑아 순서없이 나열하는 것(1<=r<=n)
public class CombinationTest01 {
	
	static int N, R, totalCnt;
	static int[] numbers, input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];//전체 n개 배열
		numbers = new int[R];//전체 r개 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		comb(0, 0);
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//cnt+1번째 해당하는 조합에 포함될 수를 뽑기
	/**
	 * @param cnt : 직전까지 뽑은 조합에 포함된 수의 개수
	 * @param start : 시도할 수의 시작 위치
	 */
	public static void comb(int cnt, int start) {
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수에 대해 시도(input배열의 모든 수 시도)
		//start부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for(int i = 0; i < N; i++) {
			//start위치부터 처리했으므로 중복체크 필요없음!!
			
			//앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			
			//다음 수 뽑으로 가기
			comb(cnt+1, i+1);
			
		}
	}
	
	
	
}
