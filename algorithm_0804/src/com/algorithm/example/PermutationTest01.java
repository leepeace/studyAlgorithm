package com.algorithm.example;

import java.util.Arrays;
import java.util.Scanner;

//nPn : 1~n까지의 수 중 n개를 모두 뽑아 순서적으로 나열하는 것
//nPr : 1~n까지의 수 중 r개를 모두 뽑아 순서적으로 나열하는 것(1<=r<=n)
public class PermutationTest01 {
	
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	static int R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		R = sc.nextInt();
		totalCnt = 0;
		
		numbers = new int[R];
		//numbers = new int[N];
		isSelected = new boolean[N+1];//수가 1부터 시작해서 인덱스도 1부터 논리적 매칭 사용
		
		perm(0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//cnt : 직전까지 뽑은 순열에 포함된 수의 개수
	//cnt+1번째 해당하는 순열에 포함될 수를 뽑기
	public static void perm(int cnt) {
		
		if(cnt == R) {//기저 조건
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//가능한 모든 수에 대해 시도
		for(int i = 1; i <= N; i++) {
			//시도하는 수가 선택되었는지 판단
			if(isSelected[i]) {
				continue;
			}
			//선택되지 않았다면 수를 사용
			numbers[cnt] = i;
			isSelected[i] = true;
		
			
			//다음 수 뽑으로 가기
			perm(cnt+1);
			
			//사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}
	}
	
	
	
}
