package com.algorithm.example;

import java.util.Scanner;

/*
 * 부분 집합
 * 1. 조합을 이용한 구현
 * 2. 재귀를 이용한 구현
 * */
public class SubSetTest {
	private static int N;//숫자 총 개수
	private static int[] input;
	private static boolean[] isSelected;//수 선택 여부 확인
	private static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}
	
	
	/**
	 * n개의 수를 입력받고 가능한 모든 부분 집합을 생성
	 * @param index 부분집합에 고려할 원소
	 */
	private static void subset(int index) {
		if(index == N) {//더 이상 고려할 원소가 없다면 부분집합의 구성이 완성됨
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		
		//원소 선택 
		isSelected[index] = true;
		subset(index+1);
		
		//원소 미선택
		isSelected[index] = false;
		subset(index+1);
		
	}
	
}
