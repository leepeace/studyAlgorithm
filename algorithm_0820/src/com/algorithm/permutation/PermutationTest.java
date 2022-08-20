package com.algorithm.permutation;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2022.08.22 알고리즘 과목 평가 대비
 * 1. 순열 : 순서가 상관이 있음
 * 2. 조합 : 순서가 상관이 없음
 * 3. 부분집합
 * */
public class PermutationTest {
	private static int N;//총 개수
	private static int R;//뽑을 개수
	private static boolean[] isSelected;
	private static int[] numbers;
	private static int totalCount;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//총 개수
		R = sc.nextInt();//뽑을 개수
		
		numbers = new int[R];
		isSelected = new boolean[N+1];
	
		permutation(0);
		
		System.out.println("총 경우의 수 : " + totalCount);
	}//end of main
	
	
	
	/**
	 * @param cnt 직전까지 뽑은 순열에 포함된 수의 개수
	 * cnt + 1번째 해당하는 순열에 포함될 수를 뽑기
	 */
	public static void permutation(int cnt) {
		if(cnt == R) {//탈출 조건 : R개의 수를 전부 뽑은 경우
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수에 대해 시도
		for (int i = 1; i <= N; i++) {
			//시도한 수가 선택되었는지 판단함
			if(isSelected[i]) continue;
			
			//선택되지 않았다면 현재 수를 사용함
			numbers[cnt] = i;
			isSelected[i] = true;
			
			//다음 수를 뽑으러 가기
			permutation(cnt+1);
			
			//사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}
	}
	
}//end of Class
