package com.algorithm.example;

import java.util.Scanner;

public class SubSetTest {
	static int N, totalCnt;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0, new boolean[N]);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	static void subset(int index, boolean[] isSelected) {
		if(index == N) {
			totalCnt++;
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		
		//현재 원소 선택
		isSelected[index] = true;
		subset(index+1, isSelected);		
		
		//현재 원소 미선택
		isSelected[index] = false;
		subset(index+1, isSelected);
		
	}
	
	
}
