package com.algorithm.example;

import java.util.Arrays;
import java.util.Scanner;

//nPn : n개의 입력받은 수 중 n개를 모두 뽑아 순서적으로 나열하는 것(입력 수 1~100000)
//nPr : n개의 입력받은 수 중 r개를 모두 뽑아 순서적으로 나열하는 것(1<=r<=n)
public class PermutationTest02 {
	
	static int N, R, totalCnt;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];//전체 n개 배열
		numbers = new int[R];//전체 r개 배열
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		perm(0);
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//cnt : 직전까지 뽑은 순열에 포함된 수의 개수
	//cnt+1번째 해당하는 순열에 포함될 수를 뽑기
	public static void perm(int cnt) {
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수에 대해 시도(input배열의 모든 수 시도)
		for(int i = 0; i < N; i++) {
			//시도하는 수가 선택되었는지 판단
			if(isSelected[i]) {
				continue;
			}
			//앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			//다음 수 뽑으로 가기
			perm(cnt+1);
			
			//사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}
	}
	
	
	
}
