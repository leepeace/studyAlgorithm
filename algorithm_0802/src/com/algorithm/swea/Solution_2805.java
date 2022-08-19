package com.algorithm.swea;

import java.util.Scanner;

public class Solution_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					farm[i][j] = sc.nextInt();
				}
			}//입력 끝
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sum += farm[i][j];
				}
			}
			
			int midRow = (N / 2) + 1, midCol = (N / 2) + 1;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < row; col++) {
					sum -= farm[midRow-row][midCol-col];
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
		}//end for
		
		
	}
}
