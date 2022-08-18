package com.algorithm.example.subset;

import java.util.Scanner;

/*
 * n개의 자연수를 입력받고 목표합이 주어지면 목표합에 해당하는 부분집합 출력
 * */

public class SubSetTest {
	static int N, totalCnt,S;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();//목표 합
		
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}
	
	
	/*
	 * @param index : 부분집합에 고려할 대상
	 * @param sum : 누적합
	 */
	private static void subset(int index, int sum) {

		//유망여부를 확인해야 함
		//이미 목표 합이 완성되었을 수 도 있기 때문에 더 이상 고려하지 않아도 됨
		if(sum == S) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i])
					System.out.print(input[i] + "\t");
			}
			System.out.println();
			return;
		}
		
		// >>여기까지 내려온 경우는 sum < S 이거나 sum > S인 경우
		if(sum > S) return;//탈출 조건
		
		//마지막 원소 끝까지 탐색을 갔을때(더 이상 고려할 요소가 없어 끝낸다.)
		if(index == N) return;//탈출 조건
		
		//원소 선택
		isSelected[index] = true;
		subset(index+1, sum + input[index]);
		
		//원소 미선택
		isSelected[index] = false;
		subset(index+1, sum);
	}
	
}
